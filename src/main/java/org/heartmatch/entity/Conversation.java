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
public class Conversation {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private User user1;

    @ManyToOne
    private User user2;

    private LocalDateTime createdAt = LocalDateTime.now();
}