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
@Table(name = "stomach")
public class Stomach {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String nome;
	    
	    @ManyToOne
	    @JoinColumn(name = "hip_id")
	    private Hip hip;
	    
	    public Stomach() {}
	    
	    public Stomach(String nome) {
	        this.nome = nome;
	    }

	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }
	    public String getNome() { return nome; }
	    public void setNome(String nome) { this.nome = nome; }
	    //	Junção de tabelas * Muitos Para 1 *
		public Hip getHip() {return hip;}
		public void setHip(Hip hip) {this.hip = hip;}	    
}
