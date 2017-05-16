package modelos;

public class Vehiculo {
	private String matricula;
	private int cod_personal;
	
	
	public Vehiculo(String matricula, int cod_personal) {
		this.matricula = matricula;
		this.cod_personal = cod_personal;
	}

	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}
	/**
	 * @param matricula the matricula to set
	 */

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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
	
	
	
}
