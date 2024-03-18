package br.com.faculdade.infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.faculdade.exceptions.ValorDuplicadoException;
import br.com.faculdade.models.AuthenticationResult;
import br.com.faculdade.models.DadosNovoUsuario;
import br.com.faculdade.models.Usuario;

public class UsuarioDAO {
	
	private Connection connection;
	
	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}
	
	public Usuario criar(DadosNovoUsuario dados) throws ValorDuplicadoException {
		
		PreparedStatement statement;
		String sql = "INSERT INTO usuarios(nome, sobrenome, username, email, password) VALUES (?, ?, ?, ?, ?)";
		
		try {
			
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, dados.getNome());
			statement.setString(2, dados.getSobrenome());
			statement.setString(3, dados.getUsername());
			statement.setString(4, dados.getEmail());
			statement.setString(5, dados.getSenha());
			statement.executeUpdate();
			
			ResultSet result = statement.getGeneratedKeys();
			
			if(result.next()) {
				Usuario usuario = new Usuario(dados);
				usuario.setId(result.getInt(1));
				// usuario criado com sucesso e recuperado o id
				return usuario;
			}
							
		} catch(SQLException e) {
			
			if(e.getSQLState().startsWith("23")) {
				String mensagem = e.getMessage();		
				int indice = mensagem.indexOf('_');
				String campo = mensagem.substring(indice + 1, mensagem.length() -1);
				
				throw new ValorDuplicadoException(campo);
							
			} else {
				throw new RuntimeException(e);				
			}	
		}
		
		// usuario nao foi criado
		return null;	
	}
	
	public AuthenticationResult autenticarUsuario(String username, String password) {
		
		PreparedStatement statement;
		ResultSet result;
		String sql = "SELECT * FROM usuarios WHERE username = ?";
		
		try {
			statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, username);
			result = statement.executeQuery();
			
			if(result.next()) { // Usuário existe
				
				String storedPassword = result.getString("password");
				
				if(password.equals(storedPassword)) {
					// Credênciais corretas. Obtém ID do usuário.
					return new AuthenticationResult(1, result.getInt("id"), null);	
				}
				
				// Credênciais incorretas
				String error = "Sua senha está incorreta";
				return new AuthenticationResult(2, -1, error);
			}
						
			// Usuario não existe
			String error = "Não encontramos uma conta associada a este usuário";
			return new AuthenticationResult(3, -1, error);
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}	
	}

} 
