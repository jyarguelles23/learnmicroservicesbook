package com.viqsystems.gamification.Entities;

import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.With;

import java.util.List;

@Value
@AllArgsConstructor
public class LeaderBoardRow {

    Long userId;
    Long totalScore;
    /*
    * The @With annotation added to the badges field is provided by Lombok and generates
a method for us to clone an object and add a new field value to the copy (in this case,
withBadges). This is a good practice when we work with immutable classes since they
don’t have setters. We’ll use this method when we create the business logic to merge the
score and the badges for each leaderboard row.
    * */
    @With
    List<String> badges;
    public LeaderBoardRow(final Long userId, final Long totalScore) {
        this.userId = userId;
        this.totalScore = totalScore;
        this.badges = List.of();
    }

}
