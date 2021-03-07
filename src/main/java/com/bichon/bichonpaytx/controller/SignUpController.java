package com.bichon.bichonpaytx.controller;

import com.bichon.bichonpaytx.component.OTPGenerator;
import com.bichon.bichonpaytx.constants.StatusConstants;
import com.bichon.bichonpaytx.dto.UserDto;
import com.bichon.bichonpaytx.service.signup.SignUpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @RequestMapping(value = "/users/creation/auth", method = RequestMethod.POST)
    public String authUserInfo(@RequestBody UserDto userDto) {
        log.debug("NAME : " + userDto.getName());
        log.debug("PHONE : " + userDto.getPhone());
        log.debug("BIRTH : " + userDto.getBirth());

        // 1. 필수값 체크

        // 2. 가입 여부 확인
        String result = signUpService.validateUserInfo(userDto);
        log.debug("Validation Result : " + result);

        switch (result) {
            case StatusConstants.MEMBER_INFO_NOT_EXIST:
                // 2-1. 미가입자의 경우 - OTP 생성, 세션에 OTP 저장
                String otp = OTPGenerator.generate(6);

                // 3. 문자 전송 요청

            case StatusConstants.MEMBER_INFO_MATCHED:
                // 2-2. 기가입자의 경우 - 세션에 유저 데이터 저장, 응답으로 user_id를 내려줌

            case StatusConstants.NAME_NOT_EQUAL:
            case StatusConstants.BIRTH_NOT_EQUAL:
        }

        // Response 반환
        return "Result=0&ResultMsg=SUCCESS";
    }
}
