package com.wildfire.domain.repositories;

import com.wildfire.domain.entities.Sensor;
import com.wildfire.domain.entities.Regiao;
import com.wildfire.domain.enums.StatusSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, String> {
    List<Sensor> findByRegiaoAndStatus(Regiao regiao, StatusSensor status);
}
