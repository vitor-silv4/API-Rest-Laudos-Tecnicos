package br.com.czernayPericias.controller;

import br.com.czernayPericias.domain.obra.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/obra")
public class ObraController {

    @Autowired
    private ObraRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarObra(@RequestBody @Valid DadosCadastroObra dados, UriComponentsBuilder uriBuilder) {
        var obra = new Obra(dados);
        repository.save(obra);
        var uri = uriBuilder.path("/obra/{id}").buildAndExpand(obra.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoObra(obra));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoObra>> listar(@PageableDefault(size = 10, sort = "nome")Pageable paginacao){
        var page = repository.findAll(paginacao).map(DadosDetalhamentoObra::new);
        return ResponseEntity.ok().body(page);
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoObra dados){
        var obra = repository.getReferenceById(dados.id());
        obra.atualizar(dados);
        repository.save(obra);
        return ResponseEntity.ok().body(new DadosDetalhamentoObra(obra));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
