package br.com.czernayPericias.domain.obra;

import br.com.czernayPericias.domain.endereco.Endereco;

public record DadosDetalhamentoObra(Long idObra, String nome, String nomeDoEngenheiro, Endereco endereco) {

    public DadosDetalhamentoObra(Obra obra) {
        this(obra.getId(), obra.getNome(), obra.getNomeDoEngenheiro(), obra.getEndereco());
    }
}
