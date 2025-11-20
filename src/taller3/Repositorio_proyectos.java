package taller3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Repositorio_proyectos {
	private static Repositorio_proyectos instancia;
	private Factory_proyectos fabrica_proyectos;
	private ArrayList<Proyecto> proyectos;
	Scanner s = new Scanner(System.in);

	private Repositorio_proyectos() throws FileNotFoundException {
		this.proyectos = new ArrayList<>();
		 fabrica_proyectos = new Factory_proyectos();
		
		File archivo = new File("proyectos.txt");
		Scanner s = new Scanner(archivo);

		while (s.hasNextLine()) { //Rellena la lista con los proyectos del archivo de texto
			String[] partes = s.nextLine().split("\\|");
			String id = partes[0];
			String nombre = partes[1];
			String responsable = partes[2];
			Proyecto p = fabrica_proyectos.crear_proyecto(id, nombre, responsable);
			this.proyectos.add(p);

		}
		s.close();

	}

	public static Repositorio_proyectos getInstancia() throws FileNotFoundException {
		if (instancia == null) {
			instancia = new Repositorio_proyectos();

		}
		return instancia;
	}

	public ArrayList<Proyecto> getProyectos() {
		return proyectos;
	}
	
	public void agregar_proyecto(Proyecto p) {
		proyectos.add(p);
		
	
		
	}
	public void eliminar_proyecto(int proyecto) {
		
		proyectos.remove(proyecto);
		
		
	}
	public void mostrar_proyectos() {
		int r = 1;
		for(Proyecto pr: proyectos) {
			System.out.println(r+". "+pr);
			r++;
		}
	}

}
