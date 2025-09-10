package kauan_giacomin.hexagonal.src.main.java.com.seuapp.pessoas.application.port.out;

import com.seuapp.pessoas.domain.model.Pessoa;
import java.util.Optional;

public interface PessoaRepositoryPort {
    Optional<Pessoa> findById(Long id);
    Pessoa save(Pessoa pessoa);
}