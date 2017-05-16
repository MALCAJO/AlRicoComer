package modelos;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Empleado {
	private int cod_personal;
	private String nombre;
	private String dni;
	private String apellidos;
	private LocalDate Fecha_Alta;
	
	public LocalDate getFecha_Alta() {
		return Fecha_Alta;
	}
	public void setFecha_Alta(LocalDate Fecha_Alta) {
		this.Fecha_Alta = Fecha_Alta;
	}
	
	public Empleado(int cod_personal,String nombre, String apellidos, String dni){
		this.cod_personal= cod_personal;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.Fecha_Alta=LocalDate.now();
	}
	public Empleado(int cod_personal,String nombre, String apellidos, String dni,LocalDate Fecha_Alta){
		this.cod_personal= cod_personal;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.Fecha_Alta = Fecha_Alta;
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
	 * @return the dni
	 */	
	public String getDni() {
		return dni;
	}
	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
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
	
	private String parseFecha(){
		DateTimeFormatter formatter;
		formatter=DateTimeFormatter.ofPattern("dd/LL/yyyy", Locale.getDefault());
		return Fecha_Alta.format(formatter);
	}
}
