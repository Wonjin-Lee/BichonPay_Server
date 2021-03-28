package com.bichon.bichonpaytx.component;

import lombok.extern.slf4j.Slf4j;

import java.security.SecureRandom;

@Slf4j
public class OTPGenerator {
    public static String generate(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();

        for (int index = 0; index < length; index++) {
            stringBuilder.append(secureRandom.nextInt(10));
        }

        log.debug("Generated OTP : " + stringBuilder.toString());

        return stringBuilder.toString();
    }
}
