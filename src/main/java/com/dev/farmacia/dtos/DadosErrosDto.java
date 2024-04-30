package com.dev.farmacia.dtos;

import org.springframework.validation.FieldError;

public record DadosErrosDto(String campo, String messagem) {
    
    public DadosErrosDto(FieldError erro){
        this(erro.getField(), erro.getDefaultMessage());
    }
}
