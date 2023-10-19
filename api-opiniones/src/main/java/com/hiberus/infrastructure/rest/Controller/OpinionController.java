package com.hiberus.apiopiniones.infrastructure.rest.Controller;

import com.hiberus.apiopiniones.application.EliminarOpinion;
import com.hiberus.apiopiniones.application.PublicarOpinion;
import com.hiberus.apiopiniones.domain.model.Opinion;
import com.hiberus.apiopiniones.infrastructure.rest.dto.OpinionDTO;
import com.hiberus.apiopiniones.infrastructure.rest.mappers.OpinionMapper;
import com.hiberus.apiopiniones.infrastructure.kafka.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/opiniones")
public class OpinionController {

    @Autowired
    private PublicarOpinion publicarOpinionService;

    @Autowired
    private KafkaService kafkaService;

    @Autowired
    private EliminarOpinion eliminarOpinionService;

    @Autowired
    private OpinionMapper opinionMapper;

    @PostMapping
    public ResponseEntity<Void> publicarOpinion(@Valid @RequestBody OpinionDTO opinionDTO) {
        Opinion opinion = opinionMapper.toEntity(opinionDTO);

        if(opinion.getFecha() == null) {
            opinion.setFecha(LocalDate.now());
        }
        publicarOpinionService.execute(opinion);
        kafkaService.sendOpinion(opinion);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOpinion(@PathVariable Long id) {
        try {
            eliminarOpinionService.execute(id);
            // Envío del mensaje Tombstone a Kafka
            kafkaService.sendOpinionTombstone(id); // Suponiendo que tienes un método que maneje esto
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // Aquí deberías manejar las excepciones específicas, como "OpinionNoExiste".
            return ResponseEntity.notFound().build();
        }
    }

}
