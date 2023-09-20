package br.com.fiap.Error;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestControllerAdvice
public class ApplicationErrorHandler {
    
    @ExceptionHandler(Method.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handler() {
        System.out.println("Error");
    }
}
