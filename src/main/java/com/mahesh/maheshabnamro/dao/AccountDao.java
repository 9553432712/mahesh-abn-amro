package com.mahesh.maheshabnamro.dao;

import com.mahesh.maheshabnamro.entity.AccountEntity;

import java.util.List;

public interface AccountDao {
    List<AccountEntity> getAllAccounts();

    AccountEntity getAccountByNumber(String accountNumber);

    AccountEntity save(AccountEntity toAccount);

    Long findMaxId();

    void update(AccountEntity fromClone);
}
