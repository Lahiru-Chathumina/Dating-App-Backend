package org.heartmatch.controller;

import org.heartmatch.service.StripeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final StripeService stripeService;

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
}