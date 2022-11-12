package io.github.denrzv.moneytransferserviceapp.controllers;

import io.github.denrzv.moneytransferserviceapp.model.CardTransfer;
import io.github.denrzv.moneytransferserviceapp.model.SuccessTransfer;
import io.github.denrzv.moneytransferserviceapp.service.TransferService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TransferController {
    private final TransferService service;


    public TransferController(TransferService service) {
        this.service = service;
    }

    @PostMapping("/transfer")
    public SuccessTransfer transfer(@Valid @RequestBody CardTransfer cardTransfer) {
        return service.transfer(cardTransfer);
    }
}
