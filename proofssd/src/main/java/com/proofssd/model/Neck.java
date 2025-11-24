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
@Table(name = "necks")
public class Neck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    public Neck() {}
    
    @ManyToOne
    @JoinColumn(name = "chest_id")
    private Chest chest;
        
    public Neck(String nome) {
        this.nome = nome;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    //	Junção de tabelas * Muitos Para 1 *
    public Chest getChest() {return chest;}
	public void setChest(Chest chest) { this.chest = chest;}

}