package taller3;
//Vicente Andres Rojas Lillo - 22.141.463-2 - ICCI
//Axel Ignacio Alcayaga Flores -  20.832.945-6 - ICCI
public class Factory_tareas {
	public Tarea crear_tarea(String proyecto, String id, String tipo, String descripcion, String estado, String responsable,
			String complejidad, String fecha) {
		
		
		return new Tarea(proyecto,id,tipo,descripcion,estado,responsable,complejidad,fecha);
	}

}
