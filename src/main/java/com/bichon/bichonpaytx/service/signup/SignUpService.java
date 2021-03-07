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
        try {
            log.debug("START SIGN UP DUPLICATION CHECK!");
            UserDto userInfoFromDB = userMapper.selectUserInfo(userDto.getPhone());

            if (Objects.isNull(userInfoFromDB)) {
                log.debug("Member information does not exist.");
                return StatusConstants.MEMBER_INFO_NOT_EXIST;
            }

            if (!userInfoFromDB.getName().equals(userDto.getName())) {
                log.debug("User name is not correct.");
                return StatusConstants.NAME_NOT_EQUAL;
            }

            if (!userInfoFromDB.getBirth().equals(userDto.getBirth())) {
                log.debug("User birth is not correct.");
                return StatusConstants.BIRTH_NOT_EQUAL;
            }

            // PIN Check 프로세스 진행
            return StatusConstants.MEMBER_INFO_MATCHED;
        } finally {
            log.debug("END SIGN UP DUPLICATION CHECK!");
        }
    }
}
