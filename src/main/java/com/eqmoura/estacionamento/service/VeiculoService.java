package com.eqmoura.estacionamento.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eqmoura.estacionamento.model.Veiculo;
import com.eqmoura.estacionamento.repository.VeiculoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo save(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    public Veiculo findById(Long id) {
        return veiculoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Veículo com id " + id + " não encontrado"));
    }

    public Veiculo update(Veiculo veiculo) {

        Veiculo veiculoEncontrado = findById(veiculo.getId());

        BeanUtils.copyProperties(veiculo, veiculoEncontrado);

        return veiculoRepository.save(veiculoEncontrado);
    }

    public void deleteById(Long id) {
        veiculoRepository.deleteById(id);
    }

}
