package com.fiap.gs.api_cereus.service;

import com.fiap.gs.api_cereus.model.Barreira;
import com.fiap.gs.api_cereus.repository.BarreiraRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BarreiraService {
    private final BarreiraRepository repository;
    private final BarreiraRepository barreiraRepository;

    public BarreiraService(BarreiraRepository repository, BarreiraRepository barreiraRepository) {
        this.repository = repository;
        this.barreiraRepository = barreiraRepository;
    }

    public Barreira salvarBarreira(boolean ativacao) {
        Barreira barreira = new Barreira();
        barreira.setAtivacao(ativacao);
        barreira.setDataHoraAtivacao(LocalDateTime.now());
        barreiraRepository.save(barreira);
        return barreira;
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
