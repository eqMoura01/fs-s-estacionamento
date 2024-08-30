package com.eqmoura.estacionamento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoDTO {

    private Long id;
    private String descricao;
}
