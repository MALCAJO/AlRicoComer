package modelos;

public class Restaurante {
	
	private String direccion;
	private int cod_restaurante;
	private int cod_postal;
	
	public Restaurante(String direccion, int cod_restaurante, int cod_postal) {
		super();
		this.direccion = direccion;
		this.cod_restaurante = cod_restaurante;
		this.cod_postal = cod_postal;
	}
	
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the cod_restaurante
	 */
	public int getCod_restaurante() {
		return cod_restaurante;
	}
	/**
	 * @param cod_restaurante the cod_restaurante to set
	 */
	public void setCod_restaurante(int cod_restaurante) {
		this.cod_restaurante = cod_restaurante;
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
