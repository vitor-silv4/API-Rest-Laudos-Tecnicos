package br.com.czernayPericias.domain.checkList;

import java.time.LocalDateTime;

public record NotaFiscal(String numeroDaNota,
                         String numeroLacreCaminhao,
                         String volumeDoCaminhaoEmMetrosCubicos,
                         String slumpTesteEmMilimetros,
                         String aguaRepostaEmLitros,
                         //Vai ter que ter um padrão de horário
                         LocalDateTime horarioSaidaCaminhaoUsina,
                         //Vai ter que ter um padrão de horário
                         LocalDateTime horarioChegadaCaminhaoObra,
                         //Vai ter que ter um padrão de horário
                         LocalDateTime horarioSaidaCaminhaoObra,
                         int totalCpPorCarga,
                         String pecaConcretada,
                         String observacao) {
}
