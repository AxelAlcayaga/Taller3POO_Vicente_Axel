package taller3;
//Vicente Andres Rojas Lillo - 22.141.463-2 - ICCI
//Axel Ignacio Alcayaga Flores -  20.832.945-6 - ICCI
public class Factory_usuarios {
	public Usuario crear_usuario(String username, String password, String rol) {
		return new Usuario(username,password,rol);
		
	}

}
