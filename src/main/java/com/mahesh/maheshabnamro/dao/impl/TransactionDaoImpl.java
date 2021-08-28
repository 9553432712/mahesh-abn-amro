package com.mahesh.maheshabnamro.dao.impl;

import com.mahesh.maheshabnamro.common.Status;
import com.mahesh.maheshabnamro.dao.TransactionDao;
import com.mahesh.maheshabnamro.dto.TransactionDto;
import com.mahesh.maheshabnamro.entity.TransactionEntity;
import com.mahesh.maheshabnamro.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class TransactionDaoImpl implements TransactionDao {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public TransactionEntity register(TransactionDto transactionDto, Status status) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAmount(transactionDto.getAmount());
        transactionEntity.setFromAccountNumber(transactionDto.getFromAccountNumber());
        transactionEntity.setToAccountNumber(transactionDto.getToAccountNumber());
        transactionEntity.setStatus(status);
        transactionEntity.setId(transactionRepository.getMaxId() + 1);
//        transactionEntity.setCreationDate(new Date());
        return transactionRepository.save(transactionEntity);
    }

    @Override
    public TransactionEntity getByTransactionId(long id) {
        return transactionRepository.getById(id);
    }

    @Override
    public List<TransactionEntity> getAllTransactions() {
        return transactionRepository.findAllByOrderByCreationDateDesc();
    }
}
