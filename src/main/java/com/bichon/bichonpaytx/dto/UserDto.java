package com.bichon.bichonpaytx.dto;

import lombok.Data;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Data
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@ToString
public class UserDto {
    private int id;
    private String pin;
    private String name;
    private String phone;
    private String birth;
    private String email;
    private int wallet_id;
    private String creation_date;
}
