package br.com.faculdade.controllers.endpoints;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.faculdade.controllers.interfaces.Endpoint;
import br.com.faculdade.exceptions.ValorDuplicadoException;
import br.com.faculdade.infra.FabricaConexao;
import br.com.faculdade.models.DadosNovoUsuario;
import br.com.faculdade.models.Usuario;
import br.com.faculdade.services.UsuarioService;

public class Cadastrar implements Endpoint{
	
	private UsuarioService service;
	
	public Cadastrar() {
		FabricaConexao fabrica = new FabricaConexao();
		service = new UsuarioService(fabrica);
	}
	
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("name");
		String sobrenome = request.getParameter("surname");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String senha = request.getParameter("password");
		
		DadosNovoUsuario dados = new DadosNovoUsuario(nome, sobrenome, username, email, senha);
			
		String endereco = "";
		Usuario usuario;
		
		try {
			usuario = service.criarUsuario(dados);
			if(usuario != null) {			
				endereco = "forward:WEB-INF/views/cadastro-efetuado.html";
			}
			
		} catch(ValorDuplicadoException e) {
			
			request.setAttribute("dados", dados);
			request.setAttribute("campoDuplicado", e.getCampo());
			endereco = "forward:WEB-INF/views/form-cadastro.jsp";
		}
		
		// se null o usuario nao pode ser criado, algum campo inválido
		// se true ocorreu tudo certo, redirecionar a pagina de login
		// se false algo nao ocorreu bem, redirecionar a pagina de cadastro
		
		// ops!ocorreu um erro no cadastro. Tente novamente.
		
		return endereco;	
	}
}
