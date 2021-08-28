package com.mahesh.maheshabnamro.dto;

import com.mahesh.maheshabnamro.entity.AccountEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionDto {
    String fromAccountNumber;
    String toAccountNumber;
    BigDecimal amount;
}
