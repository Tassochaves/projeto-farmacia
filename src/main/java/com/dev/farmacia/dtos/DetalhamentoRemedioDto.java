package com.dev.farmacia.dtos;

import java.time.LocalDate;

import com.dev.farmacia.entities.Remedio;
import com.dev.farmacia.enums.Laboratorio;
import com.dev.farmacia.enums.Via;

public record DetalhamentoRemedioDto(
    Long id,
    String nome,
    Via via,
    String lote,
    int quantidade,
    LocalDate validade,
    Laboratorio laboratorio,
    Boolean ativo
) {
    //Construtor DetalhamentoRemedioDto
    public DetalhamentoRemedioDto(Remedio remedio){
        //Construtor remedio
        this(
            remedio.getId(), 
            remedio.getNome(), 
            remedio.getVia(), 
            remedio.getLote(), 
            remedio.getQuantidade(), 
            remedio.getValidade(), 
            remedio.getLaboratorio(), 
            remedio.getAtivo());
    }
}
