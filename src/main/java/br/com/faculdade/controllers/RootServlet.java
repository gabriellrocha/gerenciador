package br.com.faculdade.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.faculdade.controllers.interfaces.Endpoint;


@SuppressWarnings("serial")
public class RootServlet extends HttpServlet {
	
	@SuppressWarnings({ "rawtypes", "deprecation" })
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String endereco = "";
		
		String path = request.getParameter("path");
		System.out.println(path);
		path = path.substring(0, 1).toUpperCase() + path.substring(1);
		
		try {
			Class classCarregada = Class.forName("br.com.faculdade.controllers.endpoints."+ path);
			
			Endpoint endpoint = (Endpoint) classCarregada.newInstance();
			endereco = endpoint.executar(request, response);
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
			
		String[] retorno = endereco.split(":");
		
		// posicao 0 do array determina a acao, posicao 1 determina a url
		
		if(retorno[0].equals("redirect")) {
			response.sendRedirect(retorno[1]);
			
		} else { // forward
			RequestDispatcher dispatcher = request.getRequestDispatcher(retorno[1]);
			dispatcher.forward(request, response);
		}
				
	}	
}
