package com.sooraj.learning.ordertrackerspringproject.exception;

public class DuplicateCategoryException extends RuntimeException{
    public DuplicateCategoryException(String category){
        super("Category: "+category+" already exists");
    }
}
