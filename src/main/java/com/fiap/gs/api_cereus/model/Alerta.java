package com.fiap.gs.api_cereus.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Alerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "sensor_agua_id", nullable = false)
    private SensorAgua sensorAgua;

    // Getters e Setters
    public Long getId() {return id;}

    public String getMensagem() {return mensagem;}
    public void setMensagem(String mensagem) {this.mensagem = mensagem;}

    public LocalDateTime getDataHora() {return dataHora;}
    public void setDataHora(LocalDateTime dataHora) {this.dataHora = dataHora;}

    public SensorAgua getSensorAgua() {return sensorAgua;}

    public void setSensorAgua(SensorAgua sensorAgua) {this.sensorAgua = sensorAgua;}
}
