package com.hiberus.apirestaurante.infrastructure.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestauranteDTO {
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
}
