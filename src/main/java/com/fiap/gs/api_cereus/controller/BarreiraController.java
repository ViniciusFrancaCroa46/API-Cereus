package com.fiap.gs.api_cereus.controller;

import com.fiap.gs.api_cereus.model.Barreira;
import com.fiap.gs.api_cereus.service.BarreiraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barreiras")
public class BarreiraController {
    private final BarreiraService barreiraService;

    public BarreiraController(BarreiraService barreiraService) {
        this.barreiraService = barreiraService;
    }

    //Salvar uma nova barreira
    @PostMapping
    public ResponseEntity<Barreira> salvarBarreira(@RequestBody Barreira barreira) {
        Barreira salva = barreiraService.salvarBarreira(barreira);
        return ResponseEntity.ok(salva);
    }

    //Listar todas as barreiras
    @GetMapping
    public ResponseEntity<List<Barreira>> listarBarreiras() {
        List<Barreira> barreiras = barreiraService.listarBarreiras();
        return ResponseEntity.ok(barreiras);
    }

    //Buscar uma barreira por ID
    @GetMapping("/{id}")
    public ResponseEntity<Barreira> buscarPorId(@PathVariable Long id) {
        return barreiraService.buscarBarreiraPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Deletar uma barreira por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (barreiraService.buscarBarreiraPorId(id).isPresent()) {
            barreiraService.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
