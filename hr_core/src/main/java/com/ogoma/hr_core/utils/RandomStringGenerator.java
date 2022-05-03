package com.ogoma.hr_core.utils;

import java.security.SecureRandom;

public class RandomStringGenerator {
    public static String randomStringGenerator(int length, boolean isPassword) {
        String characters_to_choose_from = "";

        //token string can't include some special characters, so use special characters only for password generation
        if (isPassword)
            characters_to_choose_from = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@%*_?#";
        else
            characters_to_choose_from = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        SecureRandom random = new SecureRandom();

        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(characters_to_choose_from.charAt(random.nextInt(characters_to_choose_from.length())));
        }

        return sb.toString();
    }
}

