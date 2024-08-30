package com.eqmoura.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eqmoura.estacionamento.model.Tipo;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Long> {
    
}
