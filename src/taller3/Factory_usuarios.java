package taller3;

public class Factory_usuarios {
	public Usuario crear_usuario(String username, String password, String rol) {
		return new Usuario(username,password,rol);
		
	}

}
