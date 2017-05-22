package BaseDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelos.Empleado;
public class BD_Empleado extends BD_Conecta {
	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Empleado(String fileName) {
		super(fileName);
		// TODO Auto-generated constructor stub
	}

	public int altaEmpleado(Empleado em){
		String cadenaSQL="INSERT INTO empleado VALUES('" + em.getCod_personal() +"','" +
				em.getNombre()+"','"+em.getDni() +"','"+em.getApellidos() +"','"+em.getFecha_Alta()+ "')"; 	
		try{
			this.abrir();
			s=c.createStatement();
			int filas=s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
			}
			catch ( SQLException e){
				this.cerrar();
				return -1;
			}
	}
	
	public int bajaEmpleado(int codPer){
		String cadenaSQL="DELETE FROM empleado WHERE cod_personal='"+codPer+"' ";
		try{
			this.abrir();
			s=c.createStatement();
			int filas=s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
		}
		catch ( SQLException e){		
			this.cerrar();
			return -1;
		}
	
	}
}
