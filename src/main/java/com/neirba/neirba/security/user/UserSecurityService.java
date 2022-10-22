package com.neirba.neirba.security.user;


import com.neirba.neirba.security.registration.token.ConfirmationToken;
import com.neirba.neirba.security.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserSecurityService implements UserDetailsService {

    private final UserSecurityRepository userSecurityRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userSecurityRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User  '" + username + "' not found"));
    }

    public String signUpUser(UserSecurity user) {

        boolean userExists = userSecurityRepository.findByEmail(user.getEmail()).isPresent() ||
                userSecurityRepository.findByUsername(user.getUsername()).isPresent();
        //TODO If the same user dind confirm the email, send other one if wanted.
        if (userExists) {
            throw new IllegalStateException("email/user already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());


        user.setPassword(encodedPassword);

        userSecurityRepository.save(user);


        String token = UUID.randomUUID().toString();
        // TODO Change 15 minutes in a configuration file no harcoded
        ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15), user);

        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }

public int enableUser(String email) {
        return userSecurityRepository.enableUser(email);
    }

}
