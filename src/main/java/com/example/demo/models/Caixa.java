package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "caixa")
public class Caixa {
	@Id 
	@GeneratedValue
	
	private int id;
	@Column(name = "valorAbertura")
	private double valorAbertura;
	@Column(name = "valorFechamento")
	private double valorFechamento;
	@Column(name = "data")
	private String data;
	@Column(name = "status")
	private int status;
	public Caixa(int id, double valorAbertura, double valorFechamento, String data, int status) {
		super();
		this.id = id;
		this.valorAbertura = valorAbertura;
		this.valorFechamento = valorFechamento;
		this.data = data;
		this.status = status;
	}


	public Caixa() {
		
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValorAbertura() {
		return valorAbertura;
	}

	public void setValorAbertura(double valorAbertura) {
		this.valorAbertura = valorAbertura;
	}

	public double getValorFechamento() {
		return valorFechamento;
	}

	public void setValorFechamento(double valorFechamento) {
		this.valorFechamento = valorFechamento;
	}

	public String getData() {
		return data;
	}

	public void setData(String data2) {
		this.data = data2;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
