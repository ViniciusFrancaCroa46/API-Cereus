package com.fiap.gs.api_cereus.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "SensorAgua")
public class SensorAgua {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double nivelAgua; //em metros
    private Double temperatura;//em Celsius
    private Double umidade;//em porcentagem

    private LocalDateTime dataHora;

    //Construtores
    public SensorAgua() {}

    public SensorAgua(double nivelAgua, double temperatura, double umidade, LocalDateTime dataHora) {
        this.nivelAgua = nivelAgua;
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.dataHora = dataHora;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getNivelAgua() { return nivelAgua; }
    public void setNivelAgua(Double nivelAgua) { this.nivelAgua = nivelAgua; }

    public Double getTemperatura() { return temperatura; }
    public void setTemperatura(Double temperatura) { this.temperatura = temperatura; }

    public Double getUmidade() { return umidade; }
    public void setUmidade(Double umidade) { this.umidade = umidade; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
}
