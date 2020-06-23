package com.example.demo.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Pagamento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

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
