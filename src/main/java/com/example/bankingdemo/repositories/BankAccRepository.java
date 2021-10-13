package com.example.bankingdemo.repositories;

import com.example.bankingdemo.domains.BankAcc;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankAccRepository extends CrudRepository<BankAcc,Long> {

    @Query("select a from BankAcc a where a.user.id=?1")
    Optional<BankAcc> findByUser(Long userid);
}
