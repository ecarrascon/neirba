package com.neirba.neirba.security;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserSecurityRepository {

    Optional<UserSecurity> findByEmail(String email);
}
