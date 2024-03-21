package br.com.faculdade.models.dto;

public class UsuarioDTO {
	
	private Integer id;
	private String name;
	
	public UsuarioDTO(Integer id, String name) {
		this.id = id;
		firstLetterUpper(name);
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	private void firstLetterUpper(String name) {
		this.name = name.substring(0, 1).toUpperCase() + name.substring(1);
	}
}
