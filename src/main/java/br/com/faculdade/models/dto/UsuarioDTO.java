package br.com.faculdade.models.dto;

public class UsuarioDTO {
	
	private Integer id;
	private String name;
	
	public UsuarioDTO(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
}
