package kauan_giacomin.hexagonal.src.main.java.com.seuapp.pessoas.application.port.out;

import com.seuapp.pessoas.domain.model.Endereco;
import java.util.Optional;

public interface EnderecoCachePort {
    Optional<Endereco> get(String cep);
    void put(String cep, Endereco endereco);
}