package io.moderne.scouting.cookies.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandling {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiError> handleException(ApiException exception) {
        return ResponseEntity.internalServerError().body(exception.getError());
    }

}
