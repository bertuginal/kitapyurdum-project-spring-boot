package com.patika.kitapyurdum.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HashUtil {

    private static final Integer ORDER_CODE_LENGTH = 10;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final Set<String> generatedCodes = new HashSet<>();
    private static final Random random = new Random();

    public static String hashPassword(String password) throws NoSuchAlgorithmException{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encodedHash);
    }

    //--generate order code
    public static String generateOrderCode() {
        String orderCode;
        do {
            orderCode = generateRandomCode();
        } while (generatedCodes.contains(orderCode));
        generatedCodes.add(orderCode);
        return orderCode;
    }

    private static String generateRandomCode() {
        StringBuilder sb = new StringBuilder(ORDER_CODE_LENGTH);
        for (int i = 0; i < ORDER_CODE_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }
    //--end generate order code
}
