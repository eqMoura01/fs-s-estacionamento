package com.eqmoura.estacionamento.util;

import com.eqmoura.estacionamento.dto.FabricanteDTO;
import com.eqmoura.estacionamento.model.Fabricante;

public class FabricanteMapper {
    
    public static FabricanteDTO toDTO(Fabricante fabricante) {
        FabricanteDTO dto = new FabricanteDTO();
        dto.setId(fabricante.getId());
        dto.setNome(fabricante.getNome());
        dto.setPaisOrigem(fabricante.getPaisOrigem());
        dto.setAtivo(fabricante.getAtivo());
        return dto;
    }
    
    public static Fabricante toEntity(FabricanteDTO dto) {
        Fabricante fabricante = new Fabricante();
        fabricante.setId(dto.getId());
        fabricante.setNome(dto.getNome());
        fabricante.setPaisOrigem(dto.getPaisOrigem());
        fabricante.setAtivo(dto.getAtivo());
        return fabricante;
    }
}
