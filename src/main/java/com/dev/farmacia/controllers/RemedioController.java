package com.dev.farmacia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.farmacia.dtos.RemedioDto;
import com.dev.farmacia.entities.Remedio;
import com.dev.farmacia.repositories.RemedioRepository;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
    private RemedioRepository remedioRepository;
    
    @PostMapping
    public void cadastrar(@RequestBody RemedioDto remedioDto){
        remedioRepository.save(new Remedio(remedioDto));
    }
}
