package org.heartmatch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.heartmatch.entity.Match;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchDTO {
    private Long id;
    private Long initiatorId;
    private Long targetId;
    private Match.MatchAction action;
    private Boolean isMutual;
    private LocalDateTime createdAt;
}