package com.zerocinco.planteUmaArvore.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tema")
public class PlanteUmaArvore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id;
	
	@NotNull
	@Size(min = 5, max = 70)
	private String nome;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String tema;
	
	@NotNull
	private boolean disponibilidade;
	
	
	// @OneToMany(mappedBy = "PlanteUmaArvore", cascade = CascadeType.ALL)        // mapeia o atributo tema
	// @JsonIgnoreProperties("PlanteUmaArvore")									//ignora a duplicidade		
	// private List<Postagem> postagem;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public boolean isDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
		
}
