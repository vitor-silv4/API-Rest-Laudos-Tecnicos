package br.com.czernayPericias.domain.cliente;

import br.com.czernayPericias.domain.endereco.Endereco;

public record DadosDetalhamentoCliente(Long idCliente, String nome, Endereco endereco) {
    public DadosDetalhamentoCliente(Cliente cliente){
        this(cliente.getIdCliente(), cliente.getNome(), cliente.getEndereco());
    }
}
