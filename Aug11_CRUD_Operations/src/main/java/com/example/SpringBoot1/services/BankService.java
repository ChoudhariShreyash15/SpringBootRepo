package com.example.SpringBoot1.services;

import com.example.SpringBoot1.entity.Bank;
import com.example.SpringBoot1.exceptions.BankAccNotFoundException;
import com.example.SpringBoot1.repository.Bankrepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankService {

    private final Bankrepo bankrepo;

    public BankService(Bankrepo bankrepo){
        this.bankrepo=bankrepo;
    }

    //GET or Read
    public Bank getBank(int accNo){
        Bank b;
        try {
            b = bankrepo.findById(accNo).orElseThrow(() -> {
                throw new BankAccNotFoundException("No Account");
            });
        }
        catch (BankAccNotFoundException e){
            throw e;
        }
        return b;
    }

    //POST or Create
    public Bank addBank(Bank bank){
        return bankrepo.save(bank);
    }

    //PUT or Update
    public Bank updateBank(Bank bank){
        return bankrepo.save(bank);
    }

    public void deleteBank(int accNo){
        bankrepo.deleteById(accNo);
    }

    //GetByName
    public Optional<Bank> getByName(String name){
        return bankrepo.findByName(name);
    }
}
