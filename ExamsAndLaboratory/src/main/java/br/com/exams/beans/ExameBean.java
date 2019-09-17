package br.com.exams.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.exams.dao.AgendamentoDAO;
import br.com.exams.dao.ExameDAO;
import br.com.exams.model.Agendamento;
import br.com.exams.model.Exame;
import br.com.exams.util.MyMessage;
import br.com.exams.util.Transacional;

@Named
@ViewScoped
public class ExameBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer idAgendamento;
	private Agendamento agendamento;
	private List<String> listTiposSangue;
	private List<Exame> listExames;
	private List<Exame> listExamesFiltered;
	
	@Inject
	private Exame exame;
	@Inject
	private ExameDAO exameDAO;
	
	@Inject
	private AgendamentoDAO agendamentoDAO;
	
	@Transacional
	public void save() {
		System.out.println(exame);
		try {
			if(exame.getPaciente() == null) {
				MyMessage.msgError("Impossível realizar exame sem paciente ");
				return; 
			}
			exameDAO.adiciona(exame);
			MyMessage.msgSuccessfully("Exame realizado com sucesso!");
			listExames= exameDAO.listaTodos();
			agendamentoDAO.remove(agendamento);
			clearFields();
		} catch (RuntimeException e) {
			MyMessage.msgError(e.getMessage());
		}
	}
	
	private void clearFields() {
		this.exame= new Exame();
	}

	public void init() {
		if(idAgendamento != null) {
			this.agendamento= this.agendamentoDAO.buscaPorId(idAgendamento);
			this.exame.setUnidadeLaboratorio(agendamento.getUnidade());
			this.exame.setPaciente(agendamento.getPaciente());
		}
	}
	
	public Integer getIdAgendamento() {
		return idAgendamento;
	}
	public void setIdAgendamento(Integer idAgendamento) {
		this.idAgendamento = idAgendamento;
	}


	public Agendamento getAgendamento() {
		return agendamento;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public List<String> getListTiposSangue() {
		if (listTiposSangue == null) {
			fillTypeSangue();
		}
		return listTiposSangue;
	}

	private void fillTypeSangue() {
		listTiposSangue= new ArrayList<>();
		listTiposSangue.add("A+");
		listTiposSangue.add("A-");
		listTiposSangue.add("B+");
		listTiposSangue.add("B-");
		listTiposSangue.add("AB+");
		listTiposSangue.add("AB-");
		listTiposSangue.add("O+");
		listTiposSangue.add("O-");
	}

	public List<Exame> getListExames() {
		if(listExames == null) {
			listExames= exameDAO.listaTodos();
		}
		return listExames;
	}

	public void setListExames(List<Exame> listExames) {
		this.listExames = listExames;
	}

	public List<Exame> getListExamesFiltered() {
		return listExamesFiltered;
	}

	public void setListExamesFiltered(List<Exame> listExamesFiltered) {
		this.listExamesFiltered = listExamesFiltered;
	}
}
