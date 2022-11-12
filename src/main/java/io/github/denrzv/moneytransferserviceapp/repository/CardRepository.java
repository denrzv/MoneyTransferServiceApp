package io.github.denrzv.moneytransferserviceapp.repository;

import io.github.denrzv.moneytransferserviceapp.exception.ErrorConfirmation;
import io.github.denrzv.moneytransferserviceapp.exception.ErrorTransfer;
import io.github.denrzv.moneytransferserviceapp.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class CardRepository {
    private final ConcurrentHashMap<Card, Amount> cards;
    private final AtomicInteger operationCounter;
    private static final Logger log = LoggerFactory.getLogger(CardRepository.class);

    public CardRepository() {
        cards = new ConcurrentHashMap<>();
        operationCounter = new AtomicInteger();
    }

    public Card addCard(Card card, Amount amount) {
        cards.put(card, amount);
        return card;
    }

    public SuccessConfirm confirmOperation(ConfirmOperation confirmOperation) {
        if (operationCounter.get() >= confirmOperation.getOperationId()) {
            return new SuccessConfirm(String.valueOf(confirmOperation.getOperationId()));
        } else {
            throw new ErrorConfirmation("Некорректные параметры подтверждения перевода");
        }
    }

    public boolean isValidCard(Card card) {
        return cards.containsKey(card);
    }

    public SuccessTransfer transfer(Card cardFrom, Amount amount, Card cardTo) {
        int cardFromBalance = cards.get(cardFrom).getValue();
        if (cardFromBalance < amount.getValue()) {
            throw new ErrorTransfer("Недостаточно средств на карте отправителя платежа");
        }
        cards.get(cardFrom).setValue(cardFromBalance - amount.getValue());
        int cardToBalance = cards.get(cardTo).getValue() + amount.getValue();
        cards.get(cardTo).setValue(cardToBalance);

        SuccessTransfer successTransfer = new SuccessTransfer(operationCounter.getAndIncrement());
        log.info("Успешно выполнен перевод, id операции - " + successTransfer.getOperationId());
        return successTransfer;
    }
}
