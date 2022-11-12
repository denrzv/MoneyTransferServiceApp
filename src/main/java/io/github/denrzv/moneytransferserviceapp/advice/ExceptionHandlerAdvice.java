package io.github.denrzv.moneytransferserviceapp.advice;

import io.github.denrzv.moneytransferserviceapp.exception.ErrorConfirmation;
import io.github.denrzv.moneytransferserviceapp.exception.ErrorInputData;
import io.github.denrzv.moneytransferserviceapp.exception.ErrorTransfer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ResponseBody
    @ExceptionHandler(ErrorConfirmation.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String errorConfirmation(ErrorConfirmation e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ErrorInputData.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String errorInputData(ErrorInputData e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ErrorTransfer.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String errorTransfer(ErrorTransfer e) {
        return e.getMessage();
    }
}
