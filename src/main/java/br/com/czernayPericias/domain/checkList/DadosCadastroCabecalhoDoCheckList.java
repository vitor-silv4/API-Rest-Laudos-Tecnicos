package br.com.czernayPericias.domain.checkList;

import br.com.czernayPericias.domain.funcionario.Funcionario;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record DadosCadastroCabecalhoDoCheckList(
                                         @NotNull
                                         Long idCliente,
                                         @NotNull
                                         Long idObra,
                                         @NotNull
                                         LocalDate dataDaMoldagem,
                                         @NotNull
                                         Funcionario funcionario,
                                         @NotNull
                                         String concreteira,
                                         @NotNull
                                         Lancamento lancamento,
                                         @NotNull
                                         @Pattern(regexp = "\\d{2}")
                                         String fck,

//                                         @Pattern(regexp = "\\d{3}±\\d{2}")
                                         @NotNull
                                         String abatimento,
                                         @NotNull
                                         Agregado agregado){
}
