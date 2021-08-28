package com.mahesh.maheshabnamro.exception;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(String id) {
        super(String.format("Account with Id %s not found", id));
    }
}