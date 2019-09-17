package br.com.exams.beans;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.exams.util.MyMessage;

@Named
@ViewScoped
public class UserBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String login;
	private String senha;
	private Integer idAgendamento;
	
	public String logar() {
		if(this.login.equals("admin") && this.senha.equals("admin") ) {
			System.out.println("Enviando o id: " + idAgendamento);
			return "exames?faces-redirect=true&idAgendamento="+this.idAgendamento;
		}
		MyMessage.msgError("User or passwors invalids!");
		return "";
	}
	
	public void putId(Integer id) {
		this.idAgendamento= id;
		System.out.println("Recebi o id: " + idAgendamento);
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
