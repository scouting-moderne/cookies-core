package io.moderne.scouting.cookies.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandling {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiError> handleException(ApiException exception) {
        int status;
        if (exception.getError().status() == null) {
            status = 500;
        } else {
            status = exception.getError().status();
        }
        return ResponseEntity.status(status)
                .body(exception.getError());
    }

}
