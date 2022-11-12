package io.github.denrzv.moneytransferserviceapp.model;

import javax.validation.constraints.NotBlank;

public class SuccessTransfer {
    @NotBlank
    private final String operationId;

    public SuccessTransfer(int operationId) {
        this.operationId = String.valueOf(operationId);
    }

    public String getOperationId() {
        return operationId;
    }

    @Override
    public String toString() {
        return "SuccessTransfer{" +
                "operationId='" + operationId + '\'' +
                '}';
    }
}
