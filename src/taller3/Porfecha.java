package taller3;
//Vicente Andres Rojas Lillo - 22.141.463-2 - ICCI
//Axel Ignacio Alcayaga Flores -  20.832.945-6 - ICCI
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Porfecha implements IPriorizar {

	@Override
	public void priorizar(ArrayList<Tarea> tareas) {
		Collections.sort(tareas, new Comparator<Tarea>() {  //collections.sort tiene por defecto el ordenamiento de menor a mayor y ademas compara las 
			public int compare(Tarea t1, Tarea t2) {           //fechas naturalmente (solo si tienen la estructura de numero-numero-numero) 
				LocalDate fecha1 = t1.getFecha();
				LocalDate fecha2 = t2.getFecha();
				
				
				
				return fecha1.compareTo(fecha2);
			}
			
			
		});
		
		
		}
			                                                   
	}


