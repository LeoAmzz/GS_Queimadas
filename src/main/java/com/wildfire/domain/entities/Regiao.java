package com.wildfire.domain.entities;

import com.wildfire.domain.enums.NivelRisco;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "regioes")
public class Regiao {
    @Id
    private String id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "area_km2")
    private Double areaKm2;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_risco")
    private NivelRisco nivelRisco;

    @OneToMany(mappedBy = "regiao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PontoDeFoco> pontosDeFoco = new ArrayList<>();

    @OneToMany(mappedBy = "regiao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Sensor> sensores = new ArrayList<>();

    protected Regiao() {} // JPA

    public Regiao(String nome, Double areaKm2, NivelRisco nivelRisco) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.areaKm2 = areaKm2;
        this.nivelRisco = nivelRisco;
    }

    public void atualizarNivelRisco(NivelRisco novoNivel) {
        this.nivelRisco = novoNivel;
    }

    public long contarFocosAtivos() {
        return pontosDeFoco.stream()
                .filter(foco -> foco.getStatus() == com.wildfire.domain.enums.StatusFoco.ATIVO)
                .count();
    }

    // Getters
    public String getId() { return id; }
    public String getNome() { return nome; }
    public Double getAreaKm2() { return areaKm2; }
    public NivelRisco getNivelRisco() { return nivelRisco; }
    public List<PontoDeFoco> getPontosDeFoco() { return pontosDeFoco; }
    public List<Sensor> getSensores() { return sensores; }
}