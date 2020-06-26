package com.example.demo.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Pagamento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Double valor;
	public Pagamento() {}
	
	public Pagamento(Integer id, Double valor) {
		super();
		this.id = id;
		this.valor = valor;
	}
	public Integer getId() {
		return id;
	}
	public Double getValor() {
		return valor;
	}
	public void setId(Integer id) {
		if (id != null) {
			this.id = id;
		}
		
	}
	public void setValor(Double valor) {
		if (valor != null) {
			this.valor = valor;
		}
		
	}
	
}
