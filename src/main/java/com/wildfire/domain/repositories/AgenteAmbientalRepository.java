package com.wildfire.domain.repositories;

import com.wildfire.domain.entities.AgenteAmbiental;
import com.wildfire.domain.enums.StatusAgente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AgenteAmbientalRepository extends JpaRepository<AgenteAmbiental, String> {
    List<AgenteAmbiental> findByStatus(StatusAgente status);
    Optional<AgenteAmbiental> findByEmail(String email);
}
