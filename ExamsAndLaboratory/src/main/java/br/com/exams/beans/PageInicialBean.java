package br.com.exams.beans;

import javax.enterprise.inject.Model;

import br.com.exams.util.MyMessage;

@Model
public class PageInicialBean {
	
	private String estado;
	
	public String goToPacientes() {
		if(!estado.equals("null")) {
			return "pacientes?faces-redirect=true";
		}
		MyMessage.msgError("Escolha um dos Estados!");
		return ""; 
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		System.out.println("Setando estado: " + estado);
		this.estado = estado;
	}

}
