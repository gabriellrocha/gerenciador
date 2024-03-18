package br.com.faculdade.controllers.endpoints;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.faculdade.controllers.interfaces.Endpoint;

public class SignIn implements Endpoint {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "forward:WEB-INF/views/index.jsp";
	}

}
