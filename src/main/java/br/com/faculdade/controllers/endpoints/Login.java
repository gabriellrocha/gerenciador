package br.com.faculdade.controllers.endpoints;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.faculdade.controllers.interfaces.Endpoint;
import br.com.faculdade.infra.FabricaConexao;
import br.com.faculdade.models.AuthenticationResult;
import br.com.faculdade.services.UsuarioService;

public class Login implements Endpoint {
	
	private UsuarioService service;
	
	public Login() {
		
		FabricaConexao fabrica = new FabricaConexao();
		service = new UsuarioService(fabrica);
	}
	
	public String executar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
			// verificar se o usuario existe e se as credenciais estão corretas
			String username = request.getParameter("username");
			String password = request.getParameter("password");
				
			AuthenticationResult authetication = service.verificarCredenciais(username, password);
			int resultadoVerificacao = authetication.getStatus();
			
			String endereco = "";
			switch (resultadoVerificacao) {
				
				case 1:
					// criar a session do usuario
					// redirecionar a pagina principal
					// Redirecionamento Client Side
					
					HttpSession session = request.getSession();
					session.setAttribute("userId", authetication.getUsuarioDTO().getId());
					session.setAttribute("nome", authetication.getUsuarioDTO().getName());
					session.setMaxInactiveInterval(1800);
					
					endereco = "redirect:home?path=dashboard";
					break;
								
				case 2: // senha incorreta
					// redirecionar a pagina de login e avisar
					request.setAttribute("errorMensagem", authetication.getErrorMensagem());
					endereco = "forward:home?path=signIn";
					break;
					
				case 3: // usuario nao existe
					request.setAttribute("errorMensagem", authetication.getErrorMensagem());
					endereco = "forward:home?path=signIn";
					break;
			}
			
			return endereco;		
		}
}

