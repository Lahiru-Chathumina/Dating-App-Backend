package org.heartmatch.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Match {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private User sender;

    @ManyToOne
    private User receiver;

    @Enumerated(EnumType.STRING)
    private MatchStatus status;

    private LocalDateTime createdAt = LocalDateTime.now();

}

enum MatchStatus {
    PENDING,
    ACCEPTED,
    REJECTED
}
