package com.viqsystems.multiplication.Challenges.Repositories;

import com.viqsystems.multiplication.Challenges.Entities.ChallengeAttempt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ChallengeAttemptRepository extends CrudRepository<ChallengeAttempt,Long> {

    /**
     * @return the last 10 attempts for a given user, identified by their alias.
     */
    List<ChallengeAttempt> findTop10ByUserIdAliasOrderByIdDesc(String userAlias);

    /**
     * @return the last attempts for a given user, identified by their alias.
     */
    @Query("SELECT a FROM ChallengeAttempt a WHERE a.userId.alias = ?1 ORDER BY a.id DESC")
    List<ChallengeAttempt> lastAttempts(String userAlias);
}
