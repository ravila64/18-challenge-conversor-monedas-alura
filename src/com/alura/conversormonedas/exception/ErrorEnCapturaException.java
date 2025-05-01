package com.alura.conversormonedas.exception;

public class ErrorEnCapturaException extends RuntimeException{
    private  String mensaje;
    public ErrorEnCapturaException(String str) {
        this.mensaje = str;
    }

    @Override
    public String getMessage() {
        return this.getMessage();
    }
}
