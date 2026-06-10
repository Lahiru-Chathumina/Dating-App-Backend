package org.heartmatch.service;

import org.heartmatch.entity.*;
import org.heartmatch.repository.SubscriptionRepository;
import org.heartmatch.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final SubscriptionRepository subscriptionRepository;

    public User loginCheck(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Subscription subscription = subscriptionRepository
                .findByUserId(user.getId())
                .orElseThrow(() -> new RuntimeException("No subscription found"));

        if (subscription.getSubscriptionStatus() != SubscriptionStatus.ACTIVE) {
            throw new RuntimeException("Your subscription has expired. Please renew your plan.");
        }

        return user;
    }
}