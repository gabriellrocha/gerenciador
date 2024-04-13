package br.com.faculdade.models.enums;

public enum Status {
	
	PENDENTE,
	CONCLUIDO;
	
	public static Status getStatus(String status) {
		
		for(Status s : Status.values()) {
			if(s.toString().equals(status.toUpperCase())) {
				return s;
			}
		}
		
		return null;
	}
}
