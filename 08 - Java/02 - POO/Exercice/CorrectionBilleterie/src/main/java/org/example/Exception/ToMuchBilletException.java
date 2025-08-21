package org.example.Exception;

public class ToMuchBilletException extends RuntimeException {
    public ToMuchBilletException(String message) {
        super(message);
    }
}
