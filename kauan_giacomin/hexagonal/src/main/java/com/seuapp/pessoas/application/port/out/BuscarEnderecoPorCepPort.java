package kauan_giacomin.hexagonal.src.main.java.com.seuapp.pessoas.application.port.out;

import com.seuapp.pessoas.domain.model.Endereco;

public interface BuscarEnderecoPorCepPort {
    Endereco buscar(String cep);
}