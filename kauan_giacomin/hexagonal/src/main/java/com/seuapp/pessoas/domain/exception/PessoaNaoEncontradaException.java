package kauan_giacomin.hexagonal.src.main.java.com.seuapp.pessoas.domain.exception;

public class PessoaNaoEncontradaException extends RuntimeException {
    public PessoaNaoEncontradaException(Long id) {
        super("Pessoa não encontrada: " + id);
    }
}
