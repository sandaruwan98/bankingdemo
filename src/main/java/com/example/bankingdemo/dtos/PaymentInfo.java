package com.example.bankingdemo.dtos;

import com.example.bankingdemo.domains.Transaction;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class PaymentInfo {
    Long id;
    @JsonProperty("payer_user_id")
    Long payerId;
    @JsonProperty("payee_account")
    Long payeeAccId;

    String description;
    Double value;

    public PaymentInfo(Long payerId, Long payeeAccId, String description, Double value) {
        this.payerId = payerId;
        this.payeeAccId = payeeAccId;
        this.description = description;
        this.value = value;
    }

    public PaymentInfo(Transaction transaction) {
        this.value = transaction.getValue();
        this.description= transaction.getDescription();
        this.id = transaction.getId();
        this.payeeAccId=transaction.getPayer().getUser().getId();
        this.payerId=transaction.getPayee().getId();
    }

    public Transaction toEntity(){
        Transaction t = new Transaction();
        t.setDescription(this.description);
        t.setValue(this.value);

        return t;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ApiModelProperty(name = "payer user id",example = "1",required = true)
    public Long getPayerId() {
        return payerId;
    }

    public void setPayerId(Long payerId) {
        this.payerId = payerId;
    }
    @ApiModelProperty(name = "payee accunt number",example = "3003837")
    public Long getPayeeAccId() {
        return payeeAccId;
    }

    public void setPayeeAccId(Long payeeAccId) {
        this.payeeAccId = payeeAccId;
    }

    @ApiModelProperty(example = "Sample Description",required = true)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ApiModelProperty(name = "paying amount",example = "100.50",required = true)
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
