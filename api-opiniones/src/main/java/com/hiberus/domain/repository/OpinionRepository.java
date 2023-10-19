package com.hiberus.apiopiniones.domain.repository;

import com.hiberus.apiopiniones.domain.model.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpinionRepository extends JpaRepository<Opinion, Long> {
}
