package modelos;

public class Usu_Registrado extends Usuario{
	
	private String nombre;
	private String contraseña;
	private String direccion_habitual;
	private String apellidos;
	private int cod_oferta;
	private String tipo;
	
	public Usu_Registrado(String direccion_entrega, int telefono, String email, int cod_postal, String nombre,
			String apellidos,String contraseña, String direccion_habitual,int cod_oferta,String tipo) {
		super(direccion_entrega, telefono, email, cod_postal);
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.contraseña = contraseña;
		this.direccion_habitual = direccion_habitual;
		this.cod_oferta = cod_oferta;
		this.tipo=tipo;
	}
	
	

	public Usu_Registrado(String email) {
		super("", 0, email, 0);
	}



	public Usu_Registrado(String email,  String contraseña) {
		super("", 0, email, 0);
		this.contraseña = contraseña;
	}

	/**
	 * @return the cod_oferta
	 */
	public int getCod_oferta() {
		return cod_oferta;
	}

	/**
	 * @param cod_oferta the cod_oferta to set
	 */
	public void setCod_oferta(int cod_oferta) {
		this.cod_oferta = cod_oferta;
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
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
