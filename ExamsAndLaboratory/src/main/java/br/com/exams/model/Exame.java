package br.com.exams.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Exame implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message= "Nome do médico é obrigatório!")
	private String nomeMedico;
	
	@NotBlank(message= "Unidade do laboratório é obrigatória!")
	private String unidadeLaboratorio;
	
	@NotBlank(message= "Tipo sanguíneo é obrigatório!")
	private String tipoSangue;
	
	@NotNull(message= "Não se esqueça da pressão!")
	@DecimalMin(value="5", message="Sua pressão não pode estar abaixo de 5!")
	@DecimalMax(value= "20", message="Sua pressão não pode estar acima de 20!")
	private Double pressao;
	
	@NotNull(message= "Não se esqueça do colesterol!")
	@DecimalMin(value="20", message="Seu colesterol não pode estar abaixo de 20!")
	@DecimalMax(value= "300", message="Seu colesterol não pode estar acima de 300!")
	private Integer colesterol;
	
	@NotNull(message= "Não se esqueça da glicose!")
	@DecimalMin(value="20", message="Sua glicose não pode estar abaixo de 20!")
	@DecimalMax(value= "200", message="Sua glicose não pode estar acima de 200!")
	private Integer glicose;
	
	@JoinColumn(unique=true) //Retringindo a duplicidade do mesma exame ser de 2 pessoas
	@OneToOne
	@NotNull(message= "Paciente é obrigatório!")
	private Paciente paciente;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

	public String getUnidadeLaboratorio() {
		return unidadeLaboratorio;
	}

	public void setUnidadeLaboratorio(String unidadeLaboratorio) {
		this.unidadeLaboratorio = unidadeLaboratorio;
	}

	public String getTipoSangue() {
		return tipoSangue;
	}

	public void setTipoSangue(String tipoSangue) {
		this.tipoSangue = tipoSangue;
	}

	public Double getPressao() {
		return pressao;
	}

	public void setPressao(Double pressao) {
		this.pressao = pressao;
	}

	public Integer getColesterol() {
		return colesterol;
	}

	public void setColesterol(Integer colesterol) {
		this.colesterol = colesterol;
	}

	public Integer getGlicose() {
		return glicose;
	}

	public void setGlicose(Integer glicose) {
		this.glicose = glicose;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "Exame [id=" + id + ", nomeMedico=" + nomeMedico + ", unidadeLaboratorio=" + unidadeLaboratorio
				+ ", tipoSangue=" + tipoSangue + ", pressao=" + pressao + ", colesterol=" + colesterol + ", glicose="
				+ glicose + ", paciente=" + paciente + "]";
	}

}
