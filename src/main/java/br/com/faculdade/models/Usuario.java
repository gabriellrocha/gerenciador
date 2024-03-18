package br.com.faculdade.models;

import java.util.ArrayList;



public class Usuario {

	private Integer id;
	private String nome;
	private String sobrenome;
	private String username;
	private String email;
	private String senha;
	private ArrayList<Tarefa> tarefas = new ArrayList<>();
	
	public Usuario() {
		
	}
	
	// talvez, passar senha e email como um objeto credenciais, que encapsula essas informacoes
	public Usuario(String nome, String sobrenome, String username, String email, String senha) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.username = username;
		this.email = email;
		this.senha = senha;
	
	}
	
	public Usuario(DadosNovoUsuario dados) {
		this.nome = dados.getNome();
		this.sobrenome = dados.getSobrenome();
		this.email = dados.getEmail();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public ArrayList<Tarefa> tarefas(){
		return this.tarefas;
	}
	
	public void setTarefa(Tarefa tarefa) {
		tarefas.add(tarefa);
	}

}
