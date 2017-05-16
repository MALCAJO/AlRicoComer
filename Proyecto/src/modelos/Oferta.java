package modelos;

public class Oferta {
	private int cod_oferta;
	private int descuento;
	private String descripcion;
	
	public Oferta(int cod_oferta, int descuento, String descripcion) {
		this.cod_oferta = cod_oferta;
		this.descuento = descuento;
		this.descripcion = descripcion;		
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
	 * @return the descuento
	 */
	public int getDescuento() {
		return descuento;
	}
	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
