package com.seuapp.pessoas.adapters.in.web.dto;

import jakarta.validation.constraints.NotBlank;

public class AtualizarEnderecoRequest {
    @NotBlank
    private String cep;
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
}