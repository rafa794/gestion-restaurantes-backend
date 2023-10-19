package com.hiberus.apirestaurante.infrastructure.rest.mappers;

import com.hiberus.apirestaurante.domain.model.Restaurante;
import com.hiberus.apirestaurante.infrastructure.rest.dto.RestauranteDTO;
import org.springframework.stereotype.Component;

@Component
public class RestauranteMapper {

    public Restaurante toEntity(RestauranteDTO dto) {
        return new Restaurante(dto.getId(), dto.getNombre(), dto.getDireccion(), dto.getTelefono());
    }

    public RestauranteDTO toDTO(Restaurante restaurante) {
        RestauranteDTO dto = new RestauranteDTO();
        dto.setId(restaurante.getId());
        dto.setNombre(restaurante.getNombre());
        dto.setDireccion(restaurante.getDireccion());
        dto.setTelefono(restaurante.getTelefono());
        return dto;
    }
}
