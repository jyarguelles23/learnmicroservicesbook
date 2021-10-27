package com.viqsystems.gamification.Components;

import com.viqsystems.gamification.DTOs.ChallengeSolvedEvent;
import com.viqsystems.gamification.Entities.ScoreCard;
import com.viqsystems.gamification.Enums.BadgeType;
import com.viqsystems.gamification.Services.Interfaces.BadgeProcessor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SilverBadgeProcessor implements BadgeProcessor {
    @Override
    public Optional<BadgeType> processForOptionalBadge(int currentScore, List<ScoreCard> scoreCardList, ChallengeSolvedEvent solved) {
        return currentScore > 150 ? Optional.of(BadgeType.SILVER) : Optional.empty();
    }

    @Override
    public BadgeType badgeType() {
        return BadgeType.SILVER;
    }
}
