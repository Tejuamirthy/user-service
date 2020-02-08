package com.tripshorts.userservice.model;

import org.springframework.security.core.GrantedAuthority;

public class AuthorityClass implements GrantedAuthority {

    @Override
    public String getAuthority() {
        return "USER";
    }
}
