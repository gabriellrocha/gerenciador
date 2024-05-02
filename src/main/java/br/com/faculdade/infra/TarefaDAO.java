package br.com.faculdade.infra;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.faculdade.models.Tarefa;
import br.com.faculdade.models.dto.TarefaDTO;
import br.com.faculdade.models.enums.Status;

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
	
	public TarefaDTO read (Integer taskId) {
		String sql = "SELECT * FROM tarefas WHERE id = ?";
		TarefaDTO dto;
		
		try {
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, taskId);
			ResultSet result = statement.executeQuery();
			result.next();
			
			Status status = Status.getStatus(result.getString(5));
			dto = new TarefaDTO(result.getInt(1), result.getString(2), result.getDate(3), status);
			return dto;
			
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}	
	}
	
	public void update(TarefaDTO dto) {
		
		String sql = "UPDATE tarefas SET descricao = ?, data = ?, status = ? WHERE id = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, dto.getDescricao());
			statement.setDate(2, dto.getData());
			statement.setString(3, dto.getStatus().toString());
			statement.setInt(4, dto.getId());
			
			statement.executeUpdate();
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void delete(Integer taskId) {
		
		String sql = "DELETE FROM tarefas WHERE id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, taskId);	
			
			statement.execute();
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<TarefaDTO> selectAll(Integer idUsuario) {
		
		ResultSet result;
		List<TarefaDTO> tarefas = new ArrayList<>();
		
		String sql =
				"SELECT * " +
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
				Status status = Status.getStatus(result.getString(5));
				
				
				TarefaDTO dto = new TarefaDTO(idTarefa, descricao, momento, status);
				
				
				tarefas.add(dto);					
			}
			
			return tarefas;
			
			
		} catch(SQLException e ) {
			throw new RuntimeException(e);
		}
		
	}
}
