package com.mahesh.maheshabnamro.util;

import com.mahesh.maheshabnamro.dao.AccountDao;
import com.mahesh.maheshabnamro.dto.AccountDto;
import com.mahesh.maheshabnamro.dto.TransactionDto;
import com.mahesh.maheshabnamro.entity.AccountEntity;
import com.mahesh.maheshabnamro.exception.AccountNotFoundException;
import com.mahesh.maheshabnamro.exception.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Validator {
    @Autowired
    AccountDao accountDao;

    public void validateTransaction(final TransactionDto transactionDto) {
        if (transactionDto.getAmount() == null || transactionDto.getToAccountNumber() == null || transactionDto.getFromAccountNumber() == null
                || transactionDto.getToAccountNumber().length() == 0 || transactionDto.getFromAccountNumber().length() == 0
                || transactionDto.getAmount().compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidInputException();
        }
        AccountEntity fromAccountEntity = accountDao.getAccountByNumber(transactionDto.getFromAccountNumber());
        if (fromAccountEntity == null) {
            throw new AccountNotFoundException(transactionDto.getFromAccountNumber());
        }
        if (fromAccountEntity.getBalance().compareTo(transactionDto.getAmount()) < 0) {
            throw new InvalidInputException();
        }
        fromAccountEntity = accountDao.getAccountByNumber(transactionDto.getToAccountNumber());
        if (fromAccountEntity == null) {
            throw new AccountNotFoundException(transactionDto.getToAccountNumber());
        }
    }


    public void validateAccount(AccountDto accountDto) {
        if (accountDto.getAccountNumber() == null || accountDto.getBalance() == null) {
            throw new RuntimeException("Invalid Account");
        }
    }
}
