package taller3;

import java.io.IOException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);

		Sistema sistema = Sistema.getInstancia();
		
		// Logeo
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
				if(sistema.getUsuario_actual().getRol().equals("Colaborador")) {  //si es de rol colaborador no puede abrir el menu admin
					System.out.println("Acceso solo permitido para admin!!");
					break;
				}
				// ==========Menu admin======================
				int opcion_admin = 0;
				
				do { 
					sistema.menu(2);
					System.out.println("6. Volver al menú principal"); // Necesario para salir del bucle
					opcion_admin = s.nextInt();
					switch (opcion_admin) {
					case 1: //Ver proyectos y tareas
						sistema.ver_proyectos_tareas();
						break;
					case 2:
						int opcion2_admin = 0;    //Agregar o eliminar proyecto
						do {
							System.out.println("1.Agregar proyecto\n2.Eliminar proyecto\n3.Salir");
							opcion2_admin = s.nextInt();
							switch (opcion2_admin) {
							case 1:
								s.nextLine(); 
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
						break;
					case 3:
						int opcion3_admin= -1;   //Agrega o elimina tareas
						do {
							System.out.println("1.Agregar tarea\n2.Eliminar tarea\n3.Salir");
							opcion3_admin = s.nextInt();
							s.nextLine();
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
							case 3:
								break;
							default: 
								System.out.println("Opcion invalida tareas");
								break;
							}
						} while(opcion3_admin!=3);
						break;
					case 4: //Ordena tareas por tipo, fecha o prioridad. Ordena las de un proyecto en especifico o todas
						int opcion_admin4 = 0;
						do {
							System.out.println("1.Ordenar Tareas de un proyecto\n2.Ordenar tareas de todos los proyectos\n3.Salir");
							opcion_admin4=s.nextInt();
							switch(opcion_admin4) {
							case 1:
								sistema.imprimir_proyectos();
								System.out.println("Seleccione un proyecto: ");
								int elegir_proyecto = s.nextInt();
								elegir_proyecto-=1;
								System.out.println("1.Ordenar tareas por fecha (mas antigua a mas nueva)\n2.Ordenar tareas por complejidad\n3.Ordenar tareas por tipo");
								int elegir_orden = s.nextInt();
								sistema.elegirorden_individual(elegir_orden,elegir_proyecto);//ordenar tareas de un solo proyecto
								break;
								
								
							case 2:
								System.out.println("1.Ordenar tareas por fecha (mas antigua a mas nueva)\n2.Ordenar tareas por complejidad\n3.Ordenar tareas por tipo");
								int elegir_orden2 = s.nextInt();
								sistema.elegirorden_todo(elegir_orden2); //ordenar todas las tareas
								break;
								
							case 3:
								break;
							default:
								System.out.println("opcion no disponible!!");
								break;
									
						}
						}
						while(opcion_admin4!=3);
						break;
					case 5: //crear unn archivo de texto reporte
						sistema.generarreporte();
						break;
						
						
					case 6: // Caso para salir del while de admin
						break;
						
					default:
						System.out.println("opcion invalida admin!!");
						break;
					}
				} while (opcion_admin != 6); 
				break;
			
			case 2: //========Menu usuario=======
				

			case 3:
				// Salir
				break;

			
			default:
				System.out.println("Opción invalida!!");
				break;
			}
		}
	}
}