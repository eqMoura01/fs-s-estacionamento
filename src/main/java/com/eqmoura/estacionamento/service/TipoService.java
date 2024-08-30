package com.eqmoura.estacionamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eqmoura.estacionamento.model.Tipo;
import com.eqmoura.estacionamento.repository.TipoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TipoService {

    @Autowired
    private TipoRepository tipoRepository;

    public Tipo save(Tipo tipo) {
        return tipoRepository.save(tipo);
    }

    public List<Tipo> findAll() {
        return tipoRepository.findAll();
    }

    public Tipo findById(Long id) {
        Optional<Tipo> tipo = tipoRepository.findById(id);

        if (tipo.isEmpty()) {
            throw new EntityNotFoundException("Tipo com id " + id + " não encontrado");
        }

        return tipo.get();
    }

    public Tipo update(Tipo tipo) {

        Tipo tipoEncontrado = findById(tipo.getId());

        BeanUtils.copyProperties(tipo, tipoEncontrado);

        return tipoRepository.save(tipo);
    }

    public void deleteById(Long id) {
        tipoRepository.deleteById(id);
    }
}
