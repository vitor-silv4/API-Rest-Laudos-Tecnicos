package br.com.czernayPericias.domain.endereco;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String cep;

    public Endereco(DadosEndereco dados){
        this.rua = dados.rua();
        this.numero = dados.numero();
        this.bairro = dados.bairro();
        this.cidade = dados.cidade();
        this.cep = dados.cep();
    }
    public void atualizarEndereco(DadosAtualizacaoEndereco dados){
        if(dados.rua() !=null){
        this.rua = dados.rua();
        }
        if(dados.numero() !=null){
        this.numero = dados.numero();
        }
        if(dados.bairro() !=null){
        this.bairro = dados.bairro();
        }
        if(dados.cidade() !=null){
        this.cidade = dados.cidade();
        }
        if(dados.cep() !=null){
        this.cep = dados.cep();
        }
    }
}
