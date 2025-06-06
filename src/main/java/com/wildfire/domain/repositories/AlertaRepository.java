package com.wildfire.domain.repositories;

import com.wildfire.domain.entities.Alerta;
import com.wildfire.domain.entities.AgenteAmbiental;
import com.wildfire.domain.enums.NivelUrgencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AlertaRepository extends JpaRepository<Alerta, String> {
    List<Alerta> findByDestinatarioOrderByDataCriacaoDesc(AgenteAmbiental agente);
    List<Alerta> findByUrgenciaAndDataCriacaoAfter(NivelUrgencia urgencia, LocalDateTime data);
}

