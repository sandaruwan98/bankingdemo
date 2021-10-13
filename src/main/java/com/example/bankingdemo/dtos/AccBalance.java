package com.example.bankingdemo.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AccBalance {
    Long accid;
    Double balance;

    public AccBalance(Long accid, Double balance) {
        this.accid = accid;
        this.balance = balance;
    }
    @ApiModelProperty(name = "Bank account number",example = "3003837",required = true)
    public Long getAccid() {
        return accid;
    }

    public void setAccid(Long accid) {
        this.accid = accid;
    }
    @ApiModelProperty(name = "Account Balance",example = "10000.23",required = true)
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
