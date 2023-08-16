package br.com.czernayPericias.domain.cliente;

import br.com.czernayPericias.domain.endereco.DadosEndereco;
import br.com.czernayPericias.domain.endereco.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCliente(
                                   @NotNull
                                   String nome,
                                   @NotNull
                                   @Valid
                                   DadosEndereco endereco) {
}
