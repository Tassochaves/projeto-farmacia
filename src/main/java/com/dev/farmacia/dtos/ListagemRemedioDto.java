package com.dev.farmacia.dtos;

import java.time.LocalDate;

import com.dev.farmacia.entities.Remedio;
import com.dev.farmacia.enums.Laboratorio;
import com.dev.farmacia.enums.Via;


public record ListagemRemedioDto(
    Long id,
    String nome,
    Via via,
    String lote,
    Laboratorio laboratorio,
    LocalDate validade

) {

    public ListagemRemedioDto(Remedio remedio){
        this(remedio.getId(), remedio.getNome(), remedio.getVia(), remedio.getLote(), remedio.getLaboratorio(), remedio.getValidade());
    }
}
