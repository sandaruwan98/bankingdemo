package com.example.bankingdemo.controllers;

import com.example.bankingdemo.domains.User;
import com.example.bankingdemo.services.UserService;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @ApiResponses(value = {
        @ApiResponse(code = 500, message = "Server error"),
        @ApiResponse(code = 200, message = "Successful retrieval",response = User.class, responseContainer = "List")
    })
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }


    @ApiResponses(value = {@ApiResponse(code = 500, message = "Server error"), @ApiResponse(code = 200, message = "Successful retrieval", response = User.class, responseContainer = "List"), @ApiResponse(code = 500, message = "Server error"), @ApiResponse(code = 404, message = "Service not found"), @ApiResponse(code = 200, message = "Successful retrieval", response = User.class)})
    @GetMapping("{id}")
    public Optional<User> getUser(@ApiParam(name = "User Id",required = true) @PathVariable("id") Long id ){
        return userService.getUser(id);
    }
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid bank account number"), @ApiResponse(code = 500, message = "A user already registered to given bank account number"), @ApiResponse(code = 200, message = "Successful retrieval", response = User.class, responseContainer = "List"), @ApiResponse(code = 500, message = "Server error"), @ApiResponse(code = 404, message = "Service not found"), @ApiResponse(code = 200, message = "Successful retrieval", response = User.class)})
    @PostMapping("{bankaccid}")
    public User register(@RequestBody User newuser,
                         @ApiParam(name = "Bank account number",required = true,example = "100")
                         @PathVariable("bankaccid") Long bankaccid){
        return userService.addUser(newuser,bankaccid);
    }
}
