package com.mahesh.maheshabnamro.service.impl;

import com.mahesh.maheshabnamro.dao.AccountDao;
import com.mahesh.maheshabnamro.dto.AccountDto;
import com.mahesh.maheshabnamro.entity.AccountEntity;
import com.mahesh.maheshabnamro.exception.AccountNotFoundException;
import com.mahesh.maheshabnamro.exception.NoDataFoundException;
import com.mahesh.maheshabnamro.service.AccountService;
import com.mahesh.maheshabnamro.util.CommonUtil;
import com.mahesh.maheshabnamro.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDao accountDao;

    @Autowired
    Validator validator;

    @Override
    public List<AccountDto> getAllAccounts() {
        List<AccountEntity> accountList = accountDao.getAllAccounts();
        if (accountList == null || accountList.size() == 0) {
            throw new NoDataFoundException();
        }
        return CommonUtil.toDto(accountList);
    }

    @Override
    public AccountDto getAccountByNumber(String accountNumber) {
        AccountEntity result = null;
        result = accountDao.getAccountByNumber(accountNumber);
        if (result == null) {
            throw new AccountNotFoundException(accountNumber);
        }
        return result.toAccountDto();
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        validator.validateAccount(accountDto);
        AccountEntity accountEntity = accountDto.toAccount();
        accountEntity.setId(getMaxIndex()+1);
        return accountDao.save(accountEntity).toAccountDto();
    }

    public Long getMaxIndex() {
        return accountDao.findMaxId();
    }
}
