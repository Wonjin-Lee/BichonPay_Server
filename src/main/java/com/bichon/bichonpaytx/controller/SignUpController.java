package com.bichon.bichonpaytx.controller;

import com.bichon.bichonpaytx.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SignUpController {

    @RequestMapping(value = "/users/creation/auth", method = RequestMethod.POST)
    public String authUserInfo(@RequestBody UserDto userDto) {
        log.debug("PHONE : " + userDto.getPhone());
        log.debug("NAME : " + userDto.getName());

        // 1. 필수값 체크

        // 2. 가입 여부 확인

        // 3. OTP 생성

        // 4. 문자 전송 요청

        String result = "Result=0&ResultMsg=SUCCESS";

        return result;
    }
}
