package io.caelusresearch.aqrspringbootworkshop.apis;

import io.caelusresearch.aqrspringbootworkshop.exceptions.RecordNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class CentralExceptionHandler {
    private final static Logger LOGGER = LoggerFactory.getLogger(CentralExceptionHandler.class);

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleRecordNotFoundException(RecordNotFoundException exception) {
        LOGGER.info(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", exception.getMessage()));
    }
}

