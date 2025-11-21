package taller3;
//Vicente Andres Rojas Lillo - 22.141.463-2 - ICCI
//Axel Ignacio Alcayaga Flores -  20.832.945-6 - ICCI

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Porcomplejidad implements IPriorizar {

	@Override
	public void priorizar(ArrayList<Tarea> tareas) {
		Collections.sort(tareas, new Comparator<Tarea>(){

			@Override
			public int compare(Tarea o1, Tarea o2) {
				
				int complejidad1 = valorcomplejidad(o1.getComplejidad());
				int complejidad2 = valorcomplejidad(o2.getComplejidad());  
			
				
				return Integer.compare(complejidad1, complejidad2);
			}

			private int valorcomplejidad(String complejidad) {   //como collections.sort ordena de menor a mayor y queremos ordenar de prioridad alta a baja,
				if(complejidad.equalsIgnoreCase("Alta")) {       //decimos que alta retorne el valor mas bajo, media el valor medio y baja el valor alto
 					return 1;
				}
				if(complejidad.equalsIgnoreCase("Media")){
					return 2;
				}
				if(complejidad.equalsIgnoreCase("Baja")) {
					return 3;
				}
				return 99999;
			}
			
			
			
		});
		

		
	}

	
	

}
