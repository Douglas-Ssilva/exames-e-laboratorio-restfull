package br.com.exams.rest;

import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import br.com.exams.model.Paciente;

public class TesteAPI {

	public static void main(String[] args) {
			List<Paciente> list = listarPacientes();
			for (Paciente p: list) {
				System.out.println(p);
			}
	}
	
	public static List<Paciente> listarPacientes() {
		Client client= Client.create();
		WebResource webResource= client.resource("http://localhost:8080/WSPromove/ws/paciente/buscaPacienteJ/");
		return webResource.get(new GenericType<List<Paciente>>(){});
	}

} 
