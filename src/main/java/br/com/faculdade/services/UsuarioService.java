package br.com.faculdade.services;

import br.com.faculdade.exceptions.ValorDuplicadoException;
import br.com.faculdade.infra.FabricaConexao;
import br.com.faculdade.infra.UsuarioDAO;
import br.com.faculdade.models.AuthenticationResult;
import br.com.faculdade.models.DadosNovoUsuario;
import br.com.faculdade.models.Usuario;

public class UsuarioService {
	
	// Responsavel por realizar operações relacionadas a entidade usuario
	
	private UsuarioDAO dao;
	
	public UsuarioService(FabricaConexao fabrica) {
		dao = new UsuarioDAO(fabrica.obterConexao());
	}
	
	public Usuario criarUsuario(DadosNovoUsuario dados) throws ValorDuplicadoException {
		
		return dao.criar(dados);
	}
	
	public AuthenticationResult verificarCredenciais(String username, String password) {
		
		// tirar a logica do DAO e inserir aqui 
		return dao.autenticarUsuario(username, password);
		
	}
	
}
