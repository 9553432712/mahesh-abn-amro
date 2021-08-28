package com.mahesh.maheshabnamro.entity;

import com.mahesh.maheshabnamro.dto.AccountDto;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "ACCOUNT")
@Data
public class AccountEntity {
    @Id
    long id;
    String accountNumber;
    BigDecimal balance;

    public AccountDto toAccountDto(){
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountNumber(accountNumber);
        accountDto.setBalance(balance);
        return accountDto;
    }
}
