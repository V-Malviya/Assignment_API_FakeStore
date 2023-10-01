package com.restapi.fakestoreapiproxy.exceptions;

public class NoProductFoundException extends Exception{
    public NoProductFoundException(String message)
    {
        super(message);
    }
}
