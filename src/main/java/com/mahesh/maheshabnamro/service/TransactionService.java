package com.mahesh.maheshabnamro.service;

import com.mahesh.maheshabnamro.dto.TransactionDto;
import com.mahesh.maheshabnamro.entity.TransactionEntity;

import java.util.List;

public interface TransactionService {
    String makeTransaction(TransactionDto transactionDto);

    TransactionEntity getByTransactionId(long id);

    List<TransactionEntity> getAll();
}
