package com.mahesh.maheshabnamro.controller;

import com.mahesh.maheshabnamro.dto.AccountDto;
import com.mahesh.maheshabnamro.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/get-all")
    public List<AccountDto> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping("/get/{accountNumber}")
    public AccountDto getAccountByNumber(@PathVariable("accountNumber") String accountNumber){
        return accountService.getAccountByNumber(accountNumber);
    }

    @PostMapping("/save")
    public AccountDto createAccountByNumber(@RequestBody AccountDto accountDto){
        return accountService.createAccount(accountDto);
    }
}
