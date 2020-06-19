package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produtos {
	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	@Column(name = "idCategoria")
	@JoinColumn(name = "idCategoria", referencedColumnName = "id")
	private Categorias categoria;
	@Column(name = "nome")
	private String nome;
	@Column(name = "preco")
	private Double preco;
	@Column(name = "descricao")
	private String descricao;

	public Produtos() {
	}

	public Produtos(long id, Categorias categoria, String nome, Double preco, String descricao) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}

}
