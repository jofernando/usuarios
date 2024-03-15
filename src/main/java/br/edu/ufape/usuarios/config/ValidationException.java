package br.edu.ufape.usuarios.config;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ValidationException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, List<ValidationError>> stringListHashMap = new HashMap<>();
        List<ValidationError> validationErrorList = ex.getConstraintViolations()
                .stream()
                .map(constraintViolation -> new ValidationError(
                        constraintViolation.getPropertyPath().toString(),
                        constraintViolation.getMessage(),
                        constraintViolation.getInvalidValue()
                )).toList();
        stringListHashMap.put("errors", validationErrorList);
        return new ResponseEntity<>(stringListHashMap, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, Object> stringListHashMap = new HashMap<>();
        Throwable mostSpecificCause = ex.getMostSpecificCause();
        Map<String, String> error = new HashMap<>();
        if (mostSpecificCause instanceof DateTimeParseException dateTimeParseException) {
            error.put("invalidValue", dateTimeParseException.getParsedString());
        }
        error.put("errorMessage", ex.getMessage());
        List<Map<String, String>> errors = new ArrayList<>();
        errors.add(error);
        stringListHashMap.put("errors", errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(stringListHashMap);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    private record ValidationError(String fieldName, String errorMessage, Object invalidValue) {
    }
}
