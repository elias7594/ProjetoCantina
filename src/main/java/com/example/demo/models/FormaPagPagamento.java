package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FormaPagPagamento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "idFormaPagamento", referencedColumnName = "id")
	private FormaPagamento formaPagamento;
	@ManyToOne
	@JoinColumn(name = "idPagamento", referencedColumnName = "id")
	private Pagamento pagamento;
	
	public FormaPagPagamento() {}

	public FormaPagPagamento(Integer id, FormaPagamento formaPagamento, Pagamento pagamento) {
		super();
		this.id = id;
		this.formaPagamento = formaPagamento;
		this.pagamento = pagamento;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
}
