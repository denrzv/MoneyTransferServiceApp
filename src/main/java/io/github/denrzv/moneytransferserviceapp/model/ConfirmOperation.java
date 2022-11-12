package io.github.denrzv.moneytransferserviceapp.model;

import javax.validation.constraints.NotBlank;

public class ConfirmOperation {
    @NotBlank
    private final String operationId;
    @NotBlank
    private final String code;


    public ConfirmOperation(String operationId, String code) {
        this.operationId = operationId;
        this.code = code;
    }

    public int getOperationId() {
        return Integer.parseInt(operationId);
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "SuccessConfirmation{" +
                "operationId='" + operationId + '\'' +
                ", verificationCode='" + code + '\'' +
                '}';
    }
}
