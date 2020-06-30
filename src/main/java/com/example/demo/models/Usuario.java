package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.enums.TipoUser;


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
	@Enumerated(value = EnumType.STRING)
	private TipoUser tipo;
	@Column(name = "cpf")
	private String cpf;
	@Column(name = "senha")
	private String senha;
	@Column(name = "creditoPrePago")
	private Double creditoPrePago;
	
	public Usuario() {
	}

	public Usuario(Integer id, String telefone, String email, String nome, TipoUser tipo, String cpf, String senha,
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

	public TipoUser getTipo() {
		return tipo;
	}

	public void setTipo(TipoUser tipo) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((creditoPrePago == null) ? 0 : creditoPrePago.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (creditoPrePago == null) {
			if (other.creditoPrePago != null)
				return false;
		} else if (!creditoPrePago.equals(other.creditoPrePago))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", telefone=" + telefone + ", email=" + email + ", nome=" + nome + ", tipo=" + tipo
				+ ", cpf=" + cpf + ", senha=" + senha + ", creditoPrePago=" + creditoPrePago + "]";
	}
	

}
