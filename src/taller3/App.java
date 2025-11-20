package taller3;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(System.in);

		Sistema sistema = Sistema.getInstancia();
		do {
			System.out.println("Ingresar nombre del usuario: ");
			String nombre = s.nextLine();
			System.out.println("Ingresar password del usuario: ");
			String password = s.nextLine();
			sistema.usuario_logear(nombre, password);

		} while (sistema.getUsuario_actual() == null);

		int opcion = 0;

		while (opcion != 3) {
			sistema.menu(1);

			System.out.println();
			opcion = s.nextInt();
			switch (opcion) {
			case 1:
				sistema.menu(2);
				int opcion_admin = s.nextInt();
				switch (opcion_admin) {
				case 1:
					sistema.ver_proyectos_tareas();
					break;
				case 2:
					int opcion2_admin = 0;
					do {
						System.out.println("1.Agregar proyecto\n2.Eliminar proyecto\n3.Salir");
						opcion2_admin = s.nextInt();
						switch (opcion2_admin) {
						case 1:
							s.nextLine(); // limpia el scanner debido que al presionar enter queda guardado el \n y no
											// me dejaria escribir el nombre
							System.out.println("Nombre del proyecto:");
							String nombre = s.nextLine();
							System.out.println("Nombre del autor:");
							String autor = s.nextLine();
							sistema.agregar_proyecto(nombre, autor);
							break;
						case 2:
							sistema.imprimir_proyectos();
							System.out.println("Seleccione un proyecto para eliminar:");
							int elegir_proyecto = s.nextInt();
							
							sistema.eliminar_proyecto(elegir_proyecto);
							break;
						case 3:
							break;
						default:
							System.out.println("Ingrese alguna de las opciones que aparecen (1 ,2 o  3");
							break;

						}

					} while (opcion2_admin!= 3);
				}
				break;
				
			case 3:
				int opcion3_admin= -1;
				do {
					System.out.println("1.Agregar tarea\n2.Eliminar tarea\n3.Salir");
					opcion3_admin = s.nextInt();//opcion 3 del menu admin
					s.nextLine();//limpia el scanner
					switch(opcion3_admin) {
					case 1:
						sistema.imprimir_proyectos();
						System.out.println("Seleccione un proyecto: ");
						int elegir_proyecto1 = s.nextInt();
						s.nextLine();
						System.out.println("Tipo de tarea (Bug, Feature, Documentacion):");
						String tipo = s.nextLine();
						System.out.println("Descripcion:");
						String descripcion = s.nextLine();
						System.out.println("Estado Inicial (Pendiente o en Progreso)");
						String estado = s.nextLine();
						System.out.println("Responsable: ");
						String responsable= s.nextLine();
						sistema.agregar_tarea(tipo,descripcion,estado,responsable,elegir_proyecto1);
						
						
						
						break;
						
					case 2:
						sistema.imprimir_proyectos();
						System.out.println("Seleccione un proyecto: ");
						int elegir_proyecto = s.nextInt();
						sistema.imprimir_tareas(elegir_proyecto);
						
						System.out.println("Seleccione una tarea:");
						int elegir_tarea = s.nextInt();
						sistema.borrar_tarea(elegir_tarea,elegir_proyecto);
						
						
						break;
					
					}
					
					}
				while(opcion3_admin!=3);
				break;

			

			}

		}

	}

}
