package com.eqmoura.estacionamento.util;

import com.eqmoura.estacionamento.dto.TipoDTO;
import com.eqmoura.estacionamento.model.Tipo;

public class TipoMapper {
    
    public static TipoDTO toDTO(Tipo tipo) {
        TipoDTO tipoDTO = new TipoDTO();

        tipoDTO.setId(tipo.getId());
        tipoDTO.setDescricao(tipo.getDescricao());

        return tipoDTO;
    }

    public static Tipo toEntity(TipoDTO tipoDTO) {
        Tipo tipo = new Tipo();

        tipo.setId(tipoDTO.getId());
        tipo.setDescricao(tipoDTO.getDescricao());

        return tipo;
    }

}
