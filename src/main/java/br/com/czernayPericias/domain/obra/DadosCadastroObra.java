package br.com.czernayPericias.domain.obra;

import br.com.czernayPericias.domain.endereco.DadosEndereco;
import br.com.czernayPericias.domain.endereco.Endereco;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroObra(
                                @NotNull
                                String nome,
                                @NotNull
                                String nomeDoEngenheiro,
                                @NotNull
                                DadosEndereco endereco) {
}
