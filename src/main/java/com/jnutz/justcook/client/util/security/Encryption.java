package com.jnutz.justcook.client.util.security;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

public class Encryption
{
    public static byte[] encrypt(char[] password, byte[] salt)
    {
        try
        {
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            PBEKeySpec keySpec = new PBEKeySpec(password, salt, 5000, 512);

            byte[] encrypted = keyFactory.generateSecret(keySpec).getEncoded();

            Arrays.fill(password, '0');

            return encrypted;
        }
        catch(NoSuchAlgorithmException | InvalidKeySpecException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static byte[] addSalt()
    {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[8];
        random.nextBytes(bytes);

        return bytes;
    }
}