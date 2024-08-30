package com.eqmoura.estacionamento.util;

import com.eqmoura.estacionamento.dto.ModeloDTO;
import com.eqmoura.estacionamento.model.Modelo;

public class ModeloMapper {
    
    public static ModeloDTO toDTO(Modelo modelo) {
        ModeloDTO modeloDTO = new ModeloDTO();

        modeloDTO.setId(modelo.getId());
        modeloDTO.setNome(modelo.getNome());
        modeloDTO.setFabricante(FabricanteMapper.toDTO(modelo.getMarca()));
        modeloDTO.setTipo(TipoMapper.toDTO(modelo.getTipo()));

        return modeloDTO;
    }

    public static Modelo toEntity(ModeloDTO modeloDTO) {
        Modelo modelo = new Modelo();

        modelo.setId(modeloDTO.getId());
        modelo.setNome(modeloDTO.getNome());
        modelo.setMarca(FabricanteMapper.toEntity(modeloDTO.getFabricante()));
        modelo.setTipo(TipoMapper.toEntity(modeloDTO.getTipo()));

        return modelo;
    }
}
