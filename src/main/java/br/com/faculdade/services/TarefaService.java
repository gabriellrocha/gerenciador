package br.com.faculdade.services;

import java.sql.Date;
import java.util.ArrayList;

import br.com.faculdade.infra.FabricaConexao;
import br.com.faculdade.infra.TarefaDAO;
import br.com.faculdade.models.Tarefa;

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
	
	public ArrayList<Tarefa> buscarTarefas (Integer id) {
		return dao.selectAll(id);
	}
}
