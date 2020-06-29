package com.example.demo.models;



import java.sql.Date;
import java.sql.Time;
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
	private Time hora;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data;
	private Integer lugar;
	public Pedido() {}
	
	public Pedido(Integer id, Usuario idUsuario, Pagamento idPagamento, Integer status, Time hora, Date data,
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
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		if (idUsuario != null) {
			this.hora = hora;
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
	public Integer getLugar() {
		return lugar;
	}
	public void setLugar(Integer lugar) {
		if (lugar != null) {
			this.lugar = lugar;
		}
	}
	
	
	
}
