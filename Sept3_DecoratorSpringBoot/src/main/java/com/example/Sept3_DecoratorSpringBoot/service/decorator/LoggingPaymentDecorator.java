package com.example.Sept3_DecoratorSpringBoot.service.decorator;

import com.example.Sept3_DecoratorSpringBoot.repo.PaymentService;
import com.example.Sept3_DecoratorSpringBoot.service.BasicPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
//@Primary
class LoggingPaymentDecorator implements PaymentService {

    private final PaymentService paymentService;

    @Autowired
    public LoggingPaymentDecorator(BasicPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    @Qualifier("loggingPaymentService")
    public void pay(double amount) {
        System.out.println("[LOG] Payment started...");
        paymentService.pay(amount); // delegate actual work
        System.out.println("[LOG] Payment completed!");
    }
}