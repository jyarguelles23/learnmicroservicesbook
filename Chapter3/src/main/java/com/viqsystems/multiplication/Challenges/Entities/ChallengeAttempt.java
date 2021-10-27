package com.viqsystems.multiplication.Challenges.Entities;

import com.viqsystems.multiplication.Users.Entities.Users;
import lombok.*;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ChallengeAttempt {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private Users userId;

    private int factorA;
    private int factorB;
    private int resultAttempt;
    private boolean correct;
}
