package br.com.faculdade.controllers.interfaces;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Endpoint {
	
	/*A classe que implementa esta interface será um endpoint da aplicação, ou seja, executa a lógica necessária
	 * e retorna uma String com uma palavra-chave pré-fixada (redirect ou forward), que
	 * indica para o controlador qual o tipo de retorno deve ser feito. Caso seja um redirect, deve ser
	 * feito um redirecionamento Client Side, se for um forward o retorno deve ser dado no mesmo fluxo
	 * sem a necessidade de uma nova requisição
	 * 
	 * exemplo -> redirect:url | forward:url 
	 * */
	
	String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ;
}
