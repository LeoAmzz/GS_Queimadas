package com.wildfire.domain.repositories;

import com.wildfire.domain.entities.Regiao;
import com.wildfire.domain.enums.NivelRisco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, String> {
    List<Regiao> findByNivelRisco(NivelRisco nivelRisco);
}
