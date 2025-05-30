package com.fiap.gs.api_cereus.service;

import com.fiap.gs.api_cereus.model.Barreira;
import com.fiap.gs.api_cereus.repository.BarreiraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarreiraService {
    private final BarreiraRepository repository;

    public BarreiraService(BarreiraRepository repository) {
        this.repository = repository;
    }

    public Barreira salvarBarreira(Barreira barreira) {
        return repository.save(barreira);
    }

    public List<Barreira> listarBarreiras() {
        return repository.findAll();
    }

    public Optional <Barreira> buscarBarreiraPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
