package org.heartmatch.repository;

import org.heartmatch.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    Optional<Match> findByInitiatorIdAndTargetId(Long initiatorId, Long targetId);
    List<Match> findByInitiatorId(Long initiatorId);
    List<Match> findByTargetId(Long targetId);

    @Query("SELECT m FROM Match m WHERE (m.initiator.id = :userId OR m.target.id = :userId) AND m.isMutual = true")
    List<Match> findMutualMatches(@Param("userId") Long userId);
}
