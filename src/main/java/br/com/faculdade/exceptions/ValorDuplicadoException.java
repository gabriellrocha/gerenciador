package br.com.faculdade.exceptions;

@SuppressWarnings("serial")
public class ValorDuplicadoException extends Exception {
	
	String campoDuplicado;
	
	public ValorDuplicadoException(String campo) {
		
		this.campoDuplicado = campo;
//		super("Não foi possível inserir o valor " + campo + " devido a violação da restrição UNIQUE");
	}
	
	public String getCampo() {
		return this.campoDuplicado;
	}
}
