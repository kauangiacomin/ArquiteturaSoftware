package kauan_giacomin.hexagonal.src.main.java.com.seuapp.pessoas.application.service;

import com.seuapp.pessoas.application.port.in.AtualizarEnderecoDaPessoaUseCase;
import com.seuapp.pessoas.application.port.out.BuscarEnderecoPorCepPort;
import com.seuapp.pessoas.application.port.out.EnderecoCachePort;
import com.seuapp.pessoas.application.port.out.PessoaRepositoryPort;
import com.seuapp.pessoas.domain.exception.PessoaNaoEncontradaException;
import com.seuapp.pessoas.domain.model.Endereco;
import com.seuapp.pessoas.domain.model.Pessoa;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PessoaService implements AtualizarEnderecoDaPessoaUseCase {

    private final PessoaRepositoryPort pessoaRepo;
    private final EnderecoCachePort cache;
    private final BuscarEnderecoPorCepPort viaCep;

    public PessoaService(PessoaRepositoryPort pessoaRepo, EnderecoCachePort cache, BuscarEnderecoPorCepPort viaCep) {
        this.pessoaRepo = pessoaRepo;
        this.cache = cache;
        this.viaCep = viaCep;
    }

    @Override
    @Transactional
    public void executar(Long pessoaId, String cep) {
        Pessoa pessoa = pessoaRepo.findById(pessoaId)
                .orElseThrow(() -> new PessoaNaoEncontradaException(pessoaId));

        Endereco endereco = cache.get(cep).orElseGet(() -> {
            Endereco e = viaCep.buscar(cep);
            cache.put(cep, e);
            return e;
        });

        pessoa.atualizarEndereco(endereco);
        pessoaRepo.save(pessoa);
    }
}