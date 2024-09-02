package com.eqmoura.estacionamento.util;

import java.util.List;

import com.eqmoura.estacionamento.dto.VeiculoDTO;
import com.eqmoura.estacionamento.model.Veiculo;

public class VeiculoMapper {

    public static Veiculo toVeiculo(VeiculoDTO veiculoDTO) {
        Veiculo veiculo = new Veiculo();
        veiculo.setId(veiculoDTO.getId());
        veiculo.setModelo(ModeloMapper.toModelo(veiculoDTO.getModeloDTO()));
        veiculo.setPlaca(veiculoDTO.getPlaca());
        veiculo.setCor(veiculoDTO.getCor());
        veiculo.setAnoFabricacao(veiculoDTO.getAnoFabricacao());
        veiculo.setAnoModelo(veiculoDTO.getAnoModelo());
        return veiculo;
    }

    public static VeiculoDTO toVeiculoDTO(Veiculo veiculo) {
        VeiculoDTO veiculoDTO = new VeiculoDTO();
        veiculoDTO.setId(veiculo.getId());
        veiculoDTO.setModeloDTO(ModeloMapper.toModeloDTO(veiculo.getModelo()));
        veiculoDTO.setPlaca(veiculo.getPlaca());
        veiculoDTO.setCor(veiculo.getCor());
        veiculoDTO.setAnoFabricacao(veiculo.getAnoFabricacao());
        veiculoDTO.setAnoModelo(veiculo.getAnoModelo());
        return veiculoDTO;
    }

    public static List<VeiculoDTO> toVeiculoDTO(List<Veiculo> veiculos) {
        return veiculos.stream().map(VeiculoMapper::toVeiculoDTO).toList();
    }

    public static List<Veiculo> toVeiculo(List<VeiculoDTO> veiculosDTO) {
        return veiculosDTO.stream().map(VeiculoMapper::toVeiculo).toList();
    }
}
