package modelos;

import java.time.LocalDate;

public class Linea_pedido {

	private int n_pedido;
	private int n_plato;
	private int cantidad;
	private LocalDate fecha_hora;
	private double precio;
	
	public Linea_pedido(int n_pedido, int n_plato, int cantidad, LocalDate fecha_hora, double precio) {
		super();
		this.n_pedido = n_pedido;
		this.n_plato = n_plato;
		this.cantidad = cantidad;
		this.fecha_hora = fecha_hora;
		this.precio = precio;
	}
	/**
	 * @return the n_pedido
	 */
	public int getN_pedido() {
		return n_pedido;
	}
	/**
	 * @param n_pedido the n_pedido to set
	 */
	public void setN_pedido(int n_pedido) {
		this.n_pedido = n_pedido;
	}
	/**
	 * @return the n_plato
	 */
	public int getN_plato() {
		return n_plato;
	}
	/**
	 * @param n_plato the n_plato to set
	 */
	public void setN_plato(int n_plato) {
		this.n_plato = n_plato;
	}
	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public LocalDate getFecha_hora() {
		return fecha_hora;
	}
	public void setFecha_hora(LocalDate fecha_hora) {
		this.fecha_hora = fecha_hora;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
