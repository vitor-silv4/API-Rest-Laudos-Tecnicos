package br.com.czernayPericias.domain.endereco;

import jakarta.validation.constraints.NotNull;

public record DadosEndereco(
                            @NotNull
                            String rua,
                            @NotNull
                            String numero,
                            @NotNull
                            String bairro,
                            @NotNull
                            String cidade,
                            @NotNull
                            String cep) {
}
