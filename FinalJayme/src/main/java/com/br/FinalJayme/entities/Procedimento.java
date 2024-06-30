package com.br.FinalJayme.entities;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Procedimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // N faturamentos podem ter N procedimentos
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "procedimento_faturamento", joinColumns = @JoinColumn(name = "procedimento_id"), inverseJoinColumns = @JoinColumn(name = "faturamento_id"))
    List<Faturamento> faturamentos;
    
    private String nome;
    private String descricao;
    private Double valor;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<Faturamento> getFaturamentos() {
        return faturamentos;
    }
    public void setFaturamentos(List<Faturamento> faturamentos) {
        this.faturamentos = faturamentos;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }

}
