package taller3;

import java.time.LocalDate;

public class Tarea {
	private String proyecto;
	private String id;
	private String tipo;
	private String descripcion;
	private String estado;
	private String responsable;
	private String complejidad;
	private LocalDate fecha;

	public Tarea(String proyecto, String id, String tipo, String descripcion, String estado, String responsable,
			String complejidad, String fecha) {
		this.proyecto = proyecto;
		this.id = id;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.responsable = responsable;
		this.complejidad = complejidad;
		this.fecha = LocalDate.parse(fecha); //lo convierto a tipo localdate debido a que en el punto de priorizar tareas por fecha el codigo iba
		                                     //a ser mas propenso a fallar o se iba a hacer demasiado largo 
	}

	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getComplejidad() {
		return complejidad;
	}

	public void setComplejidad(String complejidad) {
		this.complejidad = complejidad;
	}

	

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Tarea [ id=" + id + ", tipo=" + tipo + ", descripcion=" + descripcion + ", estado=" + estado
				+ ", responsable=" + responsable + ", complejidad=" + complejidad + ", fecha=" + fecha + "]";
	}

}



