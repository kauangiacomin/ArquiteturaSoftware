package com.seuapp.pessoas.adapters.in.web.handler;

import com.seuapp.pessoas.domain.exception.PessoaNaoEncontradaException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(PessoaNaoEncontradaException.class)
    public ResponseEntity<?> handleNotFound(PessoaNaoEncontradaException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
