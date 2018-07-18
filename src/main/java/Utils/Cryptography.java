/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author gbartholomeu
 */
public class Cryptography {

    public static byte[] getEncryptedPassword(String password, byte[] salt, int iterations, int derivedKeyLength) {
        byte[] hash = null;
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, derivedKeyLength * 8);
        try {
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            hash = f.generateSecret(spec).getEncoded();
        } catch (InvalidKeySpecException | NoSuchAlgorithmException ex) {
            Logger.getLogger(Cryptography.class.getName()).log(Level.SEVERE, null, ex);
        }

        return hash;
    }

    public static boolean isPasswordValid(String hash, String passwordParam, String saltParam, String interationsParam, String keyLength) {
        byte[] salt = saltParam.getBytes(Charset.forName("UTF-8"));
        byte[] Hash = getEncryptedPassword(passwordParam, salt, Integer.parseInt(interationsParam), Integer.parseInt(keyLength));
        String newHash = new String(Hash, StandardCharsets.UTF_8);

        return hash.equalsIgnoreCase(newHash);
    }

    public static byte[] getSecuredByte() {
        Random r = new Random();
        byte[] saltOne = new byte[r.nextInt(20) + 1];
        SecureRandom secure = new SecureRandom();
        secure.nextBytes(saltOne);
        return saltOne;
    }

    public static byte[] getSenhaEncriptografada(byte[] salt, int interations, int keyLength, String rawPassword) {
        byte[] Hash = null;
        Hash = getEncryptedPassword(rawPassword, salt, interations, keyLength);
        return Hash;
    }
}
