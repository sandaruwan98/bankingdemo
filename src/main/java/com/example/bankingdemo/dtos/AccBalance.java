package com.example.bankingdemo.dtos;

public class AccBalance {
    Long accid;
    Double balance;

    public AccBalance(Long accid, Double balance) {
        this.accid = accid;
        this.balance = balance;
    }

    public Long getAccid() {
        return accid;
    }

    public void setAccid(Long accid) {
        this.accid = accid;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccBalance{" +
                "accid=" + accid +
                ", balance=" + balance +
                '}';
    }
}
