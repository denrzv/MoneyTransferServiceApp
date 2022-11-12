package io.github.denrzv.moneytransferserviceapp.model;

import javax.validation.constraints.NotBlank;

public class SuccessConfirm {
    @NotBlank
    private final String operationId;

    public SuccessConfirm(String operationId) {
        this.operationId = String.valueOf(operationId);
    }

    public String getOperationId() {
        return operationId;
    }

    @Override
    public String toString() {
        return "SuccessConfirm{" +
                "operationId='" + operationId + '\'' +
                '}';
    }
}
