package com.wildfire.domain.entities;

import com.wildfire.domain.valueobjects.Coordinates;
import com.wildfire.domain.enums.StatusFoco;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "pontos_foco")
public class PontoDeFoco {
    @Id
    private String id;

    @Embedded
    private Coordinates coordenadas;

    @Column(name = "intensidade_calor")
    private Double intensidadeCalor;

    @Column(name = "data_deteccao")
    private LocalDateTime dataDeteccao;

    @Enumerated(EnumType.STRING)
    private StatusFoco status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regiao_id")
    private Regiao regiao;

    @OneToMany(mappedBy = "pontoDeFoco", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Alerta> alertas = new ArrayList<>();

    protected PontoDeFoco() {} // JPA

    public PontoDeFoco(Coordinates coordenadas, Double intensidadeCalor, Regiao regiao) {
        this.id = UUID.randomUUID().toString();
        this.coordenadas = coordenadas;
        this.intensidadeCalor = intensidadeCalor;
        this.dataDeteccao = LocalDateTime.now();
        this.status = StatusFoco.ATIVO;
        this.regiao = regiao;
    }

    public void extinguir() {
        this.intensidadeCalor = 0.0;
        this.coordenadas = null; // Opcional: limpar coordenadas ao extinguir o foco
        this.regiao = null; // Opcional: remover referência à região ao extinguir o foco
        this.dataDeteccao = LocalDateTime.now();
        this.alertas.clear(); // Limpa os alertas ao extinguir o foco
        this.status = StatusFoco.EXTINTO;
    }

    public boolean isAtivoEIntensidade(Double limiteIntensidade) {
        return status == StatusFoco.ATIVO && intensidadeCalor >= limiteIntensidade;
    }

    // Getters
    public String getId() { return id; }
    public Coordinates getCoordenadas() { return coordenadas; }
    public Double getIntensidadeCalor() { return intensidadeCalor; }
    public LocalDateTime getDataDeteccao() { return dataDeteccao; }
    public StatusFoco getStatus() { return status; }
    public Regiao getRegiao() { return regiao; }
    public List<Alerta> getAlertas() { return alertas; }
}