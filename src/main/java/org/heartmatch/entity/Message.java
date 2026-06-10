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
public class Message {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private Conversation conversation;

    @ManyToOne
    private User sender;

    private String text;

    private LocalDateTime sentAt = LocalDateTime.now();
}