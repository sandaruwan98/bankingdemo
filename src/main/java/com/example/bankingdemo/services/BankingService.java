package com.example.bankingdemo.services;

import com.example.bankingdemo.domains.BankAcc;
import com.example.bankingdemo.domains.Transaction;
import com.example.bankingdemo.dtos.AccBalance;
import com.example.bankingdemo.dtos.PaymentInfo;
import com.example.bankingdemo.repositories.BankAccRepository;
import com.example.bankingdemo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class BankingService {
    final BankAccRepository bankAccRepository;
    final TransactionRepository transactionRepository;

    @Autowired
    public BankingService(BankAccRepository bankAccRepository, TransactionRepository transactionRepository) {
        this.bankAccRepository = bankAccRepository;
        this.transactionRepository = transactionRepository;
    }

    public AccBalance getBalance(Long id) {
        Optional<BankAcc> bankAcc = bankAccRepository.findById(id);
        return new AccBalance(bankAcc.get().getId(), bankAcc.get().getBalance());
    }

    public PaymentInfo makePayment(PaymentInfo info) {

        Optional<BankAcc> payerBankAcc = bankAccRepository.findByUser(info.getPayerId());
        if (!payerBankAcc.isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid user id");

        Optional<BankAcc> payeeBankAcc = bankAccRepository.findById(info.getPayeeAccId());
        if (!payeeBankAcc.isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid payee acc number");

        if (!payerBankAcc.get().sendMoney(info.getValue()))
            throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED,"Not enough balance");



        payeeBankAcc.get().recieveMoney(info.getValue());
        Transaction transaction = info.toEntity();
        transaction.setPayer(payerBankAcc.get());
        transaction.setPayee(payeeBankAcc.get());

        //-----atomic
        bankAccRepository.save(payeeBankAcc.get());
        bankAccRepository.save(payerBankAcc.get());
        Transaction savedTransaction = transactionRepository.save(transaction);

        // -------------
        return new PaymentInfo(savedTransaction);
    }
}
