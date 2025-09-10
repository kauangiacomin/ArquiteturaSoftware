package kauan_giacomin.hexagonal.src.main.java.com.seuapp.pessoas.adapters.out.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "pessoa")
public class PessoaEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Campos do Endereco embutidos (simples e direto)
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private String complemento;

    // getters/setters omitidos por brevidade
    // ...
}