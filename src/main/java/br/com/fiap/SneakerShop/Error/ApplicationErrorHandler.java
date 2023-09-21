package br.com.fiap.SneakerShop.Error;

import java.util.List;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import br.com.fiap.SneakerShop.Validation.RestValidationError;

@RestControllerAdvice
public class ApplicationErrorHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<RestValidationError> RestValidationErrorhandler(MethodArgumentNotValidException e) {
        return e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> new RestValidationError(err.getField(), err.getDefaultMessage()))
                .collect(Collectors.toList());
    }
}
