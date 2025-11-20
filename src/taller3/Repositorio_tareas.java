package taller3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Repositorio_tareas {
	private static Repositorio_tareas instancia;
	private ArrayList<Tarea> tareas;

	private Repositorio_tareas() throws FileNotFoundException {
		this.tareas = new ArrayList<>();
		Factory_tareas fabrica_tareas = new Factory_tareas();
		File archivo = new File("tareas.txt");
		Scanner s = new Scanner(archivo);

		while (s.hasNextLine()) { //Rellena la lista con las tareas del archivo de texto
			String[] partes = s.nextLine().split("\\|");
			String proyecto = partes[0];
			String id = partes[1];
			String tipo = partes[2];
			String descripcion = partes[3];
			String estado = partes[4];
			String responsable = partes[5];
			String complejidad = partes[6];
			String fecha = partes[7];
			Tarea tarea = fabrica_tareas.crear_tarea(proyecto, id, tipo, descripcion, estado, responsable, complejidad,
					fecha);
			this.tareas.add(tarea);

		}
		s.close();

	}

	public static Repositorio_tareas getInstancia() throws FileNotFoundException {
		if (instancia == null) {
			instancia = new Repositorio_tareas();
		}
		
			return instancia;
		}

	public ArrayList<Tarea> getTareas() {
		return this.tareas;
	}
	public void eliminar_tareas_asociadas(String id_proyecto) throws IOException {
		tareas.removeIf(t-> t.getProyecto().equals(id_proyecto));
		guardarTareas();                                           //recorre la lista y borra las tareas asociadas al id del proyecto, el remove if es
		                                                          //debido a que si hacia el proceso de remover en un for se crasheaba el programa porque el tamano de la lista cambiaba

		}
	public void eliminar_tarea_por_id(String id_tarea) throws IOException {
		tareas.removeIf(t-> t.getId().equals(id_tarea));
		guardarTareas();
	}
	public void mostrar_tareas() {
		for(Tarea t: tareas) {
			System.out.println(t);
		}
	}
	
	
	private void guardarTareas() throws IOException {
	    
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter("tareas.txt"))) { 
	        for (Tarea t : tareas) {
	            // Validar complejidad para que no escriba "null"
	            String comp = (t.getComplejidad() == null) ? "Baja" : t.getComplejidad();

	            String linea = t.getProyecto() + "|" + t.getId() + "|" + t.getTipo() + "|" + 
	                           t.getDescripcion() + "|" + t.getEstado() + "|" + t.getResponsable() + "|" +  
	                           comp + "|" + t.getFecha(); 
	                           
	            writer.write(linea);
	            writer.newLine();
	        }
	    } 
	}
	    
	
	public void agregar_tarea(Tarea t) throws IOException {
	    this.tareas.add(t);
	    guardarTareas(); // Guarda en el txt
	}
	
	}
	
			
		
	

