package BaseDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelos.Vehiculo;

public class BD_Vehiculo extends BD_Conecta{
	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Vehiculo(String fileName) {
		super(fileName);
		// TODO Auto-generated constructor stub
	}

	public int altaVehiculo(Vehiculo ve){
		String cadenaSQL="INSERT INTO vehiculo VALUES('" + ve.getMatricula() +"','" +
				ve.getCod_personal()+"')"; 	
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
	
	public int bajaVehiculo(String matricula){
		String cadenaSQL="DELETE FROM vehiculo WHERE matricula='"+matricula+"' ";
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
		
	public int modificarMatricula(String matricula,int codPer){
		String cadenaSQL="UPDATE vehiculo SET `matriucla`= '" + matricula + "' WHERE `cod_personal`= '" + codPer+"' ";
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
