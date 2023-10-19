package com.hiberus.apirestaurante.domain.repository;

import com.hiberus.apirestaurante.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {
    // No es necesario añadir métodos adicionales aquí a menos que necesites consultas personalizadas.
}
