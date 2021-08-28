package com.mahesh.maheshabnamro.dto;

import com.mahesh.maheshabnamro.entity.AccountEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDto {
    String accountNumber;
    BigDecimal balance;

    public AccountEntity toAccount(){
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountNumber(accountNumber);
        accountEntity.setBalance(balance);
        return accountEntity;
    }
}
