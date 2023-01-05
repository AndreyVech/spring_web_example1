package com.example.spring_webapp2.exception;

public class notFoundException extends RuntimeException{
    public notFoundException(String id){
        super("Person not found: " + id);
    }
}
