package com.wildfire.domain.services;

import com.wildfire.domain.entities.Alerta;
import com.wildfire.domain.entities.PontoDeFoco;
import com.wildfire.domain.enums.TipoAlerta;
import com.wildfire.domain.enums.NivelUrgencia;
import org.springframework.stereotype.Service;

@Service
public class AlertaService {

    public Alerta criarAlertaNovoFoco(PontoDeFoco foco) {
        String titulo = "Novo foco detectado";
        String mensagem = String.format(
                "Novo foco de calor detectado na região %s com intensidade %.2f°C",
                foco.getRegiao().getNome(), foco.getIntensidadeCalor()
        );

        NivelUrgencia urgencia = determinarUrgencia(foco.getIntensidadeCalor());

        return new Alerta(titulo, mensagem, TipoAlerta.NOVO_FOCO, urgencia, foco);
    }

    private NivelUrgencia determinarUrgencia(Double intensidade) {
        if (intensidade >= 80) return NivelUrgencia.CRITICA;
        if (intensidade >= 60) return NivelUrgencia.ALTA;
        if (intensidade >= 40) return NivelUrgencia.MEDIA;
        return NivelUrgencia.BAIXA;
    }
}