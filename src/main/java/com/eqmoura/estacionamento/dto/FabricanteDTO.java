package com.eqmoura.estacionamento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FabricanteDTO {
    private Long id;
    private String nome;
    private String paisOrigem;
    private Boolean ativo;
}
