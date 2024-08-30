package com.eqmoura.estacionamento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoDTO {

    private Long id;
    private String placa;
    private String cor;
    private ModeloDTO modelo;
    private TipoDTO tipo;
}
