package com.example.demo.models;



import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "idUsuario", referencedColumnName = "id")
	private Usuario idUsuario;
	@ManyToOne
	@JoinColumn(name = "idPagamento", referencedColumnName = "id")
	private Pagamento idPagamento;
	private Integer status;
	@DateTimeFormat(pattern = "HH:mm")
	private LocalDate hora;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;
	private Integer lugar;
	
	public Pedido() {}
	
	public Pedido(Integer id, Usuario idUsuario, Pagamento idPagamento, Integer status, LocalDate hora, LocalDate data,
			Integer lugar) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.idPagamento = idPagamento;
		this.status = status;
		this.hora = hora;
		this.data = data;
		this.lugar = lugar;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		if (id != null) {
			this.id = id;
		}
	}
	public Usuario getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Usuario idUsuario) {
		if (idUsuario != null) {
			this.idUsuario = idUsuario;
		}
	}
	public Pagamento getIdPagamento() {
		return idPagamento;
	}
	public void setIdPagamento(Pagamento idPagamento) {
		if (idPagamento != null) {
			this.idPagamento = idPagamento;
		}
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		if (status != null) {
			this.status = status;
		}
	}
	public LocalDate getHora() {
		return hora;
	}
	public void setHora(LocalDate hora) {
		if (idUsuario != null) {
			this.hora = hora;
		}
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		if (data != null) {
			this.data = data;
		}
	}
	public Integer getLugar() {
		return lugar;
	}
	public void setLugar(Integer lugar) {
		if (lugar != null) {
			this.lugar = lugar;
		}
	}
	
	
	
}
