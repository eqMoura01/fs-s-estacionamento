package com.eqmoura.estacionamento.util;

import java.util.List;

import com.eqmoura.estacionamento.dto.ModeloDTO;
import com.eqmoura.estacionamento.model.Modelo;

/**
 * ModeloMapper
 */
public class ModeloMapper {

    public static Modelo toModelo(ModeloDTO modeloDTO) {
        Modelo modelo = new Modelo();
        modelo.setId(modeloDTO.getId());
        modelo.setNome(modeloDTO.getNome());
        modelo.setFabricante(FabricanteMapper.toEntity(modeloDTO.getFabricante()));
        return modelo;
    }

    public static ModeloDTO toModeloDTO(Modelo modelo) {
        ModeloDTO modeloDTO = new ModeloDTO();
        modeloDTO.setId(modelo.getId());
        modeloDTO.setNome(modelo.getNome());
        modeloDTO.setFabricante(FabricanteMapper.toDTO(modelo.getFabricante()));
        return modeloDTO;
    }

    public static List<ModeloDTO> toModeloDTO(List<Modelo> modelos) {
        return modelos.stream().map(ModeloMapper::toModeloDTO).toList();
    }

}