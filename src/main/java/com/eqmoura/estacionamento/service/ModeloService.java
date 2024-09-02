package com.eqmoura.estacionamento.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eqmoura.estacionamento.dto.ModeloDTO;
import com.eqmoura.estacionamento.model.Modelo;
import com.eqmoura.estacionamento.repository.ModeloRepository;
import com.eqmoura.estacionamento.util.ModeloMapper;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    public ModeloDTO save(ModeloDTO modeloDTO) {
        return ModeloMapper.toModeloDTO(modeloRepository.save(ModeloMapper.toModelo(modeloDTO)));
    }

    public List<ModeloDTO> findAll() {
        return ModeloMapper.toModeloDTOList(modeloRepository.findAll());
    }

    public ModeloDTO findById(Long id) {
        return ModeloMapper.toModeloDTO(modeloRepository.findById(id).orElse(null));
    }

    public ModeloDTO update(ModeloDTO modeloDTO) {
        Modelo modeloDB = ModeloMapper.toModelo(this.findById(modeloDTO.getId()));

        BeanUtils.copyProperties(ModeloMapper.toModelo(modeloDTO), modeloDB, "id");

        return save(ModeloMapper.toModeloDTO(modeloDB));
    }

    public void delete(Long id) {
        this.findById(id);
        modeloRepository.deleteById(id);
    }
}
