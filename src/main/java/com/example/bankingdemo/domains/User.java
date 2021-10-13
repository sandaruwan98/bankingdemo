package com.example.bankingdemo.domains;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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
