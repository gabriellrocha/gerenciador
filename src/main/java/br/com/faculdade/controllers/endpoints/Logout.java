package br.com.faculdade.controllers.endpoints;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.faculdade.controllers.interfaces.Endpoint;

public class Logout implements Endpoint {
	
	/**
	 * Responsável por invalidar uma session
	 */

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false); // Obtém a session existente, não cria uma nova se não existir
		if(session != null) {
			session.invalidate();
		}
		
		return "redirect:home?path=signIn";
	}
	
	
}
