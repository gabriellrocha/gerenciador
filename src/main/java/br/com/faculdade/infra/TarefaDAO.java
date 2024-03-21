package br.com.faculdade.infra;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.faculdade.models.Tarefa;

public class TarefaDAO {
	
	private Connection connection;
	
	public TarefaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void create(Tarefa tarefa){
		
		String sql = "INSERT INTO tarefas (descricao, data, usuario_id, status) VALUES (?, ?, ?, ?)";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, tarefa.getDescricao());
			statement.setDate(2, tarefa.getData());
			statement.setInt(3, tarefa.getIdUsuario());
			statement.setString(4, tarefa.getStatus().toString());
			
			statement.execute();
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public ArrayList<Tarefa> selectAll(Integer idUsuario) {
		
		ResultSet result;
		ArrayList<Tarefa> tarefas = new ArrayList<>();
		
		String sql =
				"SELECT tarefas.id, tarefas.descricao, tarefas.data, tarefas.status " +
				"FROM tarefas " +
				"INNER JOIN usuarios ON tarefas.usuario_id = usuarios.id " +
				"WHERE usuarios.id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, idUsuario);
			result = statement.executeQuery();
			
			while(result.next()) {
				
				Integer idTarefa = result.getInt(1);
				String descricao = result.getString(2);
				Date momento = result.getDate(3);
				
				tarefas.add(new Tarefa(idTarefa, descricao, momento));					
			}
			
			return tarefas;
			
			
		} catch(SQLException e ) {
			throw new RuntimeException(e);
		}
		
	}
}
