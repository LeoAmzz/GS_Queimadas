package com.wildfire.domain.entities;

import com.wildfire.domain.valueobjects.Coordinates;
import com.wildfire.domain.enums.StatusSensor;
import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "sensores")
public class Sensor {
    @Id
    private String id;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Embedded
    private Coordinates localizacao;

    @Enumerated(EnumType.STRING)
    private StatusSensor status;

    @Column(name = "data_instalacao")
    private LocalDateTime dataInstalacao;

    @Column(name = "ultima_leitura")
    private LocalDateTime ultimaLeitura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regiao_id")
    private Regiao regiao;

    protected Sensor() {} // JPA

    public Sensor(String tipo, Coordinates localizacao, Regiao regiao) {
        this.id = UUID.randomUUID().toString();
        this.tipo = tipo;
        this.localizacao = localizacao;
        this.status = StatusSensor.ATIVO;
        this.dataInstalacao = LocalDateTime.now();
        this.regiao = regiao;
    }

    public void marcarComoInativo() {
        this.status = StatusSensor.INATIVO;
    }

    public void reativar() {
        this.status = StatusSensor.ATIVO;
    }

    public void registrarLeitura() {
        this.ultimaLeitura = LocalDateTime.now();
    }

    // Getters
    public String getId() { return id; }
    public String getTipo() { return tipo; }
    public Coordinates getLocalizacao() { return localizacao; }
    public StatusSensor getStatus() { return status; }
    public LocalDateTime getDataInstalacao() { return dataInstalacao; }
    public LocalDateTime getUltimaLeitura() { return ultimaLeitura; }
    public Regiao getRegiao() { return regiao; }
}