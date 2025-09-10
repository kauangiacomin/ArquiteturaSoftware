package kauan_giacomin.hexagonal.src.main.java.com.seuapp.pessoas.application.port.in;

public interface AtualizarEnderecoDaPessoaUseCase {
    void executar(Long pessoaId, String cep);
}