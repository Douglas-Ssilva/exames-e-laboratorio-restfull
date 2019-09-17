package br.com.exams.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MyMessage {
	
	private static FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
	public static void msgError(String msg) {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, ""));
	}
	public static void msgSuccessfully(String msg) {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, ""));
	}

}
