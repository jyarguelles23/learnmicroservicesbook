package com.viqsystems.gamification.Repositories;

import com.viqsystems.gamification.Entities.BadgeCard;
import com.viqsystems.gamification.Enums.BadgeType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface BadgeRepository extends CrudRepository<BadgeCard,Long> {

    /**
     * Retrieves all BadgeCards for a given user.
     * *
     @param userId the id of the user to look for BadgeCards
      * @return the list of BadgeCards, ordered by most recent first.
     */

    List<BadgeCard> findByUserIdOrderByBadgeTimestampDesc(Long userId);

  //  Set<BadgeType> findByUserIdOrderByBadgeTimestampDesc(Long userId);
}
