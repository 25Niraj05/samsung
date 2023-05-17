package com.pwc.nic.services;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pwc.nic.model.AuthToken;
import com.pwc.nic.repository.AuthTokenRepository;
import com.pwc.nic.util.*;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import static com.pwc.nic.util.Constants.*;


@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
	static {
		Security.addProvider(new BouncyCastleProvider());
		Security.setProperty("crypto.policy", "unlimited");
	}

	@Autowired
	private Environment env;

	@Autowired
	private AuthTokenRepository redisRepo;

	@Autowired
	private RestTemplate restTemplate;

	private boolean useTokenCache;
	private PrivateKey privateKey;
	private PublicKey serverPublicKey;
	private String authURL;
	public static String genIrnUrl;
	public static String genEwbByrnUrl;
	private static String certificate;

	private String appKey;

	//	@PostConstruct
	public void postConstruct(String customerId, String is_live){
		try {
			if(null!=env.getProperty(customerId+"_props.AUTH_EWAY_URL")
					&& !"".equalsIgnoreCase(env.getProperty(customerId+"_props.AUTH_EWAY_URL"))) {
				logger.info("----Getting Client Level Properties----");
				serverPublicKey = readPemPublicKey(env.getRequiredProperty(customerId+"_props.public_key"));
				privateKey = readPemPrivateKey(env.getRequiredProperty(customerId+"_props.private_key"));
				certificate = env.getRequiredProperty(customerId+"_props.Certificate");
				authURL = env.getRequiredProperty(customerId+"_props.AUTH_EWAY_URL");
				genIrnUrl = env.getRequiredProperty(customerId+"_props.GENERATE_EINVOICE_URL");
				genEwbByrnUrl= env.getRequiredProperty(customerId+"_props.GET_EWB_BY_IRN_URL");
				useTokenCache= Boolean.parseBoolean(env.getRequiredProperty(customerId+"_props.use.token.cache"));
			}
			else if(null!=is_live && !"".equalsIgnoreCase(is_live)&& is_live.equalsIgnoreCase("Y")) {
                logger.info("----Getting Anonymous Production Properties----");
                serverPublicKey = readPemPublicKey(env.getRequiredProperty("anonymous_production.public_key"));
                privateKey = readPemPrivateKey(env.getRequiredProperty("anonymous_production.private_key"));
                certificate = env.getRequiredProperty("anonymous_production.Certificate");
                authURL = env.getRequiredProperty("anonymous_production.AUTH_EWAY_URL");
                genIrnUrl = env.getRequiredProperty("anonymous_production.GENERATE_EINVOICE_URL");
				genEwbByrnUrl= env.getRequiredProperty("anonymous_production.GET_EWB_BY_IRN_URL");
                useTokenCache= Boolean.parseBoolean(env.getRequiredProperty("anonymous_production.use.token.cache"));
            }
            else
            {
                logger.info("----Getting Anonymous Staging Properties----");
                serverPublicKey = readPemPublicKey(env.getRequiredProperty("anonymous_staging.public_key"));
                privateKey = readPemPrivateKey(env.getRequiredProperty("anonymous_staging.private_key"));
                certificate = env.getRequiredProperty("anonymous_staging.Certificate");
                authURL = env.getRequiredProperty("anonymous_staging.AUTH_EWAY_URL");
                genIrnUrl = env.getRequiredProperty("anonymous_staging.GENERATE_EINVOICE_URL");
				genEwbByrnUrl= env.getRequiredProperty("anonymous_staging.GET_EWB_BY_IRN_URL");
                useTokenCache= Boolean.parseBoolean(env.getRequiredProperty("anonymous_staging.use.token.cache"));
            }
		} catch (Exception e) {
			logger.info("Exception while getting data from property file as: ",e);
		}
	}

	@Override
	public ApiResponse authenticate(String gstin, String userName, String password, Integer customerid, String is_live)
			throws Exception {
		logger.debug("AUTHENTICATION process started for GSTIN : {}", gstin);
		Map<String, String> authResponse =new ConcurrentHashMap<>();
		ApiResponse response = new ApiResponse();
		response.setError(true);
		response.setMessage("Authentication Failed for GSTIN : "+gstin);
		postConstruct(String.valueOf(customerid),is_live);
		if (useTokenCache) {
			try{
			AuthToken token = redisRepo.findById(gstin).orElse(null);
			if ( token != null && !tokenExpired(token)) {
				logger.error("Cache hit for gstin:{}", gstin);
				Map<String, String> map = redis(token.getId(), token.getResponse(), userName);
				map.put(GSTIN, gstin);
				map.put("generateFrom", "Redis");
				response.setError(false);
				response.setMessage("Authentication Successfully");
				response.setData(map);
				return response;
			} else if (token != null && tokenExpired(token))
				logger.error("Cache expired for {}", gstin);
			}
			catch(Exception e){
				logger.error("Exception occurred while checking redis,exception trace as: ",e);
			}
		}
		logger.error("Cache miss for gstin: {}", gstin);
		for (int i = 1; i < 3; i++) {
			try {
				logger.info("Generate authtoken count no : {} ", i);
				authResponse = generateAuthToken(gstin, userName, password);
				break;
			} catch (ResourceAccessException e) {
				Thread.sleep(10000);
				logger.error("In Attempt {} Exception while calling auth api stack trace as:{}", i, e);
			}
		}
		if (authResponse.isEmpty()) {
			response.setStatus(String.valueOf(0));
			return response;
		}

			//Awanish chanage done
		authResponse.put(GSTIN, gstin);
		authResponse.put("generateFrom", "NIC");
		logger.info("auth response is:{}",authResponse);
		if(authResponse.get(Constants.STATUS).equalsIgnoreCase("1"))
		{
			response.setError(false);
			response.setMessage("Authentication Successful for GSTIN : "+gstin);
			response.setData(authResponse);
		}
		else
		{
			response.setError(true);
			response.setMessage("Authentication Failed for GSTIN : "+gstin);
			JSONArray errors=new JSONArray(authResponse.get("ErrorDetails"));
			JSONObject errorDetails=null;
			for (int i = 0; i < errors.length(); i++) {
				errorDetails = errors.getJSONObject(i);
			}
			response.setData(new JSONObject().put(Constants.ERROR_DETAILS,errorDetails));
		}
		return response;
	}

	private boolean tokenExpired(AuthToken token) throws JSONException, ParseException {
		JSONObject response=new JSONObject(token.getResponse());
		JSONObject data=response.getJSONObject(DATA);
		String tokenExpiry=data.getString("TokenExpiry");
		logger.info("token expiry is:{} for gstin:{}",tokenExpiry,token.getId());
		return (getLongDate(tokenExpiry) - Constants.expiryTime) <= System.currentTimeMillis();
	}
	private Long getLongDate(String date) throws  ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date newDate = formatter.parse(date);
		return newDate.getTime();
	}
	private Map<String, String> generateAuthToken(String gstin, String userName, String password)
		throws Exception {
		Map<String, String> generateAuthTokenRes;
			String timeStamp = Utils.formattedCurrentDateAtServerTimeZone();
			String tkey = createTKey(gstin, userName, timeStamp);
			String authKey = sign(tkey, privateKey);
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json");
			headers.add(GSTIN, gstin);
			headers.add("X-Asp-Auth-Signature", authKey);
			headers.add("X-Asp-Auth-Token", tkey);
			String encryptedPwd;
			String appKey;
			String requestJson;
			JSONObject jsonObj = new JSONObject();
		if(authURL.contains(Constants.AUTH_URL_VERSION))
		{
			encryptedPwd = password;
			appKey = encryptAppKeyV4();
			jsonObj.put("UserName", userName).put("Password", encryptedPwd).put("AppKey", appKey).put("ForceRefreshAccessToken", false);
			String requestJsoneEnc=Base64.getEncoder().encodeToString(jsonObj.toString().getBytes());
			requestJson = new JSONObject().put(DATA, encrypt(requestJsoneEnc)).toString();
		}
		else
		{
			encryptedPwd = encrypt(password);
			appKey = encryptAppKey();
			jsonObj.put("UserName", userName).put("Password", encryptedPwd).put("AppKey", appKey).put("ForceRefreshAccessToken", false);
			requestJson = new JSONObject().put(PAYLOAD_DATA, jsonObj).toString();
		}
			HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
			logger.info("Auth URL {}",authURL);
			logger.info("Authentication EInvoice API Headers are:{} and UserName is:{}", headers, userName);
		logger.info("Authentication EInvoice API Request Body is:{}", requestJson);
			ResponseEntity<String> responseEntity = restTemplate.postForEntity(authURL, entity, String.class);
			logger.info("generateAuthToken postForEntity Http Response code : {} and body :{}",
					responseEntity.getStatusCode(), responseEntity.getBody());
			if (Utils.isError(responseEntity.getStatusCode())) {
				throw new Exception("Business Exception in Authentication");
			} else {
				String responseBody = responseEntity.getBody();
				JSONObject resJson = new JSONObject(responseBody);
				String authStatus = resJson.getString(Constants.STATUS);
				if (null != authStatus && authStatus.equals("1")) {
					logger.info("EInvoice-Authentication response success for gstin : {} with authStatus : {}", gstin, authStatus);
				if (useTokenCache) {
					redisRepo.save(new AuthToken(gstin, responseBody, userName));
				}
					generateAuthTokenRes= parseSuccessResponse(userName, tkey, authKey,resJson, authStatus);
				} else {
					logger.info("EInvoice-Authentication response failed for gstin : {} with authStatus : {}", gstin, authStatus);
					generateAuthTokenRes= parseFailureResponse(resJson,authStatus);
				}
			}
		return generateAuthTokenRes;
	}

	private Map<String, String> redis(String id, String responseBody, String txnId)
		throws JSONException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, NoSuchPaddingException,
		IllegalBlockSizeException, BadPaddingException {
		JSONObject resJson = new JSONObject(responseBody);
		String timeStamp = Utils.formattedCurrentDateAtServerTimeZone();
		String tkey = createTKey(id, txnId, timeStamp);
		String authKey = sign(tkey, privateKey);
		return parseSuccessResponse("Redis", tkey, authKey,resJson, resJson.getString(Constants.STATUS));
	}

	private static Map<String, String> parseFailureResponse(JSONObject resJson, String authStatus) throws JSONException {
		Map<String, String> generateAuthTokenRes = new HashMap<>();
		generateAuthTokenRes.put(Constants.STATUS, authStatus);
		generateAuthTokenRes.put(Constants.AUTH_RESPONSE_PLAINTEXT_JSON, resJson.toString());
		generateAuthTokenRes.put(Constants.ERROR, resJson.getString("ErrorDetailirn-ges"));
		return generateAuthTokenRes;
	}

	private static Map<String, String> parseSuccessResponse(String userName, String tkey, String authKey,JSONObject resJson, String authStatus)
		throws JSONException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException,
		BadPaddingException, InvalidKeyException {
		Map<String, String> generateAuthTokenRes = new HashMap<>();
		JSONObject data=resJson.getJSONObject(DATA);
		String decryptedSek = decrypt(data.getString(SEK));
		generateAuthTokenRes.put(Constants.AUTHTOKEN, data.getString(Constants.AUTHTOKEN));
		generateAuthTokenRes.put(Constants.STATUS, authStatus);
		generateAuthTokenRes.put(Constants.AUTH_RESPONSE_PLAINTEXT_JSON, resJson.toString());
		generateAuthTokenRes.put(Constants.AUTHKEY, authKey);
		generateAuthTokenRes.put(Constants.TKEY, tkey);
		generateAuthTokenRes.put(SEK, decryptedSek);
		JSONObject plaintextJson=new JSONObject(resJson.toString());
		generateAuthTokenRes.put(Constants.USER_NAME, plaintextJson.getJSONObject(DATA).getString("UserName"));
		return generateAuthTokenRes;
	}

	private String createTKey(String gstin, String txnId, String timeStamp) {
			return new StringBuilder().append(env.getRequiredProperty("version")).append(COLON)
				.append(env.getRequiredProperty("customerId")).append(COLON).append(env.getRequiredProperty("clientId"))
				.append(COLON).append(txnId.trim()).append(COLON).append(timeStamp).append(COLON).append(gstin).append(
					COLON).append(Constants.accessToken).toString();
	}

	private String sign(String message, PrivateKey privateKey)
		throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
		Signature sig = Signature.getInstance("SHA1WithRSA");
		sig.initSign(privateKey);
		sig.update(message.getBytes());
		byte[] signatureBytes = sig.sign();
		return Base64.getEncoder().encodeToString(signatureBytes);
	}

	private String encrypt(String message) throws NoSuchPaddingException, NoSuchAlgorithmException,
		InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = initializeCypherWithRSA();
		byte[] data = message.getBytes();
		byte[] bytes = cipher.doFinal(data);
		return Base64.getEncoder().encodeToString(bytes);
	}

	private static String decrypt(String message)
		throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException,
		BadPaddingException {
		Cipher cipher = initializeCipherWithAES();
		byte[] data = message.getBytes();
		byte[] bytes = cipher.doFinal(Base64.getDecoder().decode(data));
		return Base64.getEncoder().encodeToString(bytes);
	}

	private String encryptAppKey()
		throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException,
		InvalidKeyException {
		if (appKey != null && !appKey.isEmpty()) {
			return appKey;
		} else {
			appKey = encrypt(Constants.APP_CONSTANT);
		}
		return appKey;
	}
	private String encryptAppKeyV4() {
		return Base64.getEncoder().encodeToString(Constants.APP_CONSTANT.getBytes());
	}


	private Cipher initializeCypherWithRSA()
		throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
		Cipher cipherWithRSA = Cipher.getInstance(RSA);
		cipherWithRSA.init(Cipher.ENCRYPT_MODE, serverPublicKey);
		return cipherWithRSA;
	}

	private static Cipher initializeCipherWithAES()
		throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
		Cipher cipherWithAES = Cipher.getInstance("AES/ECB/PKCS7PADDING");
		SecretKey sek = new SecretKeySpec(Constants.APP_CONSTANT.getBytes(), AES);
		cipherWithAES.init(Cipher.DECRYPT_MODE, sek);
		return cipherWithAES;
	}

	private PublicKey readPemPublicKey(String publicKeyPath) throws NoSuchAlgorithmException, InvalidKeySpecException {
		Base64.Decoder b64 = Base64.getDecoder();
		byte[] decoded = b64.decode(publicKeyPath);
		X509EncodedKeySpec spec = new X509EncodedKeySpec(decoded);
		KeyFactory kf = KeyFactory.getInstance(RSA);
		return kf.generatePublic(spec);
	}

	private PrivateKey readPemPrivateKey(String privateKeyPath) throws NoSuchAlgorithmException,
		InvalidKeySpecException {
		Base64.Decoder b64 = Base64.getDecoder();
		byte[] decoded = b64.decode(privateKeyPath);
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decoded);
		KeyFactory kf = KeyFactory.getInstance(RSA);
		return kf.generatePrivate(spec);
	}
//	 public void testConnectivity() {
//	 try {
//	 ResponseEntity<String> responseEntity = restTemplate.exchange("https://yoda.api.vayanagsp.in/gus/ping",
//	 HttpMethod.GET, null, String.class);
//		 logger.info("Connection Status : {}", responseEntity.getBody());
//	 } catch (Exception e) {
//		 logger.error("Exception trace : {}",e);
//	 }
//	 }
public static boolean verifySignature(String signature,String data) throws InvalidKeyException, CertificateException, NoSuchAlgorithmException, SignatureException {
//	 String certificate = "MIIFzDCCBLSgAwIBAgIDCacNMA0GCSqGSIb3DQEBCwUAMIHiMQswCQYDVQQGEwJJTjEtMCsGA1UEChMkQ2Fwcmljb3JuIElkZW50aXR5IFNlcnZpY2VzIFB2dCBMdGQuMR0wGwYDVQQLExRDZXJ0aWZ5aW5nIEF1dGhvcml0eTEPMA0GA1UEERMGMTEwMDkyMQ4wDAYDVQQIEwVERUxISTEnMCUGA1UECRMeMTgsTEFYTUkgTkFHQVIgRElTVFJJQ1QgQ0VOVEVSMR8wHQYDVQQzExZHNSxWSUtBUyBERUVQIEJVSUxESU5HMRowGAYDVQQDExFDYXByaWNvcm4gQ0EgMjAxNDAeFw0xODA5MTIwOTIwMzFaFw0yMDA5MTIwOTIwMzFaMIGTMQswCQYDVQQGEwJJTjEkMCIGA1UEChMbTkFUSU9OQUwgSU5GT1JNQVRJQ1MgQ0VOVFJFMSEwHwYDVQQLExhOSUMgS0FSTkFUQUtBIFNUQVRFIFVOSVQxFjAUBgNVBAMTDVNVUkVTSCBDIE1FVEkxDzANBgNVBBETBjU2MDAwMTESMBAGA1UECBMJS0FSTkFUQUtBMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArxd93uLDs8HTPqcSPpxZrf0Dc29r3iPp0a8filjAyeX4RAH6lWm9qFt26CcE8ESYtmo1sVtswvs7VH4Bjg/FDlRpd+MnAlXuxChij8/vjyAwE71ucMrmZhxM8rOSfPML8fniZ8trr3I4R2o4xWh6no/xTUtZ02/yUEXbphw3DEuefzHEQnEF+quGji9pvGnPO6Krmnri9H4WPY0ysPQQQd82bUZCk9XdhSZcW/am8wBulYokITRMVHlbRXqu1pOFmQMO5oSpyZU3pXbsx+OxIOc4EDX0WMa9aH4+snt18WAXVGwF2B4fmBk7AtmkFzrTmbpmyVqA3KO2IjzMZPw0hQIDAQABo4IB1jCCAdIwEQYDVR0OBAoECEN8abh/fKGIMIGnBgNVHSAEgZ8wgZwwgZkGBmCCZGQCAjCBjjBABggrBgEFBQcCARY0aHR0cHM6Ly93d3cuY2VydGlmaWNhdGUuZGlnaXRhbC9yZXBvc2l0b3J5L2Nwc3YxLnBkZjBKBggrBgEFBQcCAjA+GjxDbGFzcyAyIENlcnRpZmljYXRlIGlzc3VlZCBieSBDYXByaWNvcm4gQ2VydGlmeWluZyBBdXRob3JpdHkwHQYDVR0RBBYwFIESU1VSRVNILk1FVElATklDLklOMBMGA1UdIwQMMAqACEOABKAHteDPMIGIBggrBgEFBQcBAQR8MHowLAYIKwYBBQUHMAGGIGh0dHA6Ly9vY3ZzLmNlcnRpZmljYXRlLmRpZ2l0YWwvMEoGCCsGAQUFBzAChj5odHRwczovL3d3dy5jZXJ0aWZpY2F0ZS5kaWdpdGFsL3JlcG9zaXRvcnkvQ2Fwcmljb3JuQ0EyMDE0LmNlcjAOBgNVHQ8BAf8EBAMCBSAwRAYDVR0fBD0wOzA5oDegNYYzaHR0cHM6Ly93d3cuY2VydGlmaWNhdGUuZGlnaXRhbC9jcmwvQ2Fwcmljb3JuQ0EuY3JsMA0GCSqGSIb3DQEBCwUAA4IBAQAY6jYgheYXf1iDi/bHj3Jb+fwjYawijdPFIpY231RFIQTl10iyH3oenkexsRp+peExvEZYath8YLBgAFZeBYaA1yrgILF3n2OlxrP/8Pvp1QSpfYXIwqZ69s6zi3YVOB9eukyqTwfHXBQl9nBJ8cHNdiH5giHKUL29y4GizDQc6sBOd7Ek/14ULRawJ2qYEBNQXWU6Or7EaTC9/8Kxvqo3FFfskQLGt0sDJjEji7ubB1dfjTDAaf6ojriPZO6DMqxVBYanNdkM9Ce07mlykwzu2klMIRAt5CYh4KWRjN0vRf0zYBDdBuzyi3+HKvDFNH+L55axjezf8kJwrhvbdNCm";
	String certString = "-----BEGIN CERTIFICATE-----\r\n" + certificate + "\r\n-----END CERTIFICATE-----";
	Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
	CertificateFactory cf = CertificateFactory.getInstance("X.509");
		InputStream stream = new ByteArrayInputStream(certString.getBytes()); //StandardCharsets.UTF_8
		java.security.cert.Certificate cert = cf.generateCertificate(stream);
		PublicKey pk = cert.getPublicKey();
		Signature sig = Signature.getInstance("SHA256withRSA");
		sig.initVerify( pk );
		sig.update(data.getBytes());
	byte[] signature1 = org.apache.commons.codec.binary.Base64.decodeBase64(signature);
		return sig.verify(signature1);
	}

}
