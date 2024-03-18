package br.com.faculdade.controllers.endpoints;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.faculdade.controllers.interfaces.Endpoint;
import br.com.faculdade.infra.FabricaConexao;
import br.com.faculdade.services.TarefaService;

public class Dashboard implements Endpoint{
	
	// Responsável por redenrizar à página principal depois que o usuário fazer o login
	
	private TarefaService service;
	
	public Dashboard() {
		
		FabricaConexao fabrica = new FabricaConexao();
		service = new TarefaService(fabrica);
	}
	
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// buscas as tarefas com base no ID do usuário com sessão ativa
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		ArrayList<br.com.faculdade.models.Tarefa> tarefas = service.buscarTarefas(userId);

		request.setAttribute("listaTarefas", tarefas);
		
		return "forward:WEB-INF/views/dashboard.jsp";
				
	}
}
