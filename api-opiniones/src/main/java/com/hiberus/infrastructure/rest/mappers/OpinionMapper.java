package com.hiberus.apiopiniones.infrastructure.rest.mappers;

import com.hiberus.apiopiniones.domain.model.Opinion;
import com.hiberus.apiopiniones.infrastructure.rest.dto.OpinionDTO;
import org.springframework.stereotype.Component;

@Component
public class OpinionMapper {

    public Opinion toEntity(OpinionDTO dto) {
        return new Opinion(dto.getId(), dto.getNombreRestaurante(), dto.getCalificacion(), dto.getComentario(), dto.getFecha());
    }

    public OpinionDTO toDTO(Opinion opinion) {
        OpinionDTO dto = new OpinionDTO();
        dto.setId(opinion.getId());
        dto.setNombreRestaurante(opinion.getNombreRestaurante());
        dto.setCalificacion(opinion.getCalificacion());
        dto.setComentario(opinion.getComentario());
        dto.setFecha(opinion.getFecha());
        return dto;
    }
}
