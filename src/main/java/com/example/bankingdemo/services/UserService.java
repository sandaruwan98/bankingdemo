package com.example.bankingdemo.services;

import com.example.bankingdemo.domains.BankAcc;
import com.example.bankingdemo.domains.User;
import com.example.bankingdemo.repositories.BankAccRepository;
import com.example.bankingdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    final UserRepository userRepository;
    final BankAccRepository bankAccRepository;

    @Autowired
    public UserService(UserRepository repository, BankAccRepository bankAccRepository) {
        this.userRepository = repository;
        this.bankAccRepository = bankAccRepository;
    }

    public List<User> getAll(){
        return (List<User>) userRepository.findAll();
    }

    public User addUser(User newuser, Long bankaccid) {
        Optional<BankAcc> bankAcc = bankAccRepository.findById(bankaccid);
        if (bankAcc.isPresent()){
            if (bankAcc.get().getUser() == null) {
                bankAcc.get().setUser(newuser);
                newuser.setBankAcc(bankAcc.get());
                return userRepository.save(newuser);
            }
            else throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"A user already registered to given bank account number");

        }else throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid bank account number");


    }


        public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }
}
