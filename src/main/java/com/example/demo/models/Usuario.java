package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
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

	public Usuario() {
	}

	public Usuario(Integer id, String telefone, String email, String nome, Byte tipo, String cpf, String senha,
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email != null) {
			this.email = email;
		}
	}

	public String getTelefone() {
		
		return telefone;
	}

	public void setTelefone(String telefone) {
		if (telefone != null) {
			this.telefone = telefone;
		}
		
	}

	public String getCpf() {
		
		return cpf;
	}

	public void setCpf(String cpf) {
		if (cpf != null) {
			this.cpf = cpf;
		}
		
	}

	public Byte getTipo() {
		return tipo;
	}

	public void setTipo(Byte tipo) {
		if (tipo != null) {
			this.tipo = tipo;
		}
		
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if (senha != null) {
			this.senha = senha;
		}
		
	}

	public Double getCreditoPrePago() {
		return creditoPrePago;
	}

	public void setCreditoPrePago(Double creditoPrePago) {
		if (creditoPrePago != null) {
			this.creditoPrePago = creditoPrePago;
		}
		
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", telefone=" + telefone + ", email=" + email + ", nome=" + nome + ", tipo=" + tipo
				+ ", cpf=" + cpf + ", senha=" + senha + ", creditoPrePago=" + creditoPrePago + "]";
	}
	

}
