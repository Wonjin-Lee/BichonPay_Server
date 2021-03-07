package com.bichon.bichonpaytx.mapper;

import com.bichon.bichonpaytx.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserDto selectUserInfo(String phone);
}
