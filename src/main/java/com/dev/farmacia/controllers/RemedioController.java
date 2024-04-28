package com.dev.farmacia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.dev.farmacia.dtos.AtualizarRemedioDto;
import com.dev.farmacia.dtos.DetalhamentoRemedioDto;
import com.dev.farmacia.dtos.ListagemRemedioDto;
import com.dev.farmacia.dtos.RemedioDto;
import com.dev.farmacia.entities.Remedio;
import com.dev.farmacia.repositories.RemedioRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
    private RemedioRepository remedioRepository;
    
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhamentoRemedioDto> cadastrar(@RequestBody @Valid RemedioDto remedioDto, UriComponentsBuilder uriBuilder){
        
        var remedio = new Remedio(remedioDto);
        remedioRepository.save(remedio);

        var uri = uriBuilder.path("/remedios/{id}").buildAndExpand(remedio.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhamentoRemedioDto(remedio));
    }

    @GetMapping
    public ResponseEntity<List<ListagemRemedioDto>> listar(){
        var lista = remedioRepository.findAllByAtivoTrue().stream().map(ListagemRemedioDto::new).toList();

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhamentoRemedioDto> listarPorId(@PathVariable Long id){
        var remedio = remedioRepository.getReferenceById(id);

        return ResponseEntity.ok(new DetalhamentoRemedioDto(remedio));
    }
    
    @PutMapping
    @Transactional
    public ResponseEntity<DetalhamentoRemedioDto> atualizar(@RequestBody @Valid AtualizarRemedioDto atualizarRemedioDto){
        var remedio = remedioRepository.getReferenceById(atualizarRemedioDto.id());

        remedio.atualizarInformacoes(atualizarRemedioDto);

        return ResponseEntity.ok(new DetalhamentoRemedioDto(remedio));
    }

    //Exclusão fisica
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> exclusaoFisica(@PathVariable Long id){
        remedioRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    //Exclusão Logica
    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> exclusaoLogica(@PathVariable Long id){
        var remedio = remedioRepository.getReferenceById(id);
        remedio.inativar();

        return ResponseEntity.noContent().build();
    }

    //Ativar remedio
    @PutMapping("reativar/{id}")
    @Transactional
    public ResponseEntity<Void> reativar(@PathVariable Long id){
        var remedio = remedioRepository.getReferenceById(id);
        remedio.setAtivar();

        return ResponseEntity.noContent().build();
    }
}
