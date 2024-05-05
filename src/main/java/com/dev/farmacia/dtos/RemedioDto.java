package com.dev.farmacia.dtos;

import java.time.LocalDate;

import com.dev.farmacia.enums.Laboratorio;
import com.dev.farmacia.enums.Via;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

public record RemedioDto(

    @NotBlank
    String nome,

    @Enumerated
    Via via,

    @NotBlank
    String lote,
    
    int quantidade,

    @Future() 
    LocalDate validade,

    @Enumerated
    Laboratorio laboratorio
) {}
