package com.mahesh.maheshabnamro.service.impl;

import com.mahesh.maheshabnamro.common.Status;
import com.mahesh.maheshabnamro.dao.AccountDao;
import com.mahesh.maheshabnamro.dao.TransactionDao;
import com.mahesh.maheshabnamro.dto.TransactionDto;
import com.mahesh.maheshabnamro.entity.AccountEntity;
import com.mahesh.maheshabnamro.entity.TransactionEntity;
import com.mahesh.maheshabnamro.exception.AccountNotFoundException;
import com.mahesh.maheshabnamro.exception.NoDataFoundException;
import com.mahesh.maheshabnamro.exception.TransactionNotFoundException;
import com.mahesh.maheshabnamro.service.TransactionService;
import com.mahesh.maheshabnamro.util.CommonUtil;
import com.mahesh.maheshabnamro.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    AccountDao accountDao;

    @Autowired
    Validator validator;

    @Autowired
    TransactionDao transactionDao;

    @Override
    public String makeTransaction(final TransactionDto transactionDto) {
        validator.validateTransaction(transactionDto);
        AccountEntity fromAccountEntityOriginal = accountDao.getAccountByNumber(transactionDto.getFromAccountNumber());
        AccountEntity toAccountEntityOriginal = accountDao.getAccountByNumber(transactionDto.getToAccountNumber());
        StringBuilder result = new StringBuilder("Please find transaction number:: ");
        try {
            AccountEntity fromClone = CommonUtil.cloneAccountEntity(fromAccountEntityOriginal);
            fromClone.setBalance(fromClone.getBalance().subtract(transactionDto.getAmount()));
            accountDao.update(fromClone);

            AccountEntity toClone = CommonUtil.cloneAccountEntity(toAccountEntityOriginal);
            toClone.setBalance(toClone.getBalance().add(transactionDto.getAmount()));
            accountDao.update(toClone);
            TransactionEntity transactionEntity = transactionDao.register(transactionDto, Status.SUCCESS);
            result.append(transactionEntity.getId());
        } catch (Exception e) {
            accountDao.update(fromAccountEntityOriginal);
            accountDao.update(toAccountEntityOriginal);
            TransactionEntity transactionEntity = transactionDao.register(transactionDto, Status.FAIL);
            result.append(transactionEntity.getId());
            throw new RuntimeException("Something went wrong, try again after sometime, please find transaction number:: " + transactionEntity.getId());
        }
        return result.toString();
    }

    @Override
    public TransactionEntity getByTransactionId(long id) {
        TransactionEntity result = null;
        result = transactionDao.getByTransactionId(id);
        if (result == null) {
            throw new TransactionNotFoundException(id);
        }
        return result;
    }

    @Override
    public List<TransactionEntity> getAll() {
        List<TransactionEntity> transactionEntities = transactionDao.getAllTransactions();
        if (transactionEntities == null || transactionEntities.size() == 0) {
            throw new NoDataFoundException();
        }
        return transactionEntities;
    }
}
