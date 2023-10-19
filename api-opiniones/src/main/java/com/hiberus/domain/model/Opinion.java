package com.hiberus.apiopiniones.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombreRestaurante;
    Integer calificacion;
    String comentario;
    LocalDate fecha;
}
