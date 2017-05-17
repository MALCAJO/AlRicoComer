package BaseDatos;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;
import Main.MainProyecto;
import modelos.Restaurante;


public class BD_Restaurante extends BD_Conecta{
	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Restaurante(String fileName) {
		super(fileName);
		// TODO Auto-generated constructor stub
	}
//Método para añadir un restaurante.
	public  int añadir_Restaurante( Restaurante resta){	
		String cadenaSQL="INSERT INTO restaurante VALUES('" + resta.getCod_restaurante() + "','" +
				resta.getDireccion()+"','"+ resta.getCod_postal() +"','"+ resta.getTelefono() + "','"+ resta.getCif() +"')"; 				
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
//Método para borrar un restaurante.
	public int borrar_Restaurante( Restaurante resta){
		String cadenaSQL="DELETE FROM restaurante WHERE `email` = '" + resta.getCod_restaurante()+"' ";
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
//Listo los restaurantes por código postal
	public  Vector<Restaurante> listarRestaurantesXzona(int cod_postal){		
		String cadenaSQL="SELECT * from restaurante WHERE cod_postal='"+cod_postal+"'";
		Vector<Restaurante> listaRes=new Vector<Restaurante>();
		
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				listaRes.add(new Restaurante(reg.getString("direccion"),reg.getInt("cod_restaurante"),reg.getInt("cod_postal"),reg.getInt("telefono"),reg.getString("cif")  ));
			}
			s.close();
			this.cerrar();
			return listaRes;
			}
		catch ( SQLException e){
			this.cerrar();
			return null;			
		}
	}
//Listo todos los restaurantes
	public  Vector<Restaurante> listarRestaurantes(){		
		String cadenaSQL="SELECT * from restaurante";
		Vector<Restaurante> listaRes=new Vector<Restaurante>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				listaRes.add(new Restaurante(reg.getString("direccion"),reg.getInt("cod_restaurante"),reg.getInt("cod_postal"),reg.getInt("telefono"),reg.getString("cif")  ));
			}
			s.close();
			this.cerrar();
			return listaRes;
			}
		catch ( SQLException e){
			this.cerrar();
			return null;			
		}
	}	
}
