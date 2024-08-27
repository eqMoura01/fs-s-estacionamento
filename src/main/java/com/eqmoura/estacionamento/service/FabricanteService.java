package com.eqmoura.estacionamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eqmoura.estacionamento.model.Fabricante;
import com.eqmoura.estacionamento.repository.FabricanteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FabricanteService {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    public Fabricante save(Fabricante fabricante) {
        return fabricanteRepository.save(fabricante);
    }

    public List<Fabricante> findAll() {
        return fabricanteRepository.findAll();
    }

    public Fabricante findById(Long id) {

        Optional<Fabricante> fabricante = fabricanteRepository.findById(id);

        if (fabricante.isEmpty()) {
            throw new EntityNotFoundException("Fabricante com id " + id + "não encontrado");
        }

        return fabricante.get();
    }

    public Fabricante update(Fabricante fabricante) {

        Fabricante fabricanteDB = findById(fabricante.getId());

        BeanUtils.copyProperties(fabricante, fabricanteDB);

        return fabricanteRepository.save(fabricante);
    }

    public void delete(Long id) {
        Fabricante fabricante = findById(id);

        fabricante.setAtivo(false);
        save(fabricante);
    }

    public List<Fabricante> findAllAtivos() {
        return fabricanteRepository.findByAtivoTrue();
    }

}
