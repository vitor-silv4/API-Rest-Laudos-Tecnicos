package br.com.czernayPericias.domain.checkList;

import br.com.czernayPericias.domain.funcionario.Funcionario;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record DadosAtualizacaoCabecalhoDoCheckList(
        @NotNull
        Long id,
        Long idCliente,
        Long idObra,
        LocalDate dataDaMoldagem,
        Funcionario funcionario,
        String concreteira,
        Lancamento lancamento,
        String fck,
        String abatimento,
        Agregado agregado
) {
}
