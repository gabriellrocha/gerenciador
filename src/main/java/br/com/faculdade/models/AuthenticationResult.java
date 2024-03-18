package br.com.faculdade.models;

public class AuthenticationResult {
	
	/* encapsula os dados de uma autenticação
	 * 
	 * status 1, 2, ou 3;
	 * userId id do usuario autenticado
	 * errorMensagem, informa algum comportamento inesperado ao tentar fazer uma autenticação
	 * */
	
    private int status;
    private int userId;
    private String errorMensagem;

    public AuthenticationResult(int status, int userId) {
        this.status = status;
        this.userId = userId;      
    }
    
    public AuthenticationResult(int status, int userId, String errorMensagem) {
    	this(status, userId);
    	this.errorMensagem = errorMensagem;	
    }

    public int getStatus() {
        return status;
    }

    public int getUserId() {
        return userId;
    }
    
    public String getErrorMensagem() {
    	return errorMensagem;
    }
    
    public void setErrorMensagem(String mensagem) {
    	this.errorMensagem = mensagem;
    }
}