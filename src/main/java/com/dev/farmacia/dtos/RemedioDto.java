package com.dev.farmacia.dtos;

import com.dev.farmacia.enums.Laboratorio;
import com.dev.farmacia.enums.Via;

public record RemedioDto(
    String nome,
    Via via,
    String lote,
    String quantidade,
    String validade,
    Laboratorio laboratorio
) {}
