package com.mahesh.maheshabnamro.dao.impl;

import com.mahesh.maheshabnamro.dao.AccountDao;
import com.mahesh.maheshabnamro.entity.AccountEntity;
import com.mahesh.maheshabnamro.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountDaoImpl implements AccountDao {
    @Autowired
    AccountRepository accountRepository;


    @Override
    public List<AccountEntity> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public AccountEntity getAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public AccountEntity save(AccountEntity toAccount) {
        return accountRepository.save(toAccount);
    }

    @Override
    public Long findMaxId() {
        return accountRepository.getMaxId();
    }

    @Override
    public void update(AccountEntity fromClone) {
        accountRepository.update(fromClone.getBalance(), fromClone.getAccountNumber());
    }
}
