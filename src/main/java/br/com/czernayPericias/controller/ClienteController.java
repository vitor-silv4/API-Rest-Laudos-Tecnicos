package br.com.czernayPericias.controller;

import br.com.czernayPericias.domain.cliente.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarCliente(@RequestBody @Valid DadosCadastroCliente dados, UriComponentsBuilder uriBuilder){
        var cliente = new Cliente(dados);
        repository.save(cliente);
        var uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getIdCliente()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCliente(cliente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoCliente>> listar(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao){ //Stream percorre todos resultados da consulta, enquanto o Pageble percorre a quantidade que eu indiquei no size
        var cliente = repository.findAll(paginacao).map(DadosDetalhamentoCliente::new);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoCliente dados){
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizar(dados);
        repository.save(cliente);
        return ResponseEntity.ok().body(new DadosDetalhamentoCliente(cliente));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
