package com.viqsystems.multiplication.Challenge;

import com.viqsystems.multiplication.Challenges.Entities.Challenge;
import com.viqsystems.multiplication.Challenges.Services.Impl.ChallengeGeneratorServiceImpl;
import com.viqsystems.multiplication.Challenges.Services.Interfaces.ChallengeGeneratorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Random;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
@ExtendWith(MockitoExtension.class)
public class ChallengeGeneratorServiceTest {

    private ChallengeGeneratorService challengeGeneratorService;
/*We use @Spy
to stub an object. The Mockito extension will help to create a Random instance using the
empty constructor and stubbing it for us to override the behavior. This is the simplest
way to get our test to work since the basic Java classes implementing random generators
do not work on interfaces (which we could then simply mock instead of spy)*/
    @Spy
    private Random random;

    @BeforeEach
    public void setUp() {
        challengeGeneratorService = new ChallengeGeneratorServiceImpl(random);
    }

    @Test
    public void generateRandomFactorIsBetweenExpectedLimits() {
// 89 is max - min range
        given(random.nextInt(89)).willReturn(20, 30);
// when we generate a challenge
        Challenge challenge = challengeGeneratorService.randomChallenge();
// then the challenge contains factors as expected
        then(challenge).isEqualTo(new Challenge(31, 41));
    }
}
