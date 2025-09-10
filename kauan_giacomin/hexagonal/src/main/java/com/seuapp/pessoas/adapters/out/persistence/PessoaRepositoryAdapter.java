package kauan_giacomin.hexagonal.src.main.java.com.seuapp.pessoas.adapters.out.persistence;

import com.seuapp.pessoas.application.port.out.PessoaRepositoryPort;
import com.seuapp.pessoas.domain.model.Endereco;
import com.seuapp.pessoas.domain.model.Pessoa;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PessoaRepositoryAdapter implements PessoaRepositoryPort {

    private final PessoaSpringDataRepository repo;

    public PessoaRepositoryAdapter(PessoaSpringDataRepository repo) {
        this.repo = repo;
    }

    @Override
    public Optional<Pessoa> findById(Long id) {
        return repo.findById(id).map(this::toDomain);
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        PessoaEntity e = toEntity(pessoa);
        e = repo.save(e);
        return toDomain(e);
    }

    private Pessoa toDomain(PessoaEntity e) {
        Endereco end = new Endereco(e.getCep(), e.getLogradouro(), e.getBairro(),
                e.getLocalidade(), e.getUf(), e.getComplemento());
        return new Pessoa(e.getId(), e.getNome(), end);
    }

    private PessoaEntity toEntity(Pessoa p) {
        PessoaEntity e = new PessoaEntity();
        e.setId(p.getId());
        e.setNome(p.getNome());
        if (p.getEndereco() != null) {
            e.setCep(p.getEndereco().getCep());
            e.setLogradouro(p.getEndereco().getLogradouro());
            e.setBairro(p.getEndereco().getBairro());
            e.setLocalidade(p.getEndereco().getLocalidade());
            e.setUf(p.getEndereco().getUf());
            e.setComplemento(p.getEndereco().getComplemento());
        }
        return e;
    }
}