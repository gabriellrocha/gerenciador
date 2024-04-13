package br.com.faculdade.models.dto;

import java.sql.Date;

import br.com.faculdade.models.enums.Status;

public class TarefaDTO {
	
	private Integer id;
	private String descricao;
	private Date data;
	private Status status;
	
	public TarefaDTO(Integer id, String descricao, Date data, Status status) {
		this.id = id;
		this.descricao = descricao;
		this.data = data;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public Date getData() {
		return data;
	}

	public Status getStatus() {
		return status;
	}
	
	
}
