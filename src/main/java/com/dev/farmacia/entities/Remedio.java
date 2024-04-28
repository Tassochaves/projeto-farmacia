package com.dev.farmacia.entities;

import java.time.LocalDate;

import com.dev.farmacia.dtos.AtualizarRemedioDto;
import com.dev.farmacia.dtos.RemedioDto;
import com.dev.farmacia.enums.Laboratorio;
import com.dev.farmacia.enums.Via;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_remedio")
public class Remedio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Via via;

    private String lote;
    private int quantidade;
    private LocalDate validade;

    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;

    private Boolean ativo;

    //Mappear remedioDto
    public Remedio(RemedioDto remedioDto){
        this.ativo = true;
        this.nome = remedioDto.nome();
        this.via = remedioDto.via();
        this.lote = remedioDto.lote();
        this.quantidade = remedioDto.quantidade();
        this.validade = remedioDto.validade();
        this.laboratorio = remedioDto.laboratorio();
    }

    public void atualizarInformacoes(@Valid AtualizarRemedioDto atualizarRemedioDto) {
        if(atualizarRemedioDto.nome() != null){
            this.nome = atualizarRemedioDto.nome();
        }

        if(atualizarRemedioDto.via() != null){
            this.via = atualizarRemedioDto.via();
        }

        if(atualizarRemedioDto.laboratorio() != null){
            this.laboratorio = atualizarRemedioDto.laboratorio();
        }
    }

    public void inativar() {
        this.ativo = false;
    }

    public void setAtivar() {
        this.ativo = true;
    }
}
