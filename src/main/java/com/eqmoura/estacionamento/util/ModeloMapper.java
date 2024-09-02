package com.eqmoura.estacionamento.util;

import java.util.ArrayList;
import java.util.List;

import com.eqmoura.estacionamento.dto.ModeloDTO;
import com.eqmoura.estacionamento.model.Modelo;

public class ModeloMapper {
    
    public static ModeloDTO toModeloDTO(Modelo modelo) {
        ModeloDTO modeloDTO = new ModeloDTO();
        modeloDTO.setId(modelo.getId());
        modeloDTO.setNome(modelo.getNome());
        modeloDTO.setFabricante(FabricanteMapper.toDTO(modelo.getFabricante()));
        return modeloDTO;
    }
    
    public static Modelo toModelo(ModeloDTO modeloDTO) {
        Modelo modelo = new Modelo();
        modelo.setId(modeloDTO.getId());
        modelo.setNome(modeloDTO.getNome());
        modelo.setFabricante(FabricanteMapper.toEntity(modeloDTO.getFabricante()));
        return modelo;
    }
    
    public static List<ModeloDTO> toModeloDTOList(List<Modelo> modelos) {
        List<ModeloDTO> modelosDTO = new ArrayList<>();
        for (Modelo modelo : modelos) {
            modelosDTO.add(toModeloDTO(modelo));
        }
        return modelosDTO;
    }
    
    public static List<Modelo> toModeloList(List<ModeloDTO> modelosDTO) {
        List<Modelo> modelos = new ArrayList<>();
        for (ModeloDTO modeloDTO : modelosDTO) {
            modelos.add(toModelo(modeloDTO));
        }
        return modelos;
    }
}
