package com.example.Sept3_DecoratorSpringBoot.controller;

import com.example.Sept3_DecoratorSpringBoot.repo.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(@Qualifier("loggingPaymentService") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/pay")
    public String pay() {
        paymentService.pay(100.0);
        return "Payment Successful!";
    }
}
