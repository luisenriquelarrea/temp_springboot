package com.artplusplus.contpp.errorhandling;

public class ErrorHandler {
    boolean error;
    String message;

    public ErrorHandler(boolean error, String message){
        this.error = error;
        this.message = message;
    }

    public boolean getError(){
        return error;
    }

    public String getMessage(){
        return message;
    }
}
