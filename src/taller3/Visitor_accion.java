package taller3;
//Vicente Andres Rojas Lillo - 22.141.463-2 - ICCI
//Axel Ignacio Alcayaga Flores -  20.832.945-6 - ICCI
public class Visitor_accion implements IVisitor {

	@Override
	public void visitar(Tarea tarea) {
		// Obtenemos el tipo de la tarea 
        String tipo = tarea.getTipo(); 
        
        System.out.print("Tarea [ id=" + tarea.getId() +", descripcion= "+tarea.getDescripcion()+", estado= "+tarea.getEstado()+", tipo= " + tarea.getTipo()+ " --> ");

       //segun el tipo de tarea imprimimos la accion
        if (tipo.equalsIgnoreCase("Bug")) {
            System.out.println("ACCIÓN: Afecta la criticidad del proyecto.");
        } else if (tipo.equalsIgnoreCase("Feature")) {
            System.out.println("ACCIÓN: Impacta en la estimación de tiempo.");
        } else if (tipo.equalsIgnoreCase("Documentacion")) { 
            System.out.println("ACCIÓN: Mejora la calidad del proyecto.");
        } else {
            System.out.println("Acción estándar.");
        }
    }

}
