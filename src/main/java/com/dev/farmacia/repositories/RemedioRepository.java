package com.dev.farmacia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.farmacia.entities.Remedio;

public interface RemedioRepository extends JpaRepository<Remedio, Long>{

    List<Remedio> findAllByAtivoTrue();

}
