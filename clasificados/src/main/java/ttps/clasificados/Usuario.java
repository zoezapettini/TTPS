package ttps.clasificados;

public class Usuario {

	private String nombreUsuario;
	private String clave;
	private String perfil;
	
	public Usuario(String nombreUsuario, String clave, String perfil) {
		this.nombreUsuario=nombreUsuario;
		this.clave=clave;
		this.perfil=perfil;
		// TODO Auto-generated constructor stub
	}
	
	public boolean esCorrecto(String nombre, String contraseña) {
		return contraseña.equals(this.getClave()) && nombre.equals(this.getNombreUsuario());
	}
	
	public String getClave() {
		return clave;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	public String getPerfil() {
		return perfil;
	}
	public boolean esPublicador() {
		return this.getPerfil().equals("Publicador");
	}
	
}
