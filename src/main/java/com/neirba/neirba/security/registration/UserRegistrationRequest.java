package com.neirba.neirba.security.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter @AllArgsConstructor @EqualsAndHashCode @ToString
public class UserRegistrationRequest {
    private String email;
    private String username;
    private String password;

}
