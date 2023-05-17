package com.pwc.nic.util;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class EncryptUtil {

    public static String encrypt(String sek, String dataJson) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        byte[] sekBytesEncoded = sek.getBytes();
        byte[] sekBytes = Base64.getDecoder().decode(sekBytesEncoded);
        byte[] dataBytes = dataJson.getBytes();
        Cipher cipher = Cipher.getInstance(Encryption.ENRRYPTION_VALUE.get("AES_ECB_PKCS5PADDING"));
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(sekBytes, Encryption.ENRRYPTION_VALUE.get("AES")));
        byte[] encrypted = cipher.doFinal(dataBytes);
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String message, String key) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] sekBytesEncoded = key.getBytes();
        byte[] sekBytes = Base64.getDecoder().decode(sekBytesEncoded);
        byte[] dataBytes = Base64.getDecoder().decode(message);
        Cipher cipher = Cipher.getInstance(Encryption.ENRRYPTION_VALUE.get("AES_ECB_PKCS5PADDING"));
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(sekBytes, Encryption.ENRRYPTION_VALUE.get("AES")));
        byte[] decrypted = cipher.doFinal(dataBytes);
        return new String(decrypted);
    }

    public static String decryptByRek(String message, String key) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        byte[] sekBytesEncoded = key.getBytes();
        byte[] sekBytes = Base64.getDecoder().decode(sekBytesEncoded);
        byte[] dataBytes = Base64.getDecoder().decode(message);
        Cipher cipher = Cipher.getInstance(Encryption.ENRRYPTION_VALUE.get("AES_ECB_PKCS5PADDING"));
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(sekBytes, Encryption.ENRRYPTION_VALUE.get("AES")));
        byte[] decrypted = cipher.doFinal(dataBytes);
        return Base64.getEncoder().encodeToString(decrypted);
    }

    public static String sign(String message, PrivateKey privateKey) throws Exception {
        Signature sig = Signature.getInstance(Encryption.ENRRYPTION_VALUE.get("SHA1WithRSA"));
        sig.initSign(privateKey);
        sig.update(message.getBytes());
        byte[] signatureBytes = sig.sign();
        return Base64.getEncoder().encodeToString(signatureBytes);
    }

    public static String encrypt(String message, PublicKey publicKey) throws Exception {
        Cipher cipher = initializeCypherWithRSA(publicKey);
        byte[] data = message.getBytes();
        byte[] bytes = cipher.doFinal(data);
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static String decrypt(String message) throws Exception {
        Cipher cipher = initializeCipherWithAES();
        byte[] data = message.getBytes();
        byte[] bytes = cipher.doFinal(Base64.getDecoder().decode(data));
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static Cipher initializeCypherWithRSA(PublicKey publicKey) throws Exception {
        Cipher cipherWithRSA = Cipher.getInstance(Encryption.ENRRYPTION_VALUE.get("RSA"));
        cipherWithRSA.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipherWithRSA;
    }

    private static Cipher initializeCipherWithAES() throws Exception {
        Cipher cipherWithAES = Cipher.getInstance(Encryption.ENRRYPTION_VALUE.get("AES_ECB_PKCS7PADDING"));
        SecretKey sek = new SecretKeySpec(Encryption.ENRRYPTION_VALUE.get("APP_CONSTANT").getBytes(), Encryption.ENRRYPTION_VALUE.get("AES"));
        cipherWithAES.init(Cipher.DECRYPT_MODE, sek);
        return cipherWithAES;
    }

    public static PublicKey readPemPublicKey(String publicKey) throws Exception {
        publicKey = publicKey.replace("\n", "");
        publicKey = publicKey.replace("\r", "");
        Base64.Decoder b64 = Base64.getDecoder();
        byte[] decoded = b64.decode(publicKey);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(decoded);
        KeyFactory kf = KeyFactory.getInstance(Encryption.ENRRYPTION_VALUE.get("RSA"));
        return kf.generatePublic(spec);
    }

    public static PrivateKey readPemPrivateKey(String privateKey) throws Exception {
        privateKey = privateKey.replace("\n", "");
        privateKey = privateKey.replace("\r", "");
        Base64.Decoder b64 = Base64.getDecoder();
        byte[] decoded = b64.decode(privateKey);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decoded);
        KeyFactory kf = KeyFactory.getInstance(Encryption.ENRRYPTION_VALUE.get("RSA"));
        return kf.generatePrivate(spec);
    }
}
