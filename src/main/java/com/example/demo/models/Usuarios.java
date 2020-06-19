package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuarios {
	@Id
	@GeneratedValue
	private long id;
	@Column(name = "telefone")
	private String telefone;
	@Column(name = "email")
	private String email;
	@Column(name = "nome")
	private String nome;
	@Column(name = "tipo")
	private Byte tipo;
	@Column(name = "cpf")
	private String cpf;
	@Column(name = "senha")
	private String senha;
	@Column(name = "creditoPrePago")
	private Double creditoPrePago;

	public Usuarios() {
	}

	public Usuarios(long id, String telefone, String email, String nome, Byte tipo, String cpf, String senha,
			Double creditoPrePago) {
		super();
		this.id = id;
		this.telefone = telefone;
		this.email = email;
		this.nome = nome;
		this.tipo = tipo;
		this.cpf = cpf;
		this.senha = senha;
		this.creditoPrePago = creditoPrePago;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telephone) {
		this.telefone = telephone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Byte getTipo() {
		return tipo;
	}

	public void setTipo(Byte tipo) {
		this.tipo = tipo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Double getCreditoPrePago() {
		return creditoPrePago;
	}

	public void setCreditoPrePago(Double creditoPrePago) {
		this.creditoPrePago = creditoPrePago;
	}

}
