package modelos;

public class Usu_Registrado extends Usuario{
	
	private String nombre;
	private String contraseña;
	private String direccion_habitual;
	
	public Usu_Registrado(String direccion_entrega, int telefono, String email, int cod_postal, String nombre,
			String contraseña, String direccion_habitual) {
		super(direccion_entrega, telefono, email, cod_postal);
		this.nombre = nombre;
		this.contraseña = contraseña;
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
	 * @return the contraseña
	 */
	public String getContraseña() {
		return contraseña;
	}
	/**
	 * @param contraseña the contraseña to set
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
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
