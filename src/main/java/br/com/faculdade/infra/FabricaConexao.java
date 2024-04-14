package br.com.faculdade.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
	
	/**
	 * Classe dedicada à criação de conexões
	 */

	private static final String URL = "jdbc:mysql://localhost:3306/projeto";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	
	public FabricaConexao() {	
	}
	
	public Connection obterConexao() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, USER, PASSWORD);
			
		} catch(SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
