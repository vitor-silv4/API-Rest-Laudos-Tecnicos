package br.com.czernayPericias.domain.cliente;

import br.com.czernayPericias.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "cliente")
@Entity(name = "Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="idCliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    private String nome;
    @Embedded
    @Setter
    private Endereco endereco;


    public Cliente(DadosCadastroCliente dados) {
        this.nome = dados.nome();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizar(DadosAtualizacaoCliente dados){
        if (dados.nome() != null){
        this.nome = dados.nome();
        }
        if (dados.endereco() != null){
        endereco.atualizarEndereco(dados.endereco());
        }
    }
}
