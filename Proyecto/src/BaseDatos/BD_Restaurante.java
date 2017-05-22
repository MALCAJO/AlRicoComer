package BaseDatos;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;
import Main.MainProyecto;
import modelos.Restaurante;

/**
 * 
 * @author admin
 *
 */
public class BD_Restaurante extends BD_Conecta{
	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Restaurante(String fileName) {
		super(fileName);
		// TODO Auto-generated constructor stub
	}
/**
 * M�todo para a�adir un restaurante.
 * @param resta
 * @return
 */
	public  int a�adir_Restaurante( Restaurante resta){	
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
/**
 * M�todo para borrar un restaurante.
 * @param resta
 * @return
 */
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
/**
 * Listo los restaurantes de un  c�digo postal
 * @param cod_postal
 * @return
 */
	public  Vector<Restaurante> listarRestaurantesXzona(int cod_postal){		
		String cadenaSQL="SELECT * FROM restaurante WHERE cod_postal='"+cod_postal+"'";
		Vector<Restaurante> listaRes=new Vector<Restaurante>();
		
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				listaRes.add(new Restaurante(reg.getString("direccion"),reg.getString("nombre"),reg.getInt("cod_restaurante"),reg.getInt("cod_postal"),reg.getInt("telefono"),reg.getString("cif")  ));
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
	/**
	 * Busco el c�digo restaurante pasando los par�metros nombre y direccion del restaurante
	 * @param nombre
	 * @param direccion
	 * @return
	 */
	public int buscar_codrestaurante(String nombre, String direccion){
		String cadenaSQL="SELECT cod_restaurante FROM restaurante WHERE nombre = '"+nombre+"' AND direccion = '"+direccion+"'";
		int cod=0;
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);	
			if ( reg.next()){
				cod=reg.getInt("cod_restaurante");
			}
			s.close();
			this.cerrar();
			return cod;			
		}
		catch ( SQLException e){
			this.cerrar();
			return -1;
		}
	}
/**
 * lista todos los restaurantes
 * @return
 */
	public  Vector<Restaurante> listarRestaurantes(){		
		String cadenaSQL="SELECT * FROM restaurante";
		Vector<Restaurante> listaRes=new Vector<Restaurante>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				listaRes.add(new Restaurante(reg.getString("direccion"),reg.getString("nombre"),reg.getInt("cod_restaurante"),reg.getInt("cod_postal"),reg.getInt("telefono"),reg.getString("cif")  ));
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
