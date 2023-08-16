package br.com.czernayPericias.domain.obra;

import br.com.czernayPericias.domain.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Obra")
@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Obra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String nome;
    private String nomeDoEngenheiro;
    @Embedded
    Endereco endereco;

    public Obra(DadosCadastroObra dados){
        this.nome = dados.nome();
        this.nomeDoEngenheiro = dados.nomeDoEngenheiro();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizar(DadosAtualizacaoObra dados) {
        if (dados.nome() != null){
        this.nome = dados.nome();
        }
        if (dados.nomeDoEngenheiro() != null){
        this.nomeDoEngenheiro = dados.nomeDoEngenheiro();
        }
        if (dados.endereco() != null){
        endereco.atualizarEndereco(dados.endereco());
        }
    }
}
