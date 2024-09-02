package com.eqmoura.estacionamento.service;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;

import java.util.regex.Pattern;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eqmoura.estacionamento.dto.VeiculoDTO;
import com.eqmoura.estacionamento.exceptions.VeiculoException;
import com.eqmoura.estacionamento.model.Veiculo;
import com.eqmoura.estacionamento.repository.VeiculoRepository;
import com.eqmoura.estacionamento.util.VeiculoMapper;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    private static final String REGEX_PLACA = "^[A-Z]{3}[0-9]{1}[A-Z0-9]{1}[0-9]{2}$";

    public VeiculoDTO save(VeiculoDTO veiculoDTO) throws VeiculoException {

        this.validarAno(VeiculoMapper.toVeiculo(veiculoDTO));
        this.validaPlaca(veiculoDTO.getPlaca());

        return VeiculoMapper.toVeiculoDTO(veiculoRepository.save(VeiculoMapper.toVeiculo(veiculoDTO)));
    }

    public VeiculoDTO update(VeiculoDTO veiculoDTO) throws VeiculoException {
        Veiculo veiculo = VeiculoMapper.toVeiculo(veiculoDTO);

        Veiculo veiculoDB = veiculoRepository.findById(veiculo.getId()).get();

        BeanUtils.copyProperties(veiculo, veiculoDB);

        return save(VeiculoMapper.toVeiculoDTO(veiculoDB));
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

    private void validarAno(Veiculo veiculo) throws VeiculoException {
        if (veiculo.getAnoFabricacao() > veiculo.getAnoModelo()) {
            throw new VeiculoException("Ano inválido. O ano de fabricação não pode ser maior que o ano do modelo.");
        }

        if (veiculo.getAnoFabricacao() > LocalDate.now().getYear()) {
            throw new VeiculoException("Ano inválido. O ano de fabricação não pode ser maior que o ano atual.");
        }
    }

    private void validaPlaca(String placa) throws VeiculoException {
        Pattern pattern = Pattern.compile(REGEX_PLACA);
        Matcher matcher = pattern.matcher(placa);

        if (!matcher.matches()) {
            throw new VeiculoException("Placa inválida. O modelo da placa deve seguir o padrão AAA0A00 ou AAA0000.");
        }
    }
}
