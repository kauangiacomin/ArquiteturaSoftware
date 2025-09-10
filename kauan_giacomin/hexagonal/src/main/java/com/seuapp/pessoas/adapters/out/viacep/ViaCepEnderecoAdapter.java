package kauan_giacomin.hexagonal.src.main.java.com.seuapp.pessoas.adapters.out.viacep;

import com.seuapp.pessoas.application.port.out.BuscarEnderecoPorCepPort;
import com.seuapp.pessoas.domain.model.Endereco;
import org.springframework.stereotype.Component;

@Component
public class ViaCepEnderecoAdapter implements BuscarEnderecoPorCepPort {

    private final ViaCepClient client;

    public ViaCepEnderecoAdapter(ViaCepClient client) { this.client = client; }

    @Override
    public Endereco buscar(String cep) {
        ViaCepEnderecoResponse r = client.buscar(cep);
        if (r == null || "true".equalsIgnoreCase(r.erro)) {
            throw new IllegalArgumentException("CEP inválido: " + cep);
        }
        return new Endereco(
                r.cep, r.logradouro, r.bairro, r.localidade, r.uf, r.complemento
        );
    }
}
