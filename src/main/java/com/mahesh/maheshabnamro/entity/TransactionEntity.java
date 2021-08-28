package com.mahesh.maheshabnamro.entity;

import com.mahesh.maheshabnamro.common.Status;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "TRANSACTION")
@Data
public class TransactionEntity {
    @Id
    long id;
    String fromAccountNumber;
    String toAccountNumber;
    BigDecimal amount;
    @Column(columnDefinition = "date default CURRENT_TIMESTAMP")
    Date creationDate;
    Status status;
}
