package com.eqmoura.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eqmoura.estacionamento.model.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {
    
}
