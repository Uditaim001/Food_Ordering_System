package com.dinegood.springbootproject.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
public class AESUtil {

    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "d8xgxdc7sJUmSxL5b8bEDjq79pCnL2ss4PiBuyhKoK0=";
    // Static block to load or generate the key
    private static SecretKey getSecretKeyFromBase64(final String SECRET_KEY) {



        return new SecretKeySpec(Base64.getDecoder().decode(SECRET_KEY), "AES");
    }
    public String encrypt(final String data) throws Exception {

        final SecretKey secretKey = getSecretKeyFromBase64(SECRET_KEY);
        final Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    public String decrypt(String encryptedData) throws Exception {
        SecretKey secretKey = getSecretKeyFromBase64(SECRET_KEY);
        Cipher cipher = Cipher.getInstance("AES");
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }


}
