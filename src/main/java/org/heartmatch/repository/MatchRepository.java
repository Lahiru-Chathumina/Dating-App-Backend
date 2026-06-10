package org.heartmatch.repository;

import org.heartmatch.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MatchRepository extends JpaRepository<Match, UUID> {

    List<Match> findBySender_Id(UUID senderId);

    List<Match> findByReceiver_Id(UUID receiverId);
}