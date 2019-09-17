package br.com.exams.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.exams.model.Paciente;

public class PacienteDAO implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em; //Injetando o entity pois todos os métodos precisaram dele
	private DAO<Paciente> dao;
	
	@PostConstruct //Falando p CDI iniciar esse método logo que fizer o inject no em
	private void init() {
		this.dao= new DAO<Paciente>(em, Paciente.class);
	}
	
	public void adiciona(Paciente paciente) {
		this.dao.adiciona(paciente);
	}

	public List<Paciente> listaTodos() {
		return this.dao.listaTodos();
	}

	public void atualiza(Paciente paciente) {
		this.dao.atualiza(paciente);
	}

	public void remove(Paciente paciente) {
		this.dao.remove(paciente);
	}

	public Paciente buscaPorId(Integer id) {
		return this.dao.buscaPorId(id);
	}

}
