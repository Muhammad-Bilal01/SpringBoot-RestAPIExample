package com.ngprogramming.RestAPIExample.controller;

public class DataNotFoundException extends  RuntimeException {

    public DataNotFoundException(String message) {
        super(message);
    }
}
