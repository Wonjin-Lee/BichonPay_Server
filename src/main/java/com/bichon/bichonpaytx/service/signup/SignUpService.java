package com.bichon.bichonpaytx.service.signup;

import com.bichon.bichonpaytx.constants.StatusConstants;
import com.bichon.bichonpaytx.dto.UserDto;
import com.bichon.bichonpaytx.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class SignUpService {

    @Autowired
    private UserMapper userMapper;

    public String validateUserInfo(UserDto userDto) {
        UserDto userInfoFromDB = userMapper.selectUserInfo(userDto.getPhone());

        if (Objects.isNull(userInfoFromDB)) {
            log.debug("회원 정보가 존재하지 않습니다.");
            return StatusConstants.MEMBER_INFO_NOT_EXIST;
        }

        if (!Objects.equals(userInfoFromDB.getName(), userDto.getName())) {
            log.debug("가입자의 이름이 올바르지 않습니다.");
            return StatusConstants.NAME_NOT_EQUAL;
        }

        if (!Objects.equals(userInfoFromDB.getBirth(), userDto.getBirth())) {
            log.debug("가입자의 생년월일이 올바르지 않습니다.");
            return StatusConstants.BIRTH_NOT_EQUAL;
        }

        // PIN Check 프로세스 진행
        return StatusConstants.MEMBER_INFO_MATCHED;
    }
}
