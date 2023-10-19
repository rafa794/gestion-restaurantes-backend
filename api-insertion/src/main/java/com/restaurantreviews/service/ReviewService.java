package com.restaurantreviews.servicio;

import com.restaurantreviews.modelo.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private static final String TOPIC = "Opiniones-raw";

    @Autowired
    private KafkaTemplate<String, Review> kafkaTemplate;

    public String createReview(Review review) {
        kafkaTemplate.send(TOPIC, review);
        return "Opinion enviada!";
    }

    // Puedes agregar más lógica si es necesario
}
