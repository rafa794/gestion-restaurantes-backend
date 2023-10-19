package com.hiberus.apiopiniones.infrastructure.kafka;

import com.hiberus.apiopiniones.domain.model.Opinion;
import com.hiberus.apiopiniones.infraestructure.kafka.avro.OpinionKey;
import com.hiberus.apiopiniones.infraestructure.kafka.avro.OpinionValue;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    private final KafkaTemplate<OpinionKey, OpinionValue> kafkaTemplate;

    @Autowired
    public KafkaService(KafkaTemplate<OpinionKey, OpinionValue> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOpinion(Opinion opinion) {
        OpinionValue value = new OpinionValue(opinion.getId().toString(), opinion.getNombreRestaurante(), opinion.getCalificacion(), opinion.getComentario(), opinion.getFecha().toString());

        OpinionKey key = new OpinionKey();
        key.setIdOpinion(opinion.getId().toString()); // suponiendo que OpinionKey tiene un campo idOpinion

        kafkaTemplate.send("topic-opiniones", key, value);
    }


    public void sendOpinionTombstone(Long opinionId) {
        OpinionKey key = new OpinionKey();
        key.setIdOpinion(opinionId.toString()); // suponiendo que OpinionKey tiene un campo idOpinion

        kafkaTemplate.send("topic-opiniones", key, null);
    }
}

