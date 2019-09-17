package br.com.exams.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Agendamento {
	
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message= "Unidade não pode ficar vazia!")
	private String unidade;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataExame;
	
	@ManyToOne
	private Paciente paciente;
	private String status;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public Date getDataExame() {
		return dataExame;
	}
	public void setDataExame(Date dataExame) {
		this.dataExame = dataExame;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Agendamento [id=" + id + ", unidade=" + unidade + ", dataExame=" + dataExame + ", paciente=" + paciente
				+ ", status=" + status + "]";
	}
}
