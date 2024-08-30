package com.eqmoura.estacionamento.util;

import com.eqmoura.estacionamento.dto.VeiculoDTO;
import com.eqmoura.estacionamento.model.Veiculo;

public class VeiculoMapper {
    
    public static VeiculoDTO toDTO(Veiculo veiculo) {
        VeiculoDTO veiculoDTO = new VeiculoDTO();

        veiculoDTO.setId(veiculo.getId());
        veiculoDTO.setPlaca(veiculo.getPlaca());
        veiculoDTO.setCor(veiculo.getCor());
        veiculoDTO.setModelo(ModeloMapper.toDTO(veiculo.getModelo()));
        veiculoDTO.setTipo(TipoMapper.toDTO(veiculo.getTipo()));

        return veiculoDTO;
    }

    public static Veiculo toEntity(VeiculoDTO veiculoDTO) {
        Veiculo veiculo = new Veiculo();

        veiculo.setId(veiculoDTO.getId());
        veiculo.setPlaca(veiculoDTO.getPlaca());
        veiculo.setCor(veiculoDTO.getCor());
        veiculo.setModelo(ModeloMapper.toEntity(veiculoDTO.getModelo()));
        veiculo.setTipo(TipoMapper.toEntity(veiculoDTO.getTipo()));

        return veiculo;
    }
}
