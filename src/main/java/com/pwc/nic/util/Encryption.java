package com.pwc.nic.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import static com.pwc.nic.util.Constants.AES;
import static com.pwc.nic.util.Constants.PADDING;


public class Encryption {

    private static String IV = "IV_VALUE_16_BYTE";
    private static String PASSWORD = "PASSWORD_VALUE";
    private static String SALT = "SALT_VALUE";

    public static final Map<String, String> ENRRYPTION_VALUE = new HashMap<>();

    static {
        ENRRYPTION_VALUE.put("IV", "IV_VALUE_16_BYTE");
        ENRRYPTION_VALUE.put("PASSWORD", "PASSWORD_VALUE");
        ENRRYPTION_VALUE.put("SALT", "SALT_VALUE");
        ENRRYPTION_VALUE.put("AES_ECB_PKCS7PADDING", "AES/ECB/PKCS7PADDING");
        ENRRYPTION_VALUE.put("AES", "AES");
        ENRRYPTION_VALUE.put("RSA", "RSA");
        ENRRYPTION_VALUE.put("SHA1WithRSA", "SHA1WithRSA");
        ENRRYPTION_VALUE.put("AES_CBC_PKCS5Padding", "AES/CBC/PKCS5Padding");
        ENRRYPTION_VALUE.put("AES_ECB_PKCS5PADDING", "AES/ECB/PKCS5PADDING");
        ENRRYPTION_VALUE.put("APP_CONSTANT", "mS8qaWIEdQ4zOr7IGKea40u6LCr2BBOU");
        ENRRYPTION_VALUE.put("PBKDF2WithHmacSHA1", "PBKDF2WithHmacSHA1");
    }

    public static String encrypt(String decrypted) {
        try {
            Cipher c = getCipher(Cipher.ENCRYPT_MODE);
            byte[] encryptedVal = c.doFinal(getBytes(decrypted));
            String s = getString(Base64.getEncoder().encode(encryptedVal));
            return s;
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    public static String decrypt(String encrypted) throws Exception {
        byte[] decodedValue = Base64.getDecoder().decode(getBytes(encrypted));
        Cipher c = getCipher(Cipher.DECRYPT_MODE);
        byte[] decValue = c.doFinal(decodedValue);
        return new String(decValue);
    }

    private static String getString(byte[] bytes) throws UnsupportedEncodingException {
        return new String(bytes, "UTF-8");
    }

    private static byte[] getBytes(String str) throws UnsupportedEncodingException {
        return str.getBytes("UTF-8");
    }

    private static Cipher getCipher(int mode) throws Exception {
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] iv = getBytes(IV);
        c.init(mode, generateKey(), new IvParameterSpec(iv));
        return c;
    }

    private static Key generateKey() throws Exception {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        char[] password = PASSWORD.toCharArray();
        byte[] salt = getBytes(SALT);

        KeySpec spec = new PBEKeySpec(password, salt, 65536, 128);
        SecretKey tmp = factory.generateSecret(spec);
        byte[] encoded = tmp.getEncoded();
        return new SecretKeySpec(encoded, AES);
    }

    public static String encrypt(String sek, String dataJson) throws NoSuchPaddingException, NoSuchAlgorithmException,
        InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        byte[] sekBytesEncoded = sek.getBytes();
        byte[] sekBytes = Base64.getDecoder().decode(sekBytesEncoded);
        byte[] dataBytes = dataJson.getBytes();
        Cipher cipher = Cipher.getInstance(PADDING);
        cipher.init(1, new SecretKeySpec(sekBytes, AES));
        byte[] encrypted = cipher.doFinal(dataBytes);
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String message, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] sekBytesEncoded = key.getBytes();
        byte[] sekBytes = Base64.getDecoder().decode(sekBytesEncoded);
        byte[] dataBytes = Base64.getDecoder().decode(message);
        Cipher cipher = Cipher.getInstance(PADDING);
        cipher.init(2, new SecretKeySpec(sekBytes, AES));
        byte[] decrypted = cipher.doFinal(dataBytes);
        return new String(decrypted);
    }

    public static String decryptByRek(String message, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] sekBytesEncoded = key.getBytes();
        byte[] sekBytes = Base64.getDecoder().decode(sekBytesEncoded);
        byte[] dataBytes = Base64.getDecoder().decode(message);
        Cipher cipher = Cipher.getInstance(PADDING);
        cipher.init(2, new SecretKeySpec(sekBytes, AES));
        byte[] decrypted = cipher.doFinal(dataBytes);
        return Base64.getEncoder().encodeToString(decrypted);
    }

}

