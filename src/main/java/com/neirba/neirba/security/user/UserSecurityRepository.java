package com.neirba.neirba.security.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserSecurityRepository extends JpaRepository<UserSecurity, Long> {

    Optional<UserSecurity> findByEmail(String email);
    Optional<UserSecurity> findByUsername(String username);

    @Transactional
    @Modifying
    @Query(value = "UPDATE UserSecurity a SET a.enabled = TRUE WHERE a.email = ?1")
    int enableUser(String email);
}
