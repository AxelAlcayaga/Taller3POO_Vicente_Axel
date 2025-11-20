package taller3;

public class Factory_tareas {
	public Tarea crear_tarea(String proyecto, String id, String tipo, String descripcion, String estado, String responsable,
			String complejidad, String fecha) {
		
		
		return new Tarea(proyecto,id,tipo,descripcion,estado,responsable,complejidad,fecha);
	}

}
