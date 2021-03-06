package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.example.demo.enums.TipoOper;

@Entity
public class ItemCaixa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "idPedido", referencedColumnName = "id")
	private Pedido idPedido;
	@ManyToOne
	@JoinColumn(name = "idCaixa", referencedColumnName = "id")
	private Caixa idCaixa;
	@Enumerated(value = EnumType.STRING)
	private TipoOper tipoOper;
	private Double valor;
	private String descricao;

	public ItemCaixa() {}
	public ItemCaixa(Integer id, Pedido idPedido, Caixa idCaixa, TipoOper tipoOper, Double valor, String descricao) {
		super();
		this.id = id;
		this.idPedido = idPedido;
		this.idCaixa = idCaixa;
		this.tipoOper = tipoOper;
		this.valor = valor;
		this.descricao = descricao;
	}
	public Integer getId() {
		return id;
	}
	public Pedido getIdPedido() {
		return idPedido;
	}
	public Caixa getIdCaixa() {
		return idCaixa;
	}
	public TipoOper getTipoOper() {
		return tipoOper;
	}
	public Double getValor() {
		return valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setIdPedido(Pedido idPedido) {
		this.idPedido = idPedido;
	}
	public void setIdCaixa(Caixa idCaixa) {
		this.idCaixa = idCaixa;
	}
	public void setTipoOper(TipoOper tipoOper) {
		this.tipoOper = tipoOper;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
