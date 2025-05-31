package com.fiap.gs.api_cereus.controller;

import com.fiap.gs.api_cereus.model.Alerta;
import com.fiap.gs.api_cereus.model.SensorAgua;
import com.fiap.gs.api_cereus.service.MonitoramentoService;
import com.fiap.gs.api_cereus.model.Barreira;
import com.fiap.gs.api_cereus.service.BarreiraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitoramento")
public class MonitoramentoController {

    private final MonitoramentoService service;
    private final BarreiraService barreiraService;

    public MonitoramentoController(MonitoramentoService service, BarreiraService barreiraService) {
        this.service = service;
        this.barreiraService = barreiraService;
    }

    //Salvar um novo sensor para medição
    @PostMapping("/registrar/sensores-agua")
    public SensorAgua registrarSensorAgua(@RequestBody SensorAgua sensores_agua) {
        return service.registrarSensorAgua(sensores_agua.getNivelAgua(), sensores_agua.getTemperatura(), sensores_agua.getUmidade());
    }

    //Salvar uma nova barreira
    @PostMapping("/registrar/barreira")
    public Barreira salvarBarreira(@RequestBody Barreira barreira) {
        return barreiraService.salvarBarreira(barreira.isAtivacao());
    }

    //Listar todas as barreiras
    @GetMapping("/barreira")
    public ResponseEntity<List<Barreira>> listarBarreiras() {
        List<Barreira> barreiras = barreiraService.listarBarreiras();
        return ResponseEntity.ok(barreiras);
    }

    //Listar todos os sensores
    @GetMapping("/sensores-agua")
    public List<SensorAgua> listarSensorAgua() {
        return service.listarSensorAgua();
    }

    //Listar todos os alertas
    @GetMapping("/alertas")
    public List<Alerta> listarAlertas() {
        return service.listarAlertas();
    }

    //Buscar um sensor por ID
    @GetMapping("/sensores-agua/{id}")
    public ResponseEntity<SensorAgua> obterSensorAgua(@PathVariable Long id) {
        return service.buscarSensorAguaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Buscar uma barreira por ID
    @GetMapping("/barreira/{id}")
    public ResponseEntity<Barreira> buscarPorId(@PathVariable Long id) {
        return barreiraService.buscarBarreiraPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Deletar um sensor por ID
    @DeleteMapping("/sensores-agua/{id}")
    public ResponseEntity<Void> deletarSensor(@PathVariable Long id) {
        if (service.buscarSensorAguaPorId(id).isPresent()) {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Deletar uma barreira por ID
    @DeleteMapping("/barreira/{id}")
    public ResponseEntity<Void> deletarBarreira(@PathVariable Long id) {
        if (barreiraService.buscarBarreiraPorId(id).isPresent()) {
            barreiraService.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
