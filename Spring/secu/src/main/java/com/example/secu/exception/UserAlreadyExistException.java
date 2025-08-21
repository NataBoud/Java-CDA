package com.example.secu.exception;

public class UserAlreadyExistException extends Exception{
    public UserAlreadyExistException() {
        super("User already exists");
    }
}
