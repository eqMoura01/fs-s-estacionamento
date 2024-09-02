package com.eqmoura.estacionamento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoDTO {
    
    private Long id;
    private ModeloDTO modeloDTO;
    private String placa;
    private String cor;
    private int anoFabricacao;
    private int anoModelo;
}
