package com.hiberus.controller;

import com.hiberus.model.RestaurantRating;
import com.hiberus.service.RestaurantRatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurantes")
@RequiredArgsConstructor
public class RestauranteController {

    private final RestaurantRatingService restauranteService;

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantRating> getRestauranteById(@PathVariable Integer id) {
        return restauranteService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Aquí puedes agregar más endpoints según tus necesidades
}
