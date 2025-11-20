package taller3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Repositorio_usuarios {
	private static Repositorio_usuarios instancia;
	private ArrayList<Usuario> usuarios;
	
	private Repositorio_usuarios() throws FileNotFoundException {        //Rellena la lista con los usuarios del archivo de texto
		this.usuarios = new ArrayList<>();
		Factory_usuarios fabrica_usuarios = new Factory_usuarios();
		File archivo = new File("usuarios.txt");
		Scanner s = new Scanner(archivo);

		while (s.hasNextLine()) {
			String[] partes = s.nextLine().split("\\|");
			String username = partes[0];
			String password = partes[1];
			String rol = partes[2];
			Usuario usuario = fabrica_usuarios.crear_usuario(username, password, rol);
			this.usuarios.add(usuario);

		}
		s.close();

	}
	
	
		
	








	public static Repositorio_usuarios getInstancia() throws FileNotFoundException {
		if(instancia==null) {
			instancia=new Repositorio_usuarios();
		}
		return instancia;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	
	
	

}



