package com.bichon.bichonpaytx.component;

import java.security.SecureRandom;

public class OTPGenerator {
    public static String generate(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();

        for (int index = 0; index < length; index++) {
            stringBuilder.append(String.valueOf(secureRandom.nextInt(10)));
        }

        return stringBuilder.toString();
    }
}
