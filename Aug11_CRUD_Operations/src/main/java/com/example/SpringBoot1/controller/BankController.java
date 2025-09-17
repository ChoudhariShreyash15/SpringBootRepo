package com.example.SpringBoot1.controller;

import com.example.SpringBoot1.entity.Bank;
import com.example.SpringBoot1.response.ResponseHandler;
import com.example.SpringBoot1.services.BankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BankController {
    private final BankService bankService;

    public BankController(BankService bankService){
        this.bankService=bankService;
    }

    //Read or Select or GET or Retrive
    @GetMapping("/get/{id}")
    public Bank getBank(@PathVariable int id){
        return bankService.getBank(id);
    }

    //Create or add or POST
    @PostMapping("/add")
    public ResponseEntity<ResponseHandler> addBank(@RequestBody Bank bank){
        bankService.addBank(bank);
        ResponseHandler responseHandler = new ResponseHandler("Data Added" , HttpStatus.CREATED, bank);
        return new ResponseEntity<>(responseHandler , HttpStatus.CREATED);
    }

    //Update or PUT
    @PutMapping("/update")
    public ResponseEntity<ResponseHandler> updateBank(@RequestBody Bank bank){
        bankService.updateBank(bank);
        ResponseHandler responseHandler = new ResponseHandler("Data Updated Successfully." , HttpStatus.ACCEPTED,bank);
        return new ResponseEntity<>(responseHandler , HttpStatus.ACCEPTED);
    }

    //Removing or DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseHandler> deleteBank(@PathVariable int id){
        bankService.deleteBank(id);
        ResponseHandler responseHandler = new ResponseHandler("Data Deleted Successfully.", HttpStatus.OK, id);
        return new ResponseEntity<>(responseHandler , HttpStatus.OK);
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<ResponseHandler<Bank>> getByName(@PathVariable String name){
        Optional<Bank> bank = bankService.getByName(name);
        ResponseHandler responseHandler = new ResponseHandler("Data Found", HttpStatus.OK, bank);
        return new ResponseEntity<>(responseHandler , HttpStatus.OK);
    }

}
