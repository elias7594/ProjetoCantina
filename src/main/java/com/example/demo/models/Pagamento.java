package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Pagamento {
	@Id
	@GeneratedValue
	private long id;
	@Column(name = "valor")
	private Double valor;
	
	
	public Pagamento() {}
	
	public Pagamento(long id, Double valor) {
		super();
		this.id = id;
		this.valor = valor;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
