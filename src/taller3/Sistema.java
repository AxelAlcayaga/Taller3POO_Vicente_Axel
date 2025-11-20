package taller3;

import java.io.FileNotFoundException;
import java.time.LocalDate;

public class Sistema {
	private static Sistema instancia;
	private Usuario usuario_actual;
	private Repositorio_proyectos repositorio;
    private Repositorio_tareas repositorio_t;

	
	private Sistema() throws FileNotFoundException {
		 repositorio = Repositorio_proyectos.getInstancia();
		 repositorio_t = Repositorio_tareas.getInstancia();
	}

	

	public void imprimir_proyectos() {
		repositorio.mostrar_proyectos();
	}

	public Repositorio_tareas getRepositorio_t() {
		return repositorio_t;
	}

	public void menu(int opcion) {
		switch (opcion) {
		case 1:
			System.out.println("1.Menu Admin\n2.Menu Usuario\n3.Salir");
			break;

		case 2:
			System.out.println(
					"1.Ver lista completa de proyectos y tareas\n2.Agregar o eliminar un proyecto\n3.Agregar o eliminar una tarea en un proyecto\n4.Asignar prioridades con Strategy\n5.Generar reporte de proyectos");
			break;

		case 3:
			System.out.println(
					"1.Ver proyectos disponibles\n2.Ver tareas asignadas\n3.Actualizar estado de una tarea\n4.Aplicar Visitor sobre tareas");
			break;
		}

	}

	public static Sistema getInstancia() throws FileNotFoundException {
		if (instancia == null) {
			instancia = new Sistema();
		}
		return instancia;
	}

	public void agregar_proyecto(String nombre, String autor) {

		int numero_proyecto = repositorio.getProyectos().size() + 1;
		String id = "PR" + String.format("%03d", numero_proyecto); // esto hace que el id tengo sentido en base a la
																	// cantidad de proyectos que hay, si se creearan 10
																	// proyectos el decimo seria P0010
		Proyecto p = new Proyecto(id, nombre, autor);
		repositorio.agregar_proyecto(p);
		System.out.println(p + "\nAgregado con exito!!");

	}

	public String eliminar_proyecto(int elegir_proyecto) {
		if(elegir_proyecto>repositorio.getProyectos().size() || elegir_proyecto<1) {
			return "Opcion invalida!!";
			
		}
		String id_eliminar = repositorio.getProyectos().get(elegir_proyecto - 1).getId();// consigo el id para borrar
																							// las tareas asociadas a
																							// este proyecto en el
																							// metodo eliminar_tareas
																							// del repositorio tareas
		repositorio.eliminar_proyecto(elegir_proyecto - 1);
		repositorio_t.eliminar_tareas_asociadas(id_eliminar);
		return "Proyecto y tareas asociadas eliminadas con exito!!";

	}
	
	public Usuario getUsuario_actual() {
		return usuario_actual;
	}


	public void setUsuario_actual(Usuario usuario_actual) {
		this.usuario_actual = usuario_actual;
	}


	public Usuario usuario_logear(String username, String password) throws FileNotFoundException {
		for(Usuario u: Repositorio_usuarios.getInstancia().getUsuarios()) {
			if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
				System.out.println("Usuario correctamente logeado!!");
				 this.setUsuario_actual(u);
				 return u;
				
				
			}
		}
		System.out.println("Usuario o password incorrecta!!");
		return null;
	}
	public void ver_proyectos_tareas() {
		for(Proyecto p : repositorio.getProyectos()) {
			System.out.println(p+"\nTareas:");
			for(Tarea t: p.getTareas()) {
				System.out.println(t);
			}
			System.out.println("======================================================================================================================");
			
		
		
	}


	}

	public void agregar_tarea(String tipo, String descripcion, String estado, String responsable,int elegir_proyecto1) {
		LocalDate fecha = LocalDate.now(); //da la fecha en el momento
		String fecha_string =fecha.toString(); //la convierte a string 
				
		String idproyecto_asociado = repositorio.getProyectos().get(elegir_proyecto1-1).getId();
		int numero_tarea = repositorio_t.getTareas().size()+1;
		String id = "T"+String.format("%03d", numero_tarea);
		Tarea tarea = new Tarea(idproyecto_asociado,id,tipo,descripcion,estado,responsable,null,fecha_string);
		repositorio.getProyectos().get(elegir_proyecto1-1).getTareas().add(tarea);//la agrego al proyecto elegido
		repositorio_t.getTareas().add(tarea);//la agrego a la lista global
		System.out.println("Tarea creada y agregada con exito!!");
		
		
		
	}

	public void imprimir_tareas(int elegir_proyecto) {
		int a = 1;
		for(Tarea t: repositorio.getProyectos().get(elegir_proyecto-1).getTareas()) {
			System.out.println(a+". "+ t);
			a++;
		}
		
	}

	public void borrar_tarea(int elegir_tarea, int elegir_proyecto) {
		String id_tarea = repositorio.getProyectos().get(elegir_proyecto-1).getTareas().get(elegir_tarea-1).getId();//obtiene el id de la tarea para luego borrarla "globalmente"
		repositorio.getProyectos().get(elegir_proyecto-1).getTareas().remove(elegir_tarea-1); //borra la tarea guardada en el proyecto asociado
		repositorio_t.eliminar_tarea_por_id(id_tarea);//borra la tarea "globalmente"
		
	}
}
