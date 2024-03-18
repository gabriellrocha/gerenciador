package br.com.faculdade.controllers.endpoints;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.faculdade.controllers.interfaces.Endpoint;

public class SignUp implements Endpoint {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "forward:WEB-INF/views/form-cadastro.jsp";
	}

}
