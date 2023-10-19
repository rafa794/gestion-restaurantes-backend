package com.hiberus.apirestaurante.infrastructure.kafka;

import com.hiberus.apirestaurante.domain.model.Restaurante;
import com.hiberus.apirestaurante.infraestructure.kafka.avro.RestauranteValue;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    private final KafkaTemplate<String, RestauranteValue> kafkaTemplate;

    @Autowired
    public KafkaService(KafkaTemplate<String, RestauranteValue> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendRestaurante(Restaurante restaurante) {
        RestauranteValue value = new RestauranteValue(restaurante.getId(), restaurante.getNombre(), restaurante.getDireccion(), restaurante.getTelefono());
        kafkaTemplate.send("topic-restaurantes", restaurante.getId().toString(), value);
    }

    public void sendRestauranteTombstone(Long restauranteId) {
        // Envío del mensaje Tombstone al topic
        // Aquí, opinionId sería la clave y el valor sería `null`
        kafkaTemplate.send(new ProducerRecord<>("topic-restaurantes", restauranteId.toString(), null));
    }

}
