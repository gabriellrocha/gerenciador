package br.com.faculdade.models;

import br.com.faculdade.models.dto.UsuarioDTO;

public class AuthenticationResult {
	
	/* encapsula os dados de uma autenticação
	 * 
	 * status 1, 2, ou 3;
	 * 
	 * errorMensagem, informa algum comportamento inesperado ao tentar fazer uma autenticação
	 * */
	
    private int status;
    private String errorMensagem;
    
    private UsuarioDTO usuarioDTO;

    public AuthenticationResult(int status, UsuarioDTO usuarioDTO) {
        this.status = status;
        this.usuarioDTO = usuarioDTO;      
    }
    
    public AuthenticationResult(int status, String errorMensagem) {
    	this.status = status;
    	this.errorMensagem = errorMensagem;	
    }

    public int getStatus() {
        return status;
    }
    
    public String getErrorMensagem() {
    	return errorMensagem;
    }
    
    public void setErrorMensagem(String mensagem) {
    	this.errorMensagem = mensagem;
    }
    
    public UsuarioDTO getUsuarioDTO() {
    	return this.usuarioDTO;
    }
}