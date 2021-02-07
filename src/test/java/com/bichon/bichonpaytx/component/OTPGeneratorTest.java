package com.bichon.bichonpaytx.component;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OTPGeneratorTest {
    @Test
    public void generateSixDigitOTPTest() {
        String otp = OTPGenerator.generate(6);
        System.out.println("OTP : " + otp);
    }
}