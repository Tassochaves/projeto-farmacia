package com.dev.farmacia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void cadastrar(@RequestBody @Valid RemedioDto remedioDto){
        remedioRepository.save(new Remedio(remedioDto));
    }

    @GetMapping
    public List<ListagemRemedioDto> listar(){
        return remedioRepository.findAll().stream().map(ListagemRemedioDto::new).toList();
    }
}
