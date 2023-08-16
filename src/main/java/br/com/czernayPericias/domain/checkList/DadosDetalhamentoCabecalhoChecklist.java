package br.com.czernayPericias.domain.checkList;

import br.com.czernayPericias.domain.funcionario.Funcionario;

import java.time.LocalDate;

public record DadosDetalhamentoCabecalhoChecklist(
                                                  Long idDoCabecalho,
                                                  Long idCliente,
                                                  Long idObra,
                                                  LocalDate dataDaMoldagem,
                                                  Funcionario funcionario,
                                                  String concreteira,
                                                  Lancamento lancamento,
                                                  String fck,
                                                  String abatimento,
                                                  Agregado agregado) {
    public DadosDetalhamentoCabecalhoChecklist(CabecalhoDoCheckList cabecalhoDoCheckList){
        this(cabecalhoDoCheckList.getId(), cabecalhoDoCheckList.getIdCliente(), cabecalhoDoCheckList.getIdObra(), cabecalhoDoCheckList.getDataDaMoldagem(), cabecalhoDoCheckList.getFuncionario(), cabecalhoDoCheckList.getConcreteira(), cabecalhoDoCheckList.getLancamento(), cabecalhoDoCheckList.getFck(), cabecalhoDoCheckList.getAbatimento(), cabecalhoDoCheckList.getAgregado());
    }
}
