package br.com.faculdade.models;

import java.sql.Date;

import br.com.faculdade.models.enums.Status;

public class Tarefa {
	
	private Integer id;
	private String descricao;
	private Date data;
	private Status status;
	private Integer idUsuario;
	private Usuario propietario;
	
	public Tarefa(Integer idUsuario, String descricao, Date data) {
		this.status = Status.PENDENTE;
		this.idUsuario = idUsuario;
		this.descricao = descricao;
		this.data = data;	
	}
	
	public Tarefa(Integer idUsuario, Integer id, String descricao, Date data) {
		this(idUsuario, descricao, data);
		this.id = id;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Usuario getPropietario() {
		return propietario;
	}

	public void setPropietario(Usuario propietario) {
		this.propietario = propietario;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Integer getIdUsuario() {
		return this.idUsuario;
	}
}
