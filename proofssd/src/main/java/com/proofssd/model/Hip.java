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
@Table(name = "hip")
public class Hip {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String nome;
	    
	    @ManyToOne
	    @JoinColumn(name = "thigh_id")
	    private Thigh thigh;
	    
	    public Hip() {}
	    
	    public Hip(String nome) {
	        this.nome = nome;
	    }

	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }
	    public String getNome() { return nome; }
	    public void setNome(String nome) { this.nome = nome; }
	    //	Junção de tabelas * Muitos Para 1 *
		public Thigh getThigh() {return thigh;}
		public void setThigh(Thigh thigh) {this.thigh = thigh;}	    
}
