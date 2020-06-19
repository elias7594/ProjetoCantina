package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UnidadeMedida {
	@Id
	@GeneratedValue
	private long id;
	private String nome;
	public UnidadeMedida() {
	}
	public UnidadeMedida(long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
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
	
}
