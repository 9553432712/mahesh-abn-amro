package com.mahesh.maheshabnamro.util;

import com.mahesh.maheshabnamro.dto.AccountDto;
import com.mahesh.maheshabnamro.entity.AccountEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CommonUtil {
    public static List<AccountDto> toDto(List<AccountEntity> accountEntities){
        return accountEntities.stream().map(a -> a.toAccountDto()).collect(Collectors.toList());
    }

    public static AccountEntity cloneAccountEntity(AccountEntity fromAccountEntityOriginal) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountNumber(fromAccountEntityOriginal.getAccountNumber());
        accountEntity.setBalance(fromAccountEntityOriginal.getBalance());
        accountEntity.setId(fromAccountEntityOriginal.getId());
        return accountEntity;
    }
}
