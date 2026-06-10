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
public class Subscription {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private User user;

    private String planName;
    private double amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Enumerated(EnumType.STRING)
    private SubscriptionStatus subscriptionStatus;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private String transactionId;
    private String paymentProvider;

    private LocalDateTime createdAt = LocalDateTime.now();
}