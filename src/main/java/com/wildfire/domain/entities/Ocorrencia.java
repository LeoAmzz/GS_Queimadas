package com.wildfire.domain.entities;

import com.wildfire.domain.enums.StatusOcorrencia;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "ocorrencias")
public class Ocorrencia {

    @Id
    private String id;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "data_ocorrencia")
    private LocalDateTime dataOcorrencia;

    @Column(name = "data_finalizacao")
    private LocalDateTime dataFinalizacao;

    @Enumerated(EnumType.STRING)
    private StatusOcorrencia status;

    @Column(name = "observacoes", columnDefinition = "TEXT")
    private String observacoes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ponto_foco_id")
    private PontoDeFoco pontoDeFoco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agente_responsavel_id")
    private AgenteAmbiental agenteResponsavel;

    protected Ocorrencia() {} // Construtor padrão para JPA

    public Ocorrencia(String descricao, String observacoes, PontoDeFoco pontoDeFoco, AgenteAmbiental agenteResponsavel) {
        this.id = UUID.randomUUID().toString();
        this.descricao = descricao;
        this.observacoes = observacoes;
        this.dataOcorrencia = LocalDateTime.now();
        this.status = StatusOcorrencia.EM_ANDAMENTO;
        this.pontoDeFoco = pontoDeFoco;
        this.agenteResponsavel = agenteResponsavel;
    }

    public void finalizarOcorrencia(String observacoes) {
        this.status = StatusOcorrencia.FINALIZADA;
        this.dataFinalizacao = LocalDateTime.now();
        this.observacoes = observacoes;
    }

    // Getters
    public String getId() { return id; }
    public String getDescricao() { return descricao; }
    public LocalDateTime getDataOcorrencia() { return dataOcorrencia; }
    public LocalDateTime getDataFinalizacao() { return dataFinalizacao; }
    public StatusOcorrencia getStatus() { return status; }
    public String getObservacoes() { return observacoes; }
    public PontoDeFoco getPontoDeFoco() { return pontoDeFoco; }
    public AgenteAmbiental getAgenteResponsavel() { return agenteResponsavel; }
}
