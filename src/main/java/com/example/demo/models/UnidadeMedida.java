package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UnidadeMedida {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String sigla;
	
	public UnidadeMedida() {}
	public UnidadeMedida(Integer id, String sigla) {
		super();
		this.id = id;
		this.sigla = sigla;
	}
	public Integer getId() {
		return id;
	}
	
	public String getSigla() {
		return sigla;
	}
	public void setId(Integer id) {
		if (id != null) {
			this.id = id;
		}
	}
	public void setSigla(String sigla) {
		if (sigla != null) {
			this.sigla = sigla;
		}
	}
	
}
