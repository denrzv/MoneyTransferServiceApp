package io.github.denrzv.moneytransferserviceapp.model;

import org.hibernate.validator.constraints.Currency;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Amount {
    @NotBlank
    @Min(value = 1)
    private int value;

    @NotBlank
    @Currency({"RUR"})
    private String currency;

    public Amount(int value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "value=" + value +
                ", currency='" + currency + '\'' +
                '}';
    }
}
