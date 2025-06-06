package com.wildfire.interfaces.rest.controllers;

import com.wildfire.application.services.MonitoramentoApplicationService;
import com.wildfire.domain.entities.PontoDeFoco;
import com.wildfire.interfaces.rest.dto.RegistrarFocoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monitoramento")
@CrossOrigin(origins = "*")
public class MonitoramentoController {

    @Autowired
    private MonitoramentoApplicationService monitoramentoService;

    @PostMapping("/focos")
    public ResponseEntity<String> registrarFoco(@RequestBody RegistrarFocoRequest request) {
        try {
            String focoId = monitoramentoService.registrarNovoFoco(
                    request.getLatitude(),
                    request.getLongitude(),
                    request.getIntensidade(),
                    request.getRegiaoId()
            );
            return ResponseEntity.ok(focoId);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/focos/ativos/{regiaoId}")
    public ResponseEntity<List<PontoDeFoco>> listarFocosAtivos(@PathVariable String regiaoId) {
        try {
            List<PontoDeFoco> focos = monitoramentoService.listarFocosAtivos(regiaoId);
            return ResponseEntity.ok(focos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}