package com.eqmoura.estacionamento.util;

import com.eqmoura.estacionamento.dto.StatusDTO;
import com.eqmoura.estacionamento.model.Status;

public class StatusMapper {
    
        public static StatusDTO toDTO(Status status) {
            StatusDTO statusDTO = new StatusDTO();
    
            statusDTO.setId(status.getId());
            statusDTO.setDescricao(status.getDescricao());
    
            return statusDTO;
        }
    
        public static Status toEntity(StatusDTO statusDTO) {
            Status status = new Status();
    
            status.setId(statusDTO.getId());
            status.setDescricao(statusDTO.getDescricao());
    
            return status;
        }
}
