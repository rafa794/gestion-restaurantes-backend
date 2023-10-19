package com.hiberus.microserviciopcs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.hiberus.microserviciopcs.avro.OpinionKey;
import com.hiberus.microserviciopcs.avro.OpinionValue;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class microservicioPCSApplication {

	private static final Logger log = LoggerFactory.getLogger(microservicioPCSApplication.class);

	@Autowired
	private KafkaTemplate<String, OpinionValue> kafkaTemplate;

	public static void main(String[] args) {
		SpringApplication.run(microservicioPCSApplication.class, args);
	}

	@KafkaListener(topics = "topic-opiniones")
	public void process(ConsumerRecord<OpinionKey, OpinionValue> opinion) {
		log.info("Received message from topic {} in partition {} and offset {} with key {}",
				opinion.topic(), opinion.partition(), opinion.offset(), opinion.key());

		OpinionValue receivedOpinion = opinion.value();

		// Transformar la fecha
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate parsedDate = LocalDate.parse(receivedOpinion.getFecha(), inputFormatter);

		// Formatear la fecha con el nuevo formato
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("EEEE, d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
		String formattedDate = parsedDate.format(outputFormatter);
		receivedOpinion.setFecha(formattedDate);

		// Producir al topic opiniones-mapeadas
		kafkaTemplate.send("topic-opiniones_mapeadas", receivedOpinion);
	}

}
