package com.viqsystems.gamification.Services.Interfaces;

import com.viqsystems.gamification.DTOs.ChallengeSolvedEvent;
import com.viqsystems.gamification.Enums.BadgeType;
import lombok.Value;

import java.util.List;

public interface GameService {

/**
 * Process a new attempt from a given user.
 *
 * * @param challenge the challenge data with user details, factors, etc.
 * * @return a {@link GameResult} object containing the new score and badge
 * cards obtained
 * */
    GameResult newAttemptForUser(ChallengeSolvedEvent challenge);

    @Value
    class GameResult {
        int score;
        List<BadgeType> badges;
    }
}
