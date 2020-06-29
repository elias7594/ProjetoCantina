package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PedidoProduto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "idPedido", referencedColumnName = "id")
	private Pedido idPedido;
	@ManyToOne
	@JoinColumn(name = "idProduto", referencedColumnName = "id")
	private Produto idProduto;
	
	public PedidoProduto() {}
	
	
	public PedidoProduto(Integer id, Pedido idPedido, Produto idProduto) {
		super();
		this.id = id;
		this.idPedido = idPedido;
		this.idProduto = idProduto;
	}


	public Integer getId() {
		return id;
	}
	public Pedido getIdPedido() {
		return idPedido;
	}
	public Produto getIdProduto() {
		return idProduto;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setIdPedido(Pedido idPedido) {
		if (idPedido != null) {
			this.idPedido = idPedido;
		}
		
	}
	public void setIdProduto(Produto idProduto) {
		if (idProduto != null) {
			this.idProduto = idProduto;
		}
	}
	
	
	
}
