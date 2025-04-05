package org.example.core.utils.exceptions;

public class ExampleOrgException extends Exception {
    private final ExampleOrgErro codigoErro;

    public ExampleOrgException (ExampleOrgErro codigoErro, String message) {
        super(message);
        this.codigoErro = codigoErro;
    }

    public ExampleOrgErro getCodigoErro() {
        return codigoErro;
    }
}
