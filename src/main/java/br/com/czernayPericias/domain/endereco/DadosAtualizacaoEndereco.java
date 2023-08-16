package br.com.czernayPericias.domain.endereco;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoEndereco(
                                       String rua,
                                       String numero,
                                       String bairro,
                                       String cidade,
                                       String cep) {
}
