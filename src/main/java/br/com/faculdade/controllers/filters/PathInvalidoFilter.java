package br.com.faculdade.controllers.filters;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/home")
public class PathInvalidoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		// Verifica se o endpoint que está tentando acessar existe na aplicação
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String[] arrayPaths = {"cadastrar", "dashboard", "erro", "login", "signIn", "signUp", "tarefa", "logout", "deletarConta"};
		String path = request.getParameter("path");
		
		Set<String> paths = new HashSet<>(Set.of(arrayPaths));
		
		if(path == null || !paths.contains(path)) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/erro404.html");
			dispatcher.forward(request, response);
			return;
		}
		
		chain.doFilter(request, response);
	}

}
