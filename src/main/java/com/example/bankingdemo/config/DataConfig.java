package com.example.bankingdemo.config;

import com.example.bankingdemo.domains.BankAcc;
import com.example.bankingdemo.repositories.BankAccRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataConfig {
    @Bean
    CommandLineRunner commandLineRunner(BankAccRepository bankAccRepository){
        return args -> {
            BankAcc ac1 = new BankAcc(100L,1000.20);
            BankAcc ac2 = new BankAcc(3003835L,2500.50);
            BankAcc ac3 = new BankAcc(3003836L,10000.0);
            BankAcc ac4 = new BankAcc(3003837L,4560.25);

            bankAccRepository.saveAll(List.of(ac1,ac2,ac3,ac4));
        };
    }
}
