package br.com.faculdade.services;

import java.sql.Date;
import java.util.List;

import br.com.faculdade.infra.FabricaConexao;
import br.com.faculdade.infra.TarefaDAO;
import br.com.faculdade.models.Tarefa;
import br.com.faculdade.models.dto.TarefaDTO;
import br.com.faculdade.models.enums.Status;

public class TarefaService {
	
	private TarefaDAO dao;
	
	public TarefaService(FabricaConexao fabrica) {
		dao = new TarefaDAO(fabrica.obterConexao());
	}
	
	public void novaTarefa(Integer idUsuario, String descricao, String data) {
		
		Date date = Date.valueOf(data);
		
		Tarefa tarefa = new Tarefa(idUsuario, descricao, date);
		
		dao.create(tarefa);
	}
	
	public void editar(String idTask, String descricao, String data, String status) {
		
		TarefaDTO dto = new TarefaDTO(Integer.valueOf(idTask), descricao, Date.valueOf(data), Status.getStatus(status));
		dao.update(dto);	
	}
	
	public TarefaDTO read(String id) {
		Integer idTask = Integer.parseInt(id);
		return dao.read(idTask);
	}
	
	public List<TarefaDTO> buscarTarefas (Integer id) {
		return dao.selectAll(id);
	}
	
	public void deletar(String id) {
		
		Integer idTask = Integer.parseInt(id);
		
		dao.delete(idTask);
	}
}
