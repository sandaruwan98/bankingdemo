package com.example.bankingdemo.domains;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table
@ApiModel
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    String address;
    LocalDate dob;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    BankAcc bankAcc;


    public User() {
    }

    public User(String username, String password, String address, LocalDate dob, BankAcc bankAcc) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.dob = dob;
        this.bankAcc = bankAcc;
    }
    @ApiModelProperty(example = "1",required = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @ApiModelProperty(example = "lakshan123",required = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /*
    public String getPassword() {
        return password;
    }
    */

    public void setPassword(String password) {
        this.password = password;
    }

    @ApiModelProperty(example = "Abc Road,Town",required = true)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @ApiModelProperty(example = "1998-08-04",required = true)
    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public BankAcc getBankAcc() {
        return bankAcc;
    }

    public void setBankAcc(BankAcc bankAcc) {
        this.bankAcc = bankAcc;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                '}';
    }
}
