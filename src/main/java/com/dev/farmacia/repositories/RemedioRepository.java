package com.dev.farmacia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.farmacia.entities.Remedio;

public interface RemedioRepository extends JpaRepository<Remedio, Long>{

}
