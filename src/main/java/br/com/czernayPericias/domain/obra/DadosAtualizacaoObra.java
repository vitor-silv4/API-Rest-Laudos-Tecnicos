package br.com.czernayPericias.domain.obra;

import br.com.czernayPericias.domain.endereco.DadosAtualizacaoEndereco;
import br.com.czernayPericias.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoObra(

        @NotNull
        Long id,
        String nome,

        String nomeDoEngenheiro,

        DadosAtualizacaoEndereco endereco) {
}
