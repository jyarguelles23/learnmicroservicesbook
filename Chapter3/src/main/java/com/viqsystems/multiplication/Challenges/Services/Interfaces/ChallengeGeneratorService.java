package com.viqsystems.multiplication.Challenges.Services.Interfaces;

import com.viqsystems.multiplication.Challenges.Entities.Challenge;

public interface ChallengeGeneratorService {
    /**
     * @return a randomly-generated challenge with factors between 11 and 99
     */
    Challenge randomChallenge();


}
