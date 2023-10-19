package com.hiberus.apiopiniones.application;

import com.hiberus.apiopiniones.domain.repository.OpinionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EliminarOpinion {

    private final OpinionRepository opinionRepository;

    public void execute(Long idOpinion) {
        opinionRepository.deleteById(idOpinion);
    }
}
