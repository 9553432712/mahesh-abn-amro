package com.mahesh.maheshabnamro.dao;

import com.mahesh.maheshabnamro.common.Status;
import com.mahesh.maheshabnamro.dto.TransactionDto;
import com.mahesh.maheshabnamro.entity.TransactionEntity;

import java.util.List;

public interface TransactionDao {
    TransactionEntity register(TransactionDto transactionDto, Status fail);

    TransactionEntity getByTransactionId(long id);

    List<TransactionEntity> getAllTransactions();
}
