package org.heartmatch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// ...existing code...

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchDTO {
    private Long id;
    private Long initiatorId;
    private Long targetId;
    private MatchAction action;
    private Boolean isMutual;
    private LocalDateTime createdAt;
}

/**
 * Local enum for match actions. Placed here to ensure DTO compilation
 * when an entity-level enum is not available. Adjust or remove if
 * a central enum is added under org.heartmatch.entity.Match later.
 */
enum MatchAction {
    LIKE,
    DISLIKE,
    SUPERLIKE
}
