package com.hiberus.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MixbiStreamConfig {

    /*@Value("${spring.kafka.bootstrap.servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.schema.registry.url}")
    private String schemaRegistryUrl;

    @Bean
    public KStream<String, JoinedAvroType> mixbiStream(StreamsBuilder builder) {
        // Cargar los esquemas Avro
        final Serde<RestauranteAvroValue> restauranteValueSerde = new SpecificAvroSerde<>();
        final Serde<OpinionAvroValue> opinionValueSerde = new SpecificAvroSerde<>();
        final Serde<JoinedAvroType> joinedValueSerde = new SpecificAvroSerde<>();

        // Configurar la URL del Schema Registry
        final Map<String, String> serdeConfig = Collections.singletonMap("schema.registry.url", schemaRegistryUrl);
        restauranteValueSerde.configure(serdeConfig, false);
        opinionValueSerde.configure(serdeConfig, false);
        joinedValueSerde.configure(serdeConfig, false);

        // Construir los streams a partir de los topics
        KStream<String, RestauranteAvroValue> restauranteStream = builder.stream("Topic Restaurante", Consumed.with(Serdes.String(), restauranteValueSerde));
        KStream<String, OpinionAvroValue> opinionStream = builder.stream("Topic Opiniones-Procesadas", Consumed.with(Serdes.String(), opinionValueSerde));

        // Realizar el join
        KStream<String, JoinedAvroType> joinedStream = restauranteStream.join(opinionStream,
                (restauranteValue, opinionValue) -> {
                    // Lógica de join aquí. Retorna el tipo JoinedAvroType.
                },
                JoinWindows.of(Duration.ofMinutes(5)), // Ventana temporal si es necesario
                StreamJoined.with(Serdes.String(), restauranteValueSerde, opinionValueSerde)
        );

        // Enviar el stream resultante a un nuevo topic
        joinedStream.to("Topic Opiniones-Restaurantes-Joined", Produced.with(Serdes.String(), joinedValueSerde));

        return joinedStream;
    }*/
}
