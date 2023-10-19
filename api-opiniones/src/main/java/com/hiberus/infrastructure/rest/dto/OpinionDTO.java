package com.hiberus.apiopiniones.infrastructure.rest.dto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class OpinionDTO {
    private Long id;
    private String nombreRestaurante;
    private Integer calificacion;
    private String comentario;
    private LocalDate fecha;
}
