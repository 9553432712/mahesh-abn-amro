package com.mahesh.maheshabnamro.service;

import com.mahesh.maheshabnamro.dto.AccountDto;

import java.util.List;

public interface AccountService {
    List<AccountDto> getAllAccounts();

    AccountDto getAccountByNumber(String accountNumber);

    AccountDto createAccount(AccountDto accountDto);
}
