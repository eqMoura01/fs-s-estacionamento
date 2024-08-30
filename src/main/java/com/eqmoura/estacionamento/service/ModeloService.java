package com.eqmoura.estacionamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eqmoura.estacionamento.model.Modelo;
import com.eqmoura.estacionamento.repository.ModeloRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    public Modelo save(Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    public List<Modelo> findAll() {
        return modeloRepository.findAll();
    }

    public Modelo findById(Long id) {
        Optional<Modelo> modelo = modeloRepository.findById(id);

        if (modelo.isEmpty()) {
            throw new EntityNotFoundException("Modelo com id " + id + " não encontrado");
        }

        return modelo.get();
    }

    public Modelo update(Modelo modelo) {

        Modelo modeloEncontrado = findById(modelo.getId());

        BeanUtils.copyProperties(modelo, modeloEncontrado);

        return modeloRepository.save(modeloEncontrado);
    }

    public void deleteById(Long id) {
        modeloRepository.deleteById(id);
    }

}
