package com.wildfire.application.services;

import com.wildfire.domain.entities.*;
import com.wildfire.domain.repositories.*;
import com.wildfire.domain.services.AlertaService;
import com.wildfire.domain.valueobjects.Coordinates;
import com.wildfire.domain.enums.StatusFoco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MonitoramentoApplicationService {

    @Autowired
    private PontoDefocoRepository pontoDefocoRepository;

    @Autowired
    private RegiaoRepository regiaoRepository;

    @Autowired
    private AlertaRepository alertaRepository;

    @Autowired
    private AlertaService alertaService;

    public String registrarNovoFoco(Double latitude, Double longitude,
                                    Double intensidade, String regiaoId) {

        Optional<Regiao> regiao = regiaoRepository.findById(regiaoId);
        if (regiao.isEmpty()) {
            throw new IllegalArgumentException("Região não encontrada");
        }

        Coordinates coordenadas = new Coordinates(latitude, longitude);
        PontoDeFoco novoFoco = new PontoDeFoco(coordenadas, intensidade, regiao.get());

        PontoDeFoco focoSalvo = pontoDefocoRepository.save(novoFoco);

        // Criar alerta
        Alerta alerta = alertaService.criarAlertaNovoFoco(focoSalvo);
        alertaRepository.save(alerta);

        return focoSalvo.getId();
    }

    public List<PontoDeFoco> listarFocosAtivos(String regiaoId) {
        Optional<Regiao> regiao = regiaoRepository.findById(regiaoId);
        if (regiao.isEmpty()) {
            throw new IllegalArgumentException("Região não encontrada");
        }

        return pontoDefocoRepository.findByRegiaoAndStatus(regiao.get(), StatusFoco.ATIVO);
    }
}