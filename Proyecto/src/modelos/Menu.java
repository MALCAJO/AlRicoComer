package modelos;

import java.sql.ResultSet;
import java.time.LocalDate;

public class Menu {

	private double precio;
	private String nombre;
	private int cod_restaurante;
	private int cod_plato;
	
	public Menu(double precio, String nombre, int cod_restaurante, int cod_plato) {
		this.precio = precio;
		this.nombre = nombre;
		this.cod_restaurante = cod_restaurante;
		this.cod_plato = cod_plato;
	}

	
	public Menu(String nombre) {
		super();
		this.nombre = nombre;
	}


	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
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
	 * @return the cod_plato
	 */
	public int getCod_plato() {
		return cod_plato;
	}
	/**
	 * @param cod_plato the cod_plato to set
	 */
	public void setCod_plato(int cod_plato) {
		this.cod_plato = cod_plato;
	}

/**
 * @return String de menu
 */
	@Override
	public String toString() {
		return "Menu: "+ nombre + ", precio: "+precio+"€. Código de plato: "
				+ cod_plato;
	}
	
	
}
