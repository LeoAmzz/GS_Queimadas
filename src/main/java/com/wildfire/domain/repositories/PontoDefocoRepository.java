package com.wildfire.domain.repositories;

import com.wildfire.domain.entities.PontoDeFoco;
import com.wildfire.domain.entities.Regiao;
import com.wildfire.domain.enums.StatusFoco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PontoDefocoRepository extends JpaRepository<PontoDeFoco, String> {

    List<PontoDeFoco> findByRegiaoAndStatus(Regiao regiao, StatusFoco status);

    List<PontoDeFoco> findByDataDeteccaoBetween(LocalDateTime inicio, LocalDateTime fim);

    @Query("SELECT p FROM PontoDeFoco p WHERE p.status = :status ORDER BY p.dataDeteccao DESC")
    List<PontoDeFoco> findByStatusOrderByDataDeteccaoDesc(@Param("status") StatusFoco status);
}