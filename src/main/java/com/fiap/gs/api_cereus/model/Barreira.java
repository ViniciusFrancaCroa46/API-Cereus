package com.fiap.gs.api_cereus.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Barreiras")
public class Barreira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean funcionamento;  // Está funcionando corretamente?
    private boolean ativacao;       // Está ativada?

    //Construtores
    public Barreira() {}

    public Barreira(boolean funcionamento, boolean ativacao) {
        this.funcionamento = funcionamento;
        this.ativacao = ativacao;
    }

    // Getters e Setters
    public Long getId() {return id;}

    public boolean isFuncionamento() {return funcionamento;}
    public void setFuncionamento(boolean funcionamento) {this.funcionamento = funcionamento;}

    public boolean isAtivacao() {return ativacao;}
    public void setAtivacao(boolean ativacao) {this.ativacao = ativacao;}
}
