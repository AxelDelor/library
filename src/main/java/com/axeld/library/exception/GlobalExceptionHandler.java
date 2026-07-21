package com.axeld.library.exception;

import com.axeld.library.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({BookNotFoundException.class, LoanNotFoundException.class, MemberNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleNotFound(LibraryException ex) {
    ErrorResponse error = new ErrorResponse(ex.getMessage(), 404, LocalDateTime.now());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler({BookNotAvailableException.class, IsbnAlreadyExistsException.class})
    public ResponseEntity<ErrorResponse> handleConflict(LibraryException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(), 409, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        log.error("Erreur interne inattendue", ex);
        ErrorResponse error = new ErrorResponse("Une erreur interne est survenue", 500, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

}
