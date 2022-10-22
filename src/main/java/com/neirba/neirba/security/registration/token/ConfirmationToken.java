package com.neirba.neirba.security.registration.token;

import com.neirba.neirba.security.user.UserSecurity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor
public class ConfirmationToken {

    @Id
    @Column(updatable = false, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(nullable = false)
    private String token;

    @NonNull
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @NonNull
    @Column(nullable = false)
    private LocalDateTime expiresAt;
    private LocalDateTime confirmedAt;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_user_id"), nullable = false)
    private UserSecurity user;


}
