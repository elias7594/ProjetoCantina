package com.example.demo.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.enums.StatusCaixa;

@Entity

public class Caixa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "valorAbertura")
	private Double valorAbertura;
	@Column(name = "valorFechamento")
	private Double valorFechamento;
	@Column(name = "data")
	private Date data;
	@Column(name = "status")
	@Enumerated(value = EnumType.STRING)
	private StatusCaixa status;
	
	public Caixa(Integer id, Double valorAbertura, Double valorFechamento, Date data, StatusCaixa status) {
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

	public void setId(Integer id) {
		if (id != null) {
			this.id = id;
		}
	}

	public Double getValorAbertura() {
		return valorAbertura;
	}

	public void setValorAbertura(Double valorAbertura) {
		if (valorAbertura != null) {
			this.valorAbertura = valorAbertura;
		}
	}

	public Double getValorFechamento() {
		return valorFechamento;
	}

	public void setValorFechamento(Double valorFechamento) {
		if (valorFechamento != null) {
			this.valorFechamento = valorFechamento;
		}
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		if (data != null) {
			this.data = data;
		}
	}

	public StatusCaixa getStatus() {
		return status;
	}

	public void setStatus(StatusCaixa status) {
		if (status != null) {
			this.status = status;
		}
	}
	
}
