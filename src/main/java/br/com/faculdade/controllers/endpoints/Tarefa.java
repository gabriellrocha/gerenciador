package br.com.faculdade.controllers.endpoints;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.faculdade.controllers.interfaces.Endpoint;
import br.com.faculdade.infra.FabricaConexao;
import br.com.faculdade.models.dto.TarefaDTO;
import br.com.faculdade.services.TarefaService;

public class Tarefa implements Endpoint {
	
	private TarefaService service;
	
	public Tarefa() {
		FabricaConexao fabrica = new FabricaConexao();
		service = new TarefaService(fabrica);
	}
	
	public String executar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// actionTask -> informa qual operação deve ser executada do CRUD
		String actionTask = request.getParameter("actionTask");
		
		if(actionTask.equals("create")) {
			
			Integer idUsuario = (Integer) request.getSession().getAttribute("userId");
			String descricao = request.getParameter("descricao");
			String data = request.getParameter("data");
			service.novaTarefa(idUsuario, descricao, data);
			
			
		} else if (actionTask.equals("update")){
			
			String idTask = request.getParameter("id");
			String descricao = request.getParameter("descricao");
			String data = request.getParameter("data");
			String status = request.getParameter("status");
			
			service.editar(idTask, descricao, data, status);
			
		} else if (actionTask.equals("read")) {		
			String id = request.getParameter("id");
			
			TarefaDTO dto = service.read(id);
			request.setAttribute("dto", dto);
			
			return "forward:home?path=edit";
					
		}
		
		return "redirect:home?path=dashboard";
		
	}
}
