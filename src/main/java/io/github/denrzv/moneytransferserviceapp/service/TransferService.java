package io.github.denrzv.moneytransferserviceapp.service;

import io.github.denrzv.moneytransferserviceapp.exception.ErrorInputData;
import io.github.denrzv.moneytransferserviceapp.model.*;
import io.github.denrzv.moneytransferserviceapp.repository.CardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TransferService {
    private final CardRepository repository;
    private static final Logger log = LoggerFactory.getLogger(TransferService.class);

    public TransferService(CardRepository repository) {
        this.repository = repository;
    }

    public SuccessConfirm confirmOperation(ConfirmOperation confirmOperation) {
        log.info("Подтверждение операции " + confirmOperation);
        return repository.confirmOperation(confirmOperation);
    }

    public SuccessTransfer transfer(CardTransfer cardTransfer) {
        Card cardFrom = new Card(cardTransfer.getCardFromNumber());
        Card cardTo = new Card(cardTransfer.getCardToNumber());

        log.info("Перевод суммы " + cardTransfer.getAmount() + " с карты " + cardFrom + " на карту " + cardTo);

        if (repository.isValidCard(cardFrom) && repository.isValidCard(cardTo)) {
            return repository.transfer(cardFrom, cardTransfer.getAmount(), cardTo);
        } else {
            throw new ErrorInputData("Некорректно указаны данные карты отправителя или получателя");
        }
    }
}
