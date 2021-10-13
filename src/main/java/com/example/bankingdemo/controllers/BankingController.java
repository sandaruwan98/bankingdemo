package com.example.bankingdemo.controllers;

import com.example.bankingdemo.domains.BankAcc;
import com.example.bankingdemo.domains.Transaction;
import com.example.bankingdemo.dtos.AccBalance;
import com.example.bankingdemo.dtos.PaymentInfo;
import com.example.bankingdemo.services.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/banking")
public class BankingController {
    final BankingService bankingService;

    @Autowired
    public BankingController(BankingService bankingService) {
        this.bankingService = bankingService;
    }

    @GetMapping("/checkbalance/{accid}")
    public AccBalance checkBalance(@PathVariable("accid") Long accid){
        return bankingService.getBalance(accid);
    }

 @PostMapping("/makepaymet")
    public PaymentInfo makePayment(@RequestBody PaymentInfo info){
        return bankingService.makePayment(info);
    }


}
