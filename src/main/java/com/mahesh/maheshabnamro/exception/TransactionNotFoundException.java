package com.mahesh.maheshabnamro.exception;

public class TransactionNotFoundException extends RuntimeException {

    public TransactionNotFoundException(long id) {
        super(String.format("Transaction with Id %d not found", id));
    }
}