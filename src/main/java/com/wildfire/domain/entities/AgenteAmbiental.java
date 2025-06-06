package com.wildfire.domain.entities;

import com.wildfire.domain.enums.StatusAgente;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "agentes_ambientais")
public class AgenteAmbiental {
    @Id
    private String id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "especializacao")
    private String especializacao;

    @Enumerated(EnumType.STRING)
    private StatusAgente status;

    @OneToMany(mappedBy = "destinatario", fetch = FetchType.LAZY)
    private List<Alerta> alertasRecebidos = new ArrayList<>();

    @OneToMany(mappedBy = "agenteResponsavel", fetch = FetchType.LAZY)
    private List<Ocorrencia> ocorrenciasResponsavel = new ArrayList<>();

    protected AgenteAmbiental() {} // JPA

    public AgenteAmbiental(String nome, String email, String telefone, String especializacao) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.especializacao = especializacao;
        this.status = StatusAgente.DISPONIVEL;
    }

    public void marcarComoOcupado() {
        this.status = StatusAgente.OCUPADO;
    }

    public void marcarComoDisponivel() {
        this.status = StatusAgente.DISPONIVEL;
    }

    public void inativar() {
        this.status = StatusAgente.INATIVO;
    }

    // Getters
    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public String getEspecializacao() { return especializacao; }
    public StatusAgente getStatus() { return status; }
    public List<Alerta> getAlertasRecebidos() { return alertasRecebidos; }
    public List<Ocorrencia> getOcorrenciasResponsavel() { return ocorrenciasResponsavel; }
}