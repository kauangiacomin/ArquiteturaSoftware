package com.seuapp.pessoas.adapters.out.viacep;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "viacep", url = "https://viacep.com.br")
public interface ViaCepClient {
    @GetMapping("/ws/{cep}/json/")
    ViaCepEnderecoResponse buscar(@PathVariable("cep") String cep);
}
java
Copiar código

package kauan_giacomin.hexagonal.src.main.java.com.seuapp.pessoas.adapters.out.viacep;

public class ViaCepEnderecoResponse {
    public String cep;
    public String logradouro;
    public String bairro;
    public String localidade;
    public String uf;
    public String complemento;
    public String erro; 
}