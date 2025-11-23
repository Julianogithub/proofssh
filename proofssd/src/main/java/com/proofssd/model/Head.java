package com.proofssd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "heads")
public class Head {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private Double preco;

    @ManyToOne
    @JoinColumn(name = "neck_id")
    private Neck neck;

    public Head() {}

    public Head(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }
    //	Junção de tabelas * 1 Para 1 *
    public Neck getNeck() { return neck; }
    public void setNeck(Neck neck) { this.neck = neck; }
}