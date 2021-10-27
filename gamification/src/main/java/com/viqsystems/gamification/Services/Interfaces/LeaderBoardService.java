package com.viqsystems.gamification.Services.Interfaces;

import com.viqsystems.gamification.Entities.LeaderBoardRow;

import java.util.List;

public interface LeaderBoardService {

    /**
     * @return the current leader board ranked from high to low score
     */
    List<LeaderBoardRow> getCurrentLeaderBoard();
}
