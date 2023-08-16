package br.com.czernayPericias.domain.cliente;

import br.com.czernayPericias.domain.endereco.DadosAtualizacaoEndereco;
import br.com.czernayPericias.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(
                                        @NotNull
                                        Long id,
                                        String nome,
                                        DadosAtualizacaoEndereco endereco
                                        ) {

}
