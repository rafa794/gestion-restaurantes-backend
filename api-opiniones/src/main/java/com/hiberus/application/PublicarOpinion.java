package com.hiberus.apiopiniones.application;

import com.hiberus.apiopiniones.domain.model.Opinion;
import com.hiberus.apiopiniones.domain.repository.OpinionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublicarOpinion {

    private final OpinionRepository opinionRepository;

    public void execute(Opinion opinion) {
        opinionRepository.save(opinion);
    }
}
