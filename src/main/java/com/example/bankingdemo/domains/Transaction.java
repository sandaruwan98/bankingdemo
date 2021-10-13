package com.example.bankingdemo.domains;
import javax.persistence.*;

@Entity
@Table
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String description;
    Double value;
    @ManyToOne
    @JoinColumn(name = "payer_id")
    BankAcc payer;
    @ManyToOne
    @JoinColumn(name = "payee_id")
    BankAcc payee;


    public Transaction() {
    }

    public Transaction(String description, Double value, BankAcc payer, BankAcc payee) {
        this.description = description;
        this.value = value;
        this.payer = payer;
        this.payee = payee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public BankAcc getPayer() {
        return payer;
    }

    public void setPayer(BankAcc payer) {
        this.payer = payer;
    }

    public BankAcc getPayee() {
        return payee;
    }

    public void setPayee(BankAcc payee) {
        this.payee = payee;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", payer=" + payer +
                ", payee=" + payee +
                '}';
    }
}
