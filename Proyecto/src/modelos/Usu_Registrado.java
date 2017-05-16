package modelos;

public class Usu_Registrado extends Usuario{
	
	private String nombre;
	private String contrase�a;
	private String direccion_habitual;
	
	public Usu_Registrado(String direccion_entrega, int telefono, String email, int cod_postal, String nombre,
			String contrase�a, String direccion_habitual) {
		super(direccion_entrega, telefono, email, cod_postal);
		this.nombre = nombre;
		this.contrase�a = contrase�a;
		this.direccion_habitual = direccion_habitual;
	}
	
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the contrase�a
	 */
	public String getContrase�a() {
		return contrase�a;
	}
	/**
	 * @param contrase�a the contrase�a to set
	 */
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	/**
	 * @return the direccion_habitual
	 */
	public String getDireccion_habitual() {
		return direccion_habitual;
	}
	/**
	 * @param direccion_habitual the direccion_habitual to set
	 */
	public void setDireccion_habitual(String direccion_habitual) {
		this.direccion_habitual = direccion_habitual;
	}
	
	
}
