package org.heartmatch.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.heartmatch.dto.RegisterRequest;
import org.heartmatch.entity.User;
import org.heartmatch.repository.UserRepository;
import org.heartmatch.service.StripeService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final StripeService stripeService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/create-checkout-session")
    public String checkout(@RequestParam String email,
                           @RequestParam String plan) throws Exception {

        return stripeService.createCheckoutSession(email, plan);
    }

    @PostMapping("/webhook")
    public String webhook() {
        // Stripe webhook handle here (payment success/failed)
        return "Webhook received";
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest req) {
        if (userRepository.existsByEmail(req.getEmail())) {
            return ResponseEntity.badRequest().body(Map.of("message", "Email already registered"));
        }

        User user = req.toUserEntity();
        // Hash the password before saving
        user.setPassword(passwordEncoder.encode(req.getPassword()));
        userRepository.save(user);

        return ResponseEntity.ok(Map.of("message", "Registered successfully"));
    }
}