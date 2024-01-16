package com.example.MyBookShopApp.errs;

public class EmptySearchException extends Throwable {
    public EmptySearchException(String message) {
        super(message);
    }
}
