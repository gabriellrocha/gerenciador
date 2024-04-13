package br.com.faculdade.controllers.endpoints;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.faculdade.controllers.interfaces.Endpoint;

public class Edit implements Endpoint {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		
		return "forward:WEB-INF/views/edit.jsp";
	}

}
