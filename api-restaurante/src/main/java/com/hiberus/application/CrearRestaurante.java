package com.hiberus.apirestaurante.application;

import com.hiberus.apirestaurante.domain.model.Restaurante;
import com.hiberus.apirestaurante.domain.repository.RestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CrearRestaurante {

    private final RestauranteRepository restauranteRepository;

    public void execute(Restaurante restaurante) {
        restauranteRepository.save(restaurante);
    }
}
