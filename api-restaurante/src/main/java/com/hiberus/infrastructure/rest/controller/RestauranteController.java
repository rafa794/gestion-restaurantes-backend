package com.hiberus.apirestaurante.infrastructure.rest.controller;

import com.hiberus.apirestaurante.application.CrearRestaurante;
import com.hiberus.apirestaurante.application.EliminarRestaurante;
import com.hiberus.apirestaurante.domain.model.Restaurante;
import com.hiberus.apirestaurante.infrastructure.kafka.KafkaService;
import com.hiberus.apirestaurante.infrastructure.rest.dto.RestauranteDTO;
import com.hiberus.apirestaurante.infrastructure.rest.mappers.RestauranteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/restaurantes")
public class RestauranteController {

    @Autowired
    private KafkaService kafkaService;

    @Autowired
    private CrearRestaurante crearRestauranteService;

    @Autowired
    private EliminarRestaurante eliminarRestauranteService;

    @Autowired
    private RestauranteMapper restauranteMapper;

    @PostMapping
    public ResponseEntity<Void> crearRestaurante(@Valid @RequestBody RestauranteDTO restauranteDTO) {
        Restaurante restaurante = restauranteMapper.toEntity(restauranteDTO);
        crearRestauranteService.execute(restaurante);
        kafkaService.sendRestaurante(restaurante);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRestaurante(@PathVariable Integer id) {
        try {
            eliminarRestauranteService.execute(id);
            kafkaService.sendRestauranteTombstone(Long.valueOf(id)); // Enviar mensaje Tombstone al topic de Kafka
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // Aquí deberías manejar las excepciones específicas, como "RestauranteNoExiste".
            return ResponseEntity.notFound().build();
        }
    }
}
