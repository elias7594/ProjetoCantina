package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "idCategoria", referencedColumnName = "id")
	private Categoria categoria;
	@ManyToOne
	@JoinColumn(name = "idUnidadeMedida", referencedColumnName = "id")
	private UnidadeMedida unidadeMedida;
	@Column(name = "nome")
	private String nome;
	@Column(name = "preco")
	private Double preco;
	@Column(name = "descricao")
	private String descricao;

	public Produto() {}

	public Produto(Integer id, Categoria categoria, UnidadeMedida unidadeMedida, String nome, Double preco,
			String descricao) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.unidadeMedida = unidadeMedida;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
	}



	public Integer getId() {
		
		return id;
	}

	public void setId(Integer id) {
		if (id != null) {
			this.id = id;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null) {
			this.nome = nome;
		}
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		if (preco != null) {
			this.preco = preco;
		}
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		if (descricao != null) {
			this.descricao = descricao;
		}
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		if (categoria != null) {
			this.categoria = categoria;
		}
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		if (unidadeMedida != null) {
			this.unidadeMedida = unidadeMedida;
		}
	}

}
