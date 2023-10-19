package com.hiberus.apirestaurante.application;

import com.hiberus.apirestaurante.domain.repository.RestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EliminarRestaurante {

    private final RestauranteRepository restauranteRepository;

    public void execute(int id) {
        restauranteRepository.deleteById(id);
    }
}
