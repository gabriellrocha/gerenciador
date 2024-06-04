package br.com.faculdade.controllers.endpoints;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.faculdade.controllers.interfaces.Endpoint;
import br.com.faculdade.infra.FabricaConexao;
import br.com.faculdade.services.UsuarioService;

public class DeletarConta implements Endpoint {
	
	private UsuarioService service;
	
	public DeletarConta() {
		
		FabricaConexao fabrica = new FabricaConexao();
		service = new UsuarioService(fabrica);
	}
	
	
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// deletar todos os dados do bd
		// redirecionar a pagina de login
		
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("userId");
		
		service.deletarUsuario(id);
		
		return "redirect:home?path=signIn";
	}

}
