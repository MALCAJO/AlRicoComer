package modelos;

public class Usuario {
	protected String direccion_entrega;
	private int telefono;
	protected String email;
	protected int cod_postal;
	
	public Usuario(String direccion_entrega, int telefono, String email, int cod_postal) {
		this.direccion_entrega = direccion_entrega;
		this.telefono = telefono;
		this.email = email;
		this.cod_postal = cod_postal;
	}	
	/**
	 * @return the direccion_entrega
	 */
	public String getDireccion_entrega() {
		return direccion_entrega;
	}
	/**
	 * @param direccion_entrega the direccion_entrega to set
	 */
	public void setDireccion_entrega(String direccion_entrega) {
		this.direccion_entrega = direccion_entrega;
	}
	/**
	 * @return the telefono
	 */
	public int getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the cod_postal
	 */
	public int getCod_postal() {
		return cod_postal;
	}
	/**
	 * @param cod_postal the cod_postal to set
	 */
	public void setCod_postal(int cod_postal) {
		this.cod_postal = cod_postal;
	}
	
}
