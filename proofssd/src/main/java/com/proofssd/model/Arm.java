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
@Table(name = "arms")
public class Arm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    public Arm() {}
    
    @ManyToOne
    @JoinColumn(name = "stomach_id")
    private Stomach stomach;
        
    public Arm(String nome) {
        this.nome = nome;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    //	Junção de tabelas * Muitos Para 1 *
    public Stomach getStomach() {return stomach;}
	public void setStomach(Stomach stomach) { this.stomach = stomach;}

}