package com.eqmoura.estacionamento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModeloDTO {
    private Long id;
    private String nome;
    private FabricanteDTO fabricante;
}
