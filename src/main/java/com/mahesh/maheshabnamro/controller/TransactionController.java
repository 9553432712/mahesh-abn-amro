package com.mahesh.maheshabnamro.controller;

import com.mahesh.maheshabnamro.dto.TransactionDto;
import com.mahesh.maheshabnamro.entity.TransactionEntity;
import com.mahesh.maheshabnamro.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transact")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transfer")
    public String transferMoney(@RequestBody TransactionDto transactionDto){
        return transactionService.makeTransaction(transactionDto);
    }

    @GetMapping("/get-all")
    public List<TransactionEntity> getAll(){
        return transactionService.getAll();
    }

    @GetMapping("/get/{id}")
    public TransactionEntity getById(@PathVariable("id") long id){
        return transactionService.getByTransactionId(id);
    }
}
