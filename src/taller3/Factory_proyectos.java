package taller3;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Factory_proyectos {
	public Proyecto crear_proyecto(String id, String nombre, String responsable) throws FileNotFoundException {	
		ArrayList<Tarea> repositorio = Repositorio_tareas.getInstancia().getTareas();
		ArrayList<Tarea> tareas = new ArrayList<>();		
		for(Tarea t: repositorio) {
			if(t.getProyecto().equals(id)) {
				tareas.add(t);
			}
		}
		Proyecto p = new Proyecto(id,nombre,responsable);
		p.setTareas(tareas);
		

		return p;
	}


}
