package br.com.czernayPericias.domain.checkList;

import br.com.czernayPericias.domain.funcionario.Funcionario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "cabecalhoDoCheckList")
@Entity(name = "CabecalhoDoChechList")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class CabecalhoDoCheckList {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long idCliente;
    private long idObra;

    private LocalDate dataDaMoldagem;
    @Enumerated(EnumType.STRING)
    private Funcionario funcionario;
    private String concreteira;
    @Enumerated(EnumType.STRING)
    private Lancamento lancamento;
    private String fck;
    private String abatimento;
    @Enumerated(EnumType.STRING)
    private Agregado agregado;

    public CabecalhoDoCheckList(DadosCadastroCabecalhoDoCheckList dados) {
        this.idCliente = dados.idCliente();
        this.idObra = dados.idObra();
        this.dataDaMoldagem = dados.dataDaMoldagem();
        this.funcionario = dados.funcionario();
        this.concreteira = dados.concreteira();
        this.lancamento = dados.lancamento();
        this.fck = dados.fck();
        this.abatimento = dados.abatimento();
        this.agregado = dados.agregado();
    }

    public void atualizarInformacoes(DadosAtualizacaoCabecalhoDoCheckList dados) {
        if(dados.idCliente() != null){
        this.idCliente = dados.idCliente();
        }
        if(dados.idObra() != null){
        this.idObra = dados.idObra();
        }
        if(dados.dataDaMoldagem() != null){
        this.dataDaMoldagem = dados.dataDaMoldagem();
        }
        if(dados.funcionario() != null){
        this.funcionario = dados.funcionario();
        }
        if(dados.concreteira() != null){
        this.concreteira = dados.concreteira();
        }
        if(dados.lancamento() != null){
        this.lancamento = dados.lancamento();
        }
        if(dados.fck() != null){
        this.fck = dados.fck();
        }
        if(dados.abatimento() != null){
        this.abatimento = dados.abatimento();
        }
        if(dados.agregado() != null){
        this.agregado = dados.agregado();
        }
    }
}