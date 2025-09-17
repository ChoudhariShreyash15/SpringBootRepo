package com.example.Sept3_DecoratorSpringBoot.service;

import com.example.Sept3_DecoratorSpringBoot.repo.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicPaymentService implements PaymentService {
    @Override
    public void pay(double amount) {
        System.out.println("Processing payment of $" + amount);
    }
}