package com.eqmoura.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eqmoura.estacionamento.model.Tipo;

public interface TipoRepository extends JpaRepository<Tipo, Long> {
    
}
