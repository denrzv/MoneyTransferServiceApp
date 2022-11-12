package io.github.denrzv.moneytransferserviceapp.controllers;
import io.github.denrzv.moneytransferserviceapp.model.ConfirmOperation;
import io.github.denrzv.moneytransferserviceapp.model.SuccessConfirm;
import io.github.denrzv.moneytransferserviceapp.service.TransferService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ConfirmOperationController {
    private final TransferService service;


    public ConfirmOperationController(TransferService service) {
        this.service = service;
    }

    @PostMapping("/confirmOperation")
    public SuccessConfirm confirmOperation(@Valid @RequestBody ConfirmOperation confirmOperation) {
        return service.confirmOperation(confirmOperation);
    }
}
