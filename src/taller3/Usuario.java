package taller3;

import java.util.ArrayList;

public class Usuario {
	private String username;
	private String password;
	private String rol;
	private ArrayList<Tarea> tareas_usuario; 
	public Usuario(String username, String password, String rol) {
		this.username = username;
		this.password = password;
		this.rol = rol;
		this.tareas_usuario= new ArrayList<>();	
				}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public ArrayList<Tarea> getTareas_usuario() {
		return tareas_usuario;
	}
	public void setTareas_usuario(ArrayList<Tarea> tareas_usuario) {
		this.tareas_usuario = tareas_usuario;
	}
	
}



