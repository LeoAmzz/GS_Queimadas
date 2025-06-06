package com.wildfire.domain.repositories;

import com.wildfire.domain.entities.Ocorrencia;
import com.wildfire.domain.entities.AgenteAmbiental;
import com.wildfire.domain.enums.StatusOcorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, String> {
    List<Ocorrencia> findByAgenteResponsavelAndStatus(AgenteAmbiental agente, StatusOcorrencia status);
    List<Ocorrencia> findByDataOcorrenciaBetween(LocalDateTime inicio, LocalDateTime fim);
}
