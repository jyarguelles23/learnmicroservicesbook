package com.viqsystems.multiplication.Challenge;

import com.viqsystems.multiplication.Challenges.DTOs.ChallengeAttemptDTO;
import com.viqsystems.multiplication.Challenges.Entities.ChallengeAttempt;
import com.viqsystems.multiplication.Challenges.Repositories.ChallengeAttemptRepository;
import com.viqsystems.multiplication.Challenges.Services.Impl.ChallengeServiceImpl;
import com.viqsystems.multiplication.Challenges.Services.Interfaces.ChallengeService;


import com.viqsystems.multiplication.Users.Entities.Users;
import com.viqsystems.multiplication.Users.Repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


public class ChallengeServiceTest {

  /*  private ChallengeService challengeService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private ChallengeAttemptRepository attemptRepository;


    @BeforeEach
    public void setUp() {
        challengeService = new ChallengeServiceImpl(userRepository,attemptRepository);

    }

    @Test
    public void checkCorrectAttemptTest() {
        // given
        given(attemptRepository.save(any())).will(returnsFirstArg());
        ChallengeAttemptDTO attemptDTO =
                new ChallengeAttemptDTO(50, 60, "john_doe", 3000);
// when
        ChallengeAttempt resultAttempt =
                challengeService.verifyAttempt(attemptDTO);
// then
        then(resultAttempt.isCorrect()).isTrue();
        // newly added lines
        verify(userRepository).save(new Users("john_doe"));
        verify(attemptRepository).save(resultAttempt);
        verify(gameClient).sendAttempt(resultAttempt);
    }

    @Test
    public void checkWrongAttemptTest() {
        // given
        given(attemptRepository.save(any()))
                .will(returnsFirstArg());
        ChallengeAttemptDTO attemptDTO =
                new ChallengeAttemptDTO(50, 60, "john_doe", 5000);

        // when
        ChallengeAttempt resultAttempt =
                challengeService.verifyAttempt(attemptDTO);

        // then
        then(resultAttempt.isCorrect()).isFalse();
        verify(userRepository).save(new Users("john_doe"));
        verify(attemptRepository).save(resultAttempt);
        verify(gameClient).sendAttempt(resultAttempt);
    }

    @Test
    public void checkExistingUserTest() {
// given
        given(attemptRepository.save(any())).will(returnsFirstArg());
        Users existingUser = new Users(1L, "john_doe");
        given(userRepository.findByAlias("john_doe"))
                .willReturn(Optional.of(existingUser));
        ChallengeAttemptDTO attemptDTO =
                new ChallengeAttemptDTO(50, 60, "john_doe", 5000);
// when
        ChallengeAttempt resultAttempt =
                challengeService.verifyAttempt(attemptDTO);
// then

        then(resultAttempt.isCorrect()).isFalse();
        then(resultAttempt.getUserId()).isEqualTo(existingUser);
        verify(userRepository, never()).save(any());
        verify(attemptRepository).save(resultAttempt);
        verify(gameClient).sendAttempt(resultAttempt);
    }

    @Test
    public void retrieveStatsTest() {
        // given
        Users user = new Users("john_doe");
        ChallengeAttempt attempt1 = new ChallengeAttempt(1L, user, 50, 60, 3010, false);
        ChallengeAttempt attempt2 = new ChallengeAttempt(2L, user, 50, 60, 3051, false);
        List<ChallengeAttempt> lastAttempts = List.of(attempt1, attempt2);
        given(attemptRepository.findTop10ByUserIdAliasOrderByIdDesc("john_doe"))
                .willReturn(lastAttempts);

        // when
        List<ChallengeAttempt> latestAttemptsResult =
                challengeService.getStatsForUser("john_doe");

        // then
        then(latestAttemptsResult).isEqualTo(lastAttempts);

    }*/
}
