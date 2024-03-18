package br.com.faculdade.controllers.endpoints;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.faculdade.controllers.interfaces.Endpoint;

public class Erro implements Endpoint{
	
	public Erro() {
		
	}
	
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// set o status de erro 404 depois
		
		return "forward:WEB-INF/views/erro404.html";
	}
}
