package com.wildfire.domain.entities;

import com.wildfire.domain.enums.TipoAlerta;
import com.wildfire.domain.enums.NivelUrgencia;
import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "alertas")
public class Alerta {
    @Id
    private String id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "mensagem", columnDefinition = "TEXT")
    private String mensagem;

    @Enumerated(EnumType.STRING)
    private TipoAlerta tipo;

    @Enumerated(EnumType.STRING)
    private NivelUrgencia urgencia;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "visualizado")
    private Boolean visualizado = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ponto_foco_id")
    private PontoDeFoco pontoDeFoco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agente_id")
    private AgenteAmbiental destinatario;

    protected Alerta() {} // JPA

    public Alerta(String titulo, String mensagem, TipoAlerta tipo,
                  NivelUrgencia urgencia, PontoDeFoco pontoDeFoco) {
        this.id = UUID.randomUUID().toString();
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.tipo = tipo;
        this.urgencia = urgencia;
        this.dataCriacao = LocalDateTime.now();
        this.pontoDeFoco = pontoDeFoco;
        this.visualizado = false;
    }

    public void atribuirDestinatario(AgenteAmbiental agente) {
        this.destinatario = agente;
    }

    public void marcarComoVisualizado() {
        this.visualizado = true;
    }

    // Getters
    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getMensagem() { return mensagem; }
    public TipoAlerta getTipo() { return tipo; }
    public NivelUrgencia getUrgencia() { return urgencia; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public Boolean getVisualizado() { return visualizado; }
    public PontoDeFoco getPontoDeFoco() { return pontoDeFoco; }
    public AgenteAmbiental getDestinatario() { return destinatario; }
}