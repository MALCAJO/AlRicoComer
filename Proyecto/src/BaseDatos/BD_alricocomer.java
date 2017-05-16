package BaseDatos;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;
import proyecto.Main;
import modelos.*;


public class BD_alricocomer extends BD_Conecta{
	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Conecta(String file){
		super(file);
	}
	
	//Este metodo añade un menu a un restaurante determinado.
	public  int añadir_menu( Menu me){	
		String cadenaSQL="INSERT INTO menu VALUES('" + me.getCod_plato()+ "','" +
		me.getCod_restaurante()+"','"+ me.getPrecio() +"','"+ me.getNombre()+"')"; 	
		
		try{
		this.abrir();
		s=c.createStatement();
		int filas=s.executeUpdate(cadenaSQL);
		s.close();
		this.cerrar();
		return filas;
		}
		catch ( SQLException e){			
			return -1;
		}
	}
	//metodo que muestra los menus de un restaurante
	public  Vector<Menu> listarmenusXrestaurante(String cod_restaurante){
		String cadenaSQL="SELECT * from menu WHERE cod_restaurante='"+cod_restaurante+"'";
		Vector<Menu> listaMenu=new Vector<Menu>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				listaMenu.add(new Menu(reg.getDouble("precio"),reg.getString("nombre"),reg.getInt("cod_restaurante"),reg.getInt("cod_plato")));
			}
			s.close();
			this.cerrar();
			return listaMenu;
		}
		catch ( SQLException e){		
			return null;			
		}
	}
	//Listo los restaurantes por código postal
	public  Vector<Restaurante> listarRestaurantesXzona(String cod_postal){
		String cadenaSQL="SELECT * from restaurante WHERE cod_postal='"+cod_postal+"'";
		Vector<Restaurante> listaRes=new Vector<Restaurante>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				listaRes.add(new Restaurante(reg.getString("direccion"),reg.getInt("cod_restaurante"),reg.getInt("cod_postal")));
			}
			s.close();
			this.cerrar();
			return listaRes;
		}
		catch ( SQLException e){		
			return null;			
		}
	}
	
}
