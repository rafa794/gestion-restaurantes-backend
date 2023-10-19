package com.hiberus.service;

/*import com.hiberus.kafka.avro.OpinionValue;
import com.hiberus.kafka.avro.RestauranteKey;
import com.hiberus.kafka.avro.RestauranteValue;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.stereotype.Service;*/

import org.springframework.stereotype.Service;

@Service
public class MixbiService {
    /*

    public void processJoin() {
        StreamsBuilder builder = new StreamsBuilder();

        KStream<RestauranteKey, RestauranteValue> restauranteStream = builder.stream("topic-restaurantes");
        KStream<String, OpinionValue> opinionesMapeadasStream = builder.stream("topic-opiniones_mapeadas");

        // Join streams
        KStream<RestauranteKey, String> joined = restauranteStream.join(
                opinionesMapeadasStream,
                (restValue, opinionValue) -> "Nombre del restaurante: " + restValue.getNombre() + ", Opinión: " + opinionValue.getComentario(),
                JoinWindows.of(Duration.ofMinutes(5))
        );

        // Produce el resultado a otro topic
        joined.to("topic-opiniones-restaurantes-joined");

        KafkaStreams streams = new KafkaStreams(builder.build(), /* tus properties de Kafka Streams );
        streams.start();
        */
}
