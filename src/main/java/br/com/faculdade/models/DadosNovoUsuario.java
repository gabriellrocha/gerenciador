package br.com.faculdade.models;

public class DadosNovoUsuario {
	
	private String nome;
	private String sobrenome;
	private String username;
	private String email;
	private String senha;
		
	public DadosNovoUsuario(String nome, String sobrenome, String username, String email, String senha) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.username = username;
		this.email = email;
		this.senha = senha;
		
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}
	
}
