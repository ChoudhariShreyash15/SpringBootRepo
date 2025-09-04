package com.example.Sept3_DecoratorSpringBoot.service;

import com.example.Sept3_DecoratorSpringBoot.repo.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicPaymentService implements PaymentService {
    @Override
    public void pay(double amount) {
        System.out.println("Payment processed of $" + amount);
    }
}

class loggingPaymentDecorator implements PaymentService {

    private final PaymentService paymentService;

    @Autowired
    public loggingPaymentDecorator(BasicPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public void pay(double amount) {
        System.out.println("[LOG] Payment started...");
        paymentService.pay(amount);
        System.out.println("[LOG] Payment completed!");
    }
}
