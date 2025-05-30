package com.fiap.gs.api_cereus.service;

import com.fiap.gs.api_cereus.model.Alerta;
import com.fiap.gs.api_cereus.model.SensorAgua;
import com.fiap.gs.api_cereus.repository.AlertaRepository;
import com.fiap.gs.api_cereus.repository.SensorAguaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MonitoramentoService {
    private final SensorAguaRepository sensorAguaRepository;
    private final AlertaRepository alertaRepository;

    private final double limiteEnchente = 5.0; // 5 metros

    public MonitoramentoService(SensorAguaRepository sensorAguaRepository, AlertaRepository alertaRepository) {
        this.sensorAguaRepository = sensorAguaRepository;
        this.alertaRepository = alertaRepository;
    }

    public SensorAgua registrarSensorAgua(Double nivelAgua, Double temperatura, Double umidade) {
        SensorAgua sensores_agua = new SensorAgua();
        sensores_agua.setNivelAgua(nivelAgua);
        sensores_agua.setTemperatura(temperatura);
        sensores_agua.setUmidade(umidade);
        sensores_agua.setDataHora(LocalDateTime.now());

        SensorAgua salva = sensorAguaRepository.save(sensores_agua);

        // Verifica risco de enchente
        if (nivelAgua >= limiteEnchente) {
            gerarAlerta(salva);
        }

        return salva;
    }

    private void gerarAlerta(SensorAgua sensores_agua) {
        Alerta alerta = new Alerta();
        alerta.setMensagem("Alerta de enchente! Nível da água: " + sensores_agua.getNivelAgua() + " metros");
        alerta.setDataHora(LocalDateTime.now());
        alerta.setSensorAgua(sensores_agua);

        alertaRepository.save(alerta);
    }

    public List<SensorAgua> listarSensorAgua() {
        return sensorAguaRepository.findAll();
    }

    public List<Alerta> listarAlertas() {
        return alertaRepository.findAll();
    }
}
