package br.com.czernayPericias.controller;

import br.com.czernayPericias.domain.checkList.DadosAtualizacaoCabecalhoDoCheckList;
import br.com.czernayPericias.domain.checkList.DadosCadastroCabecalhoDoCheckList;
import br.com.czernayPericias.domain.checkList.CabecalhoDoCheckListRepository;
import br.com.czernayPericias.domain.checkList.DadosDetalhamentoCabecalhoChecklist;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/checklist")
public class CabecalhoDoCheckListController {

    @Autowired
    private CabecalhoDoCheckListRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity salvarCabecalhoDoCheckListNoBanco(@RequestBody @Valid DadosCadastroCabecalhoDoCheckList dados, UriComponentsBuilder uriBuilder){
        var cabecalhoDoCheckList = new br.com.czernayPericias.domain.checkList.CabecalhoDoCheckList(dados);
        repository.save(cabecalhoDoCheckList);
        var uri = uriBuilder.path("/cabecalhoDoCheckList/{id}").buildAndExpand(cabecalhoDoCheckList.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCabecalhoChecklist(cabecalhoDoCheckList));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoCabecalhoChecklist>> listar(@PageableDefault(size = 10, sort = {"id"})Pageable paginacao){
        var page = repository.findAll(paginacao).map(DadosDetalhamentoCabecalhoChecklist::new);
        return ResponseEntity.ok(page);
    }
    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoCabecalhoDoCheckList dados){
        var cabecalhoCheckList = repository.getReferenceById(dados.id());
        cabecalhoCheckList.atualizarInformacoes(dados);
        repository.save(cabecalhoCheckList);
        return ResponseEntity.ok(new DadosDetalhamentoCabecalhoChecklist(cabecalhoCheckList));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        var cabecalhoDoCheckList = repository.getReferenceById(id);
        repository.delete(cabecalhoDoCheckList);
        return ResponseEntity.noContent().build();
    }
}
