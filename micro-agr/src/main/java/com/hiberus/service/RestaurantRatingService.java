package com.hiberus.service;

import com.hiberus.model.RestaurantePromedio;
import com.hiberus.repository.RestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestauranteService {

    private final RestauranteRepository restauranteRepository;

    public Optional<RestaurantePromedio> findById(Integer id) {
        return restauranteRepository.findById(id);
    }

}
