package com.dev.farmacia.dtos;

import com.dev.farmacia.enums.Laboratorio;
import com.dev.farmacia.enums.Via;

import jakarta.validation.constraints.NotNull;

public record AtualizarRemedioDto(
    @NotNull
    Long id,
    String nome,
    Via via,
    Laboratorio laboratorio
) {

}
