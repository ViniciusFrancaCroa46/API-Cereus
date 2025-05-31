package com.fiap.gs.api_cereus.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Barreiras")
public class Barreira {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean ativacao;
    private LocalDateTime dataHoraAtivacao;

    //Construtores
    public Barreira() {}

    public Barreira(boolean ativacao, LocalDateTime dataHoraAtivacao) {
        this.ativacao = ativacao;
        this.dataHoraAtivacao = dataHoraAtivacao;
    }

    // Getters e Setters
    public Long getId() {return id;}

    public boolean isAtivacao() {return ativacao;}
    public void setAtivacao(boolean ativacao) {this.ativacao = ativacao;}

    public LocalDateTime getDataHoraAtivacao() { return dataHoraAtivacao; }
    public void setDataHoraAtivacao(LocalDateTime dataHoraAtivacao) { this.dataHoraAtivacao = dataHoraAtivacao; }
}
