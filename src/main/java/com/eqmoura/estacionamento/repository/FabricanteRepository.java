package com.eqmoura.estacionamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eqmoura.estacionamento.model.Fabricante;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {

    @Query(value = "SELECT * FROM fabricante WHERE ativo = true", nativeQuery = true)
    public List<Fabricante> findByAtivoTrue();

    public List<Fabricante> findByNomeContainingIgnoreCase(String nome);

    public List<Fabricante> findByNomeContainingIgnoreCaseAndAtivoTrue(String nome);
}
