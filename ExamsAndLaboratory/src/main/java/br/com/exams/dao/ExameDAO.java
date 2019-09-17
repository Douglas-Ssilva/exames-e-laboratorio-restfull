package br.com.exams.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.exams.model.Exame;

public class ExameDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	private DAO<Exame> dao;
	
	@PostConstruct
	public void init() {
		this.dao= new DAO<>(manager, Exame.class);
	}
	
	public void adiciona(Exame exame) {
		this.dao.adiciona(exame);
	}

	public List<Exame> listaTodos() {
		return this.dao.listaTodos();
	}

	public void atualiza(Exame exame) {
		this.dao.atualiza(exame);
	}

	public void remove(Exame exame) {
		this.dao.remove(exame);
	}

	public Exame buscaPorId(Integer id) {
		return this.dao.buscaPorId(id);
	}
}
