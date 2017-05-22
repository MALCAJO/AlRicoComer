package modelos;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
public class Pedido {

	private int n_pedido;
	private LocalDate fecha_pedido;
	private int cod_personal;
	private int cod_restaurante;
	private String direccion_entrega;
	private double importe_total;
	
	public Pedido(int n_pedido, LocalDate fecha_pedido, int cod_personal, int cod_restaurante,
			String direccion_entrega, double importe_total) {
		this.n_pedido = n_pedido;
		this.fecha_pedido = LocalDate.now();
		this.cod_personal = cod_personal;
		this.cod_restaurante = cod_restaurante;
		this.direccion_entrega = direccion_entrega;
		this.importe_total= 0;
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
	 * @return the fecha_pedido
	 */
	public LocalDate getFecha_pedido() {
		return fecha_pedido;
	}
	/**
	 * @return the cod_personal
	 */
	public int getCod_personal() {
		return cod_personal;
	}
	/**
	 * @param cod_personal the cod_personal to set
	 */
	public void setCod_personal(int cod_personal) {
		this.cod_personal = cod_personal;
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
	 * @return String de pedido 
	 */
	@Override
	public String toString() {
		return "Pedido [n_pedido=" + n_pedido + ", fecha_pedido=" + fecha_pedido + ", cod_personal=" + cod_personal
				+ ", cod_restaurante=" + cod_restaurante + ", direccion_entrega=" + direccion_entrega
				+ ", importe_total=" + importe_total + "]";
	}
	
	
}
