package com.fiap.gs.api_cereus.controller;

import com.fiap.gs.api_cereus.model.Alerta;
import com.fiap.gs.api_cereus.model.SensorAgua;
import com.fiap.gs.api_cereus.service.MonitoramentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/monitoramento")
public class MonitoramentoController {

    private final MonitoramentoService service;

    public MonitoramentoController(MonitoramentoService service) {
        this.service = service;
    }

    @PostMapping("/registrar")
    public SensorAgua registrarSensorAgua(@RequestBody SensorAgua sensores_agua) {
        return service.registrarSensorAgua(sensores_agua.getNivelAgua(), sensores_agua.getTemperatura(), sensores_agua.getUmidade());
    }

    @GetMapping("/sensores-agua")
    public List<SensorAgua> listarSensorAgua() {
        return service.listarSensorAgua();
    }

    @GetMapping("/alertas")
    public List<Alerta> listarAlertas() {
        return service.listarAlertas();
    }
}
