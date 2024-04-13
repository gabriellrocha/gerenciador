package br.com.faculdade.controllers.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebFilter("/home")
public class AutenticacaoFilter extends HttpFilter implements Filter {
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		// Verifica se o endpoint solicitado precisa de uma autentificação(login/senha) para acesso.
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		HttpSession session = request.getSession();
		
		String path = request.getParameter("path");
		
		boolean usuarioNaoEstaLogado = (session.getAttribute("userId") == null);
		boolean endpointProtegido = !(path.equals("signIn") || path.equals("login") || path.equals("cadastrar") || path.equals("signUp") || path.equals("edit"));
		
		// Já tiver uma sessão e tentar acessar o formulário de login encaminha a página principal
		if(path.equals("signInUp") && !usuarioNaoEstaLogado) {
			response.sendRedirect("home?path=dashboard");
			return;
		}		
		
		// Tentando acessar um endpoint protegido, mas não tem uma sessão, retorna ao formulário de login
		if(usuarioNaoEstaLogado && endpointProtegido) {
			response.sendRedirect("home?path=signIn");
			return;
		}
		
		chain.doFilter(request, response);
	}
		
}
