package br.com.exams.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.exams.dao.AgendamentoDAO;
import br.com.exams.dao.PacienteDAO;
import br.com.exams.model.Agendamento;
import br.com.exams.model.Paciente;
import br.com.exams.rest.TesteAPI;
import br.com.exams.util.MyMessage;
import br.com.exams.util.Transacional;

@Named
@ViewScoped
public class PacientesBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Paciente> list;
	private List<Paciente> listFilter; //Soluciona o problema do filtro quando clicamos no button de agendamento
	private List<String> listExames;
	private List<String> listUnidades;
	private Paciente paciente;
	private Agendamento agendamento;
	
	@Inject
	private AgendamentoDAO dao;
	@Inject
	private PacienteDAO daoPaciente;
	private List<Agendamento> listAgendamentos;
	private List<Agendamento> listAgendamentosFilter;
	
	@Transacional
	public void save() {
		System.out.println(agendamento);
		try {
			this.agendamento.setPaciente(paciente);
			this.agendamento.setStatus("Pendente");
			daoPaciente.adiciona(paciente);
			dao.adiciona(agendamento);
			MyMessage.msgSuccessfully("Agendamento realizado com sucesso!");
			this.listAgendamentos= dao.listaTodos();
			clearFields();
		} catch (RuntimeException e) {
			MyMessage.msgError("Não foi possível fazer o agendamento");
		}
	}
	

	public void clearFields() {
		System.out.println("Limpando filtros");
		this.paciente= new Paciente();
		this.agendamento= new Agendamento();
		for(Paciente p : list) {
			System.out.println(p);
		}
	}


	public List<Paciente> getList() {
		if (list == null) {
			this.list = TesteAPI.listarPacientes();
		}
		return list;
	}
	
	private void preencherListExames() {
		this.listExames = new ArrayList<>();
		this.listExames.add("Creatininan Serica");
		this.listExames.add("AC Urico Serico");
		this.listExames.add("Glicose Basal");
		this.listExames.add("Glicohemoglo- HBA1C");
		this.listExames.add("Transaminase Oxalac");
		this.listExames.add("Lipidograma");
		this.listExames.add("Hemograma Automatizada");
	}
	
	private void preencherListUnidades() {
		this.listUnidades = new ArrayList<>();
		this.listUnidades.add("Centro");
		this.listUnidades.add("Barro Preto");
		this.listUnidades.add("Savassi");
		this.listUnidades.add("Belvedere");
		
	}


	public Paciente getPaciente() {
		System.out.println("Get paciente: " + paciente);
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<String> getListExames() {
		if (this.listExames == null) {
			preencherListExames();
		}
		return listExames;
	}

	public List<String> getListUnidades() {
		if (listUnidades == null) {
			preencherListUnidades();
		}
		return listUnidades;
	}


	public Agendamento getAgendamento() {
		if (agendamento == null) {
			this.agendamento= new Agendamento();
		}
		return agendamento;
	}


	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

	public List<Agendamento> getListAgendamentos() {
		if(this.listAgendamentos == null) {
			this.listAgendamentos= this.dao.listaTodos();
		}
		return listAgendamentos;
	}


	public List<Paciente> getListFilter() {
		return listFilter;
	}


	public void setListFilter(List<Paciente> listFilter) {
		this.listFilter = listFilter;
	}


	public List<Agendamento> getListAgendamentosFilter() {
		return listAgendamentosFilter;
	}


	public void setListAgendamentosFilter(List<Agendamento> listAgendamentosFilter) {
		this.listAgendamentosFilter = listAgendamentosFilter;
	}

}
