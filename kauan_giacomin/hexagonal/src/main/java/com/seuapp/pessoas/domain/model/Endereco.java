package kauan_giacomin.hexagonal.src.main.java.com.seuapp.pessoas.domain.model;

import java.util.Objects;

public class Endereco {
    private final String cep;
    private final String logradouro;
    private final String bairro;
    private final String localidade;
    private final String uf;
    private final String complemento;

    public Endereco(String cep, String logradouro, String bairro,
                    String localidade, String uf, String complemento) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.complemento = complemento;
    }

    public String getCep() { return cep; }
    public String getLogradouro() { return logradouro; }
    public String getBairro() { return bairro; }
    public String getLocalidade() { return localidade; }
    public String getUf() { return uf; }
    public String getComplemento() { return complemento; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endereco)) return false;
        Endereco e = (Endereco) o;
        return Objects.equals(cep, e.cep) &&
               Objects.equals(logradouro, e.logradouro) &&
               Objects.equals(bairro, e.bairro) &&
               Objects.equals(localidade, e.localidade) &&
               Objects.equals(uf, e.uf) &&
               Objects.equals(complemento, e.complemento);
    }
    @Override public int hashCode() {
        return Objects.hash(cep, logradouro, bairro, localidade, uf, complemento);
    }
}