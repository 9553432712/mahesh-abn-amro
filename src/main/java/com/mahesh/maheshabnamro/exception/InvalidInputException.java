package com.mahesh.maheshabnamro.exception;

public class InvalidInputException extends RuntimeException {

    public InvalidInputException() {

        super(String.format("Input request is not valid"));
    }
}