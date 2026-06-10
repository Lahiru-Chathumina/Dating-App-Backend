package org.heartmatch.service;

import org.heartmatch.entity.*;
import org.heartmatch.repository.SubscriptionRepository;
import org.heartmatch.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;

    public Subscription createSubscription(User user, String plan) {

        Subscription sub = new Subscription();
        sub.setUser(user);
        sub.setPlanName(plan);
        sub.setPaymentStatus(PaymentStatus.PENDING);
        sub.setSubscriptionStatus(SubscriptionStatus.EXPIRED);

        if (plan.equals("BASIC")) sub.setAmount(5);
        if (plan.equals("PREMIUM")) sub.setAmount(10);
        if (plan.equals("VIP")) sub.setAmount(20);

        return subscriptionRepository.save(sub);
    }

    public void activateSubscription(Subscription sub, String transactionId) {
        sub.setPaymentStatus(PaymentStatus.PAID);
        sub.setSubscriptionStatus(SubscriptionStatus.ACTIVE);
        sub.setTransactionId(transactionId);
        sub.setStartDate(LocalDateTime.now());
        sub.setEndDate(LocalDateTime.now().plusMonths(1));

        subscriptionRepository.save(sub);
    }
}