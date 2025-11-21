package taller3;
//Vicente Andres Rojas Lillo - 22.141.463-2 - ICCI
//Axel Ignacio Alcayaga Flores -  20.832.945-6 - ICCI
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Portipo implements IPriorizar {

	@Override
	public void priorizar(ArrayList<Tarea> tareas) {
		Collections.sort(tareas, new Comparator<Tarea>(){

			@Override
			public int compare(Tarea o1, Tarea o2) {
				int tipo1 = valortipo(o1.getTipo());
				int tipo2= valortipo(o2.getTipo());
				
				
				return Integer.compare(tipo1, tipo2);   
			}

			private int valortipo(String tipo) {   //Aplicamos lo mismo que en la clase Porcomplejidad
				if(tipo.equalsIgnoreCase("Bug")) {
					return 1;
				}
				if(tipo.equalsIgnoreCase("Feature")) {
					return 2;
				}
				if(tipo.equalsIgnoreCase("Documentacion")) {
					return 3;
				}
				return 0;
			}
			
		});

	}

}
