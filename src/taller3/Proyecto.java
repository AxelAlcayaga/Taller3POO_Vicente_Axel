package taller3;

import java.util.ArrayList;

public class Proyecto {
	private String id;
	private String nombre;
	private String responsable;
	private ArrayList<Tarea> tareas;
	
	public Proyecto(String id, String nombre, String responsable) {
		this.id = id;
		this.nombre = nombre;
		this.responsable = responsable;
		this.tareas= new ArrayList<>();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public ArrayList<Tarea> getTareas() {
		return tareas;
	}
	public void setTareas(ArrayList<Tarea> tareas) {
		this.tareas = tareas;
	}
	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", nombre=" + nombre + ", responsable=" + responsable + "]";
	}
	
	public void imprimirtareas() {
		for(Tarea t:tareas) {
			System.out.println(t);
		}
	}

	
	
	
}
