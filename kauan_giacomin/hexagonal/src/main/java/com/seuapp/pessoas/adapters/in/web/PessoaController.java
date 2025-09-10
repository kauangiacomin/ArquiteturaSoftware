package com.seuapp.pessoas.adapters.in.web;

import com.seuapp.pessoas.application.port.in.AtualizarEnderecoDaPessoaUseCase;
import com.seuapp.pessoas.adapters.in.web.dto.AtualizarEnderecoRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final AtualizarEnderecoDaPessoaUseCase useCase;

    public PessoaController(AtualizarEnderecoDaPessoaUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/{id}/endereco")
    public ResponseEntity<Void> atualizarEndereco(@PathVariable("id") Long id,
                                                  @RequestBody @Valid AtualizarEnderecoRequest body) {
        useCase.executar(id, body.getCep());
        return ResponseEntity.noContent().build();
    }
}