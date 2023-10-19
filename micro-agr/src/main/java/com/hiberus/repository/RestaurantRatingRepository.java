package com.hiberus.repository;

import com.hiberus.model.RestaurantePromedio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<RestaurantePromedio, Integer> {
}
