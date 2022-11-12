package io.github.denrzv.moneytransferserviceapp.exception;

public class ErrorConfirmation extends RuntimeException {
    public ErrorConfirmation(String msg) {
        super(msg);
    }
}
