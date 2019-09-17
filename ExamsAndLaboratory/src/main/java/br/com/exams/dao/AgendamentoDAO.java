package br.com.exams.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.exams.model.Agendamento;

public class AgendamentoDAO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em; //Injetando o entity pois todos os métodos precisaram dele
	private DAO<Agendamento> dao;
	
	@PostConstruct //Falando p CDI iniciar esse método logo que fizer o inject no em
	private void init() {
		this.dao= new DAO<Agendamento>(em, Agendamento.class);
	}
	
	public void adiciona(Agendamento agendamento) {
		this.dao.adiciona(agendamento);
	}

	public List<Agendamento> listaTodos() {
		return this.dao.listaTodos();
	}

	public void atualiza(Agendamento agendamento) {
		this.dao.atualiza(agendamento);
	}

	public void remove(Agendamento agendamento) {
		this.dao.remove(agendamento);
	}

	public Agendamento buscaPorId(Integer id) {
		return this.dao.buscaPorId(id);
	}

}
