package com.example.bankingdemo.domains;


import java.util.List;
import javax.persistence.*;

@Entity
@Table
public class BankAcc {
    @Id
    Long id;
    Double balance;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

    @OneToMany(mappedBy = "payer")
    List<Transaction> payers;

    @OneToMany(mappedBy = "payee")

    List<Transaction> payees;

    public BankAcc() {
    }

    public BankAcc(Long id, Double balance) {
        this.id = id;
        this.balance = balance;
    }

    public Boolean sendMoney(Double val) {
        if (this.balance>= val) {
            this.balance-=val;
            return true;
        }else {
            return false;
        }
    }

    public void recieveMoney(Double val){
      this.balance+=val;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Transaction> getPayers() {
        return payers;
    }

    public void setPayers(List<Transaction> payers) {
        this.payers = payers;
    }

    public List<Transaction> getPayees() {
        return payees;
    }

    public void setPayees(List<Transaction> payees) {
        this.payees = payees;
    }

    @Override
    public String toString() {
        return "BankAcc{" +
                "id=" + id +
                ", balance=" + balance +
                ", user=" + user +
                '}';
    }
}
