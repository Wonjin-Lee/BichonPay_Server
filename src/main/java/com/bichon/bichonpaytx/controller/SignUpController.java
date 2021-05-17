package com.bichon.bichonpaytx.controller;

import com.bichon.bichonpaytx.component.OTPGenerator;
import com.bichon.bichonpaytx.constants.StatusConstants;
import com.bichon.bichonpaytx.dto.UserDto;
import com.bichon.bichonpaytx.service.signup.SignUpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
public class SignUpController {

    @Resource
    private UserDto userInfoSession;

    @Autowired
    private SignUpService signUpService;

    @RequestMapping(value = "/users/creation/auth", method = RequestMethod.POST)
    public String authUserInfo(@RequestBody UserDto userDto, HttpSession commonSession) {
        // 1. 필수값 체크

        // 2. 가입 여부 확인
        String validationResult = signUpService.validateUserInfo(userDto);
        log.debug("가입 여부 확인 결과 : " + validationResult);

        switch (validationResult) {
            case StatusConstants.MEMBER_INFO_NOT_EXIST:
                // 2-1. 미가입자의 경우 - OTP 생성, 세션에 OTP 저장
                String otp = OTPGenerator.generate(6);

                commonSession.setAttribute("OTP", otp);

                // 3. 문자 전송 요청

            case StatusConstants.MEMBER_INFO_MATCHED:
                // 2-2. 기가입자의 경우 - 세션에 유저 데이터 저장, 응답으로 user_id를 내려줌


            case StatusConstants.NAME_NOT_EQUAL:
            case StatusConstants.BIRTH_NOT_EQUAL:
        }

        // Response 반환
        return "Result=0&ResultMsg=SUCCESS";
    }

    @RequestMapping(value = "/users/creation/checkotp", method = RequestMethod.POST)
    public String checkOtp(@RequestBody Map<String, String> requestMap, HttpSession commonSession) {
        try {
            log.debug("Request OTP : " + requestMap.get("otp"));
            log.debug("Session OTP : " + commonSession.getAttribute("OTP"));

            if (!Objects.equals(requestMap.get("otp"), commonSession.getAttribute("OTP"))) {
                throw new IllegalArgumentException("OTP가 일치하지 않습니다.");
            }

            return "Result=0&ResultMsg=SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}