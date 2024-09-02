package com.eqmoura.estacionamento.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eqmoura.estacionamento.dto.VeiculoDTO;
import com.eqmoura.estacionamento.model.Veiculo;
import com.eqmoura.estacionamento.repository.VeiculoRepository;
import com.eqmoura.estacionamento.util.VeiculoMapper;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public VeiculoDTO save(VeiculoDTO veiculoDTO) {
        return VeiculoMapper.toVeiculoDTO(veiculoRepository.save(VeiculoMapper.toVeiculo(veiculoDTO)));
    }

    public VeiculoDTO update(VeiculoDTO veiculoDTO) {
        Veiculo veiculoDB = veiculoRepository.findById(veiculoDTO.getId()).get();

        BeanUtils.copyProperties(veiculoDTO, veiculoDB);

        return VeiculoMapper.toVeiculoDTO(veiculoRepository.save(veiculoDB));
    }

    public List<VeiculoDTO> findAll() {
        return VeiculoMapper.toVeiculoDTO(veiculoRepository.findAll());
    }

    public VeiculoDTO findById(Long id) {
        return VeiculoMapper.toVeiculoDTO(veiculoRepository.findById(id).get());
    }

    public void delete(Long id) {
        veiculoRepository.deleteById(id);
    }
}
