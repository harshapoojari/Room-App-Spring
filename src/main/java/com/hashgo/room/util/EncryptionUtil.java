package com.hashgo.room.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class EncryptionUtil {
	
    
    private static final String ALGORITHM = "AES";
    private static final byte[] KEY = "qwertyuio0poiuyt".getBytes(); // 16-byte AES key

    // Encrypts data using AES
    public static String encrypt(String data) throws Exception {
        SecretKey secretKey = new SecretKeySpec(KEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    // Decrypts AES-encrypted data
    public static String decrypt(String encryptedData) throws Exception {
        SecretKey secretKey = new SecretKeySpec(KEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedData);
    }

    // Converts a Base64-encoded string to a SecretKey
    public static SecretKey getKeyFromString(String key) {
        return new SecretKeySpec(Base64.getDecoder().decode(key), ALGORITHM);
    }

    // Converts a SecretKey to a Base64-encoded string
    public static String keyToString(SecretKey key) {
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }
}
