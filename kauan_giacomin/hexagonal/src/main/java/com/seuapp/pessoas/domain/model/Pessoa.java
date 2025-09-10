package kauan_giacomin.hexagonal.src.main.java.com.seuapp.pessoas.domain.model;

public class Pessoa {
    private Long id;
    private String nome;
    private Endereco endereco; // associação com o VO Endereco

    public Pessoa(Long id, String nome, Endereco endereco) {
        this.id = id; this.nome = nome; this.endereco = endereco;
    }
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public Endereco getEndereco() { return endereco; }

    public void atualizarEndereco(Endereco novo) { this.endereco = novo; }
}