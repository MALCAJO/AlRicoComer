package BaseDatos;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;
import Main.MainProyecto;
import modelos.Menu;



public class BD_Menu extends BD_Conecta{
	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Menu(String fileName) {
		super(fileName);
		// TODO Auto-generated constructor stub
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
			this.cerrar();
			return -1;
		}
	}
//Método para borar menus de un restaurante	
	public int borrar_menu(Menu me){
		String cadenaSQL="DELETE FROM menu WHERE cod_plato='"+me.getCod_plato()+"' ";
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
//Método para cambiar precio de  un plato.
	public int cambiar_precio( Menu me ){
		String cadenaSQL="UPDATE menu SET `precio`= '" + me.getPrecio() + "' WHERE `cod_plato`= '" + me.getCod_plato()+"' ";
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
//metodo que muestra los menus de un restaurante
	public  Vector<Menu> listarmenusXrestaurante(int cod_restaurante){
		String cadenaSQL="SELECT * from menu WHERE cod_restaurante='"+cod_restaurante+"'";
		Vector<Menu> listaMenu=new Vector<Menu>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				listaMenu.add(new Menu(reg.getDouble("precio"),reg.getString("nombre"),reg.getInt("cod_restaurante"),reg.getInt("cod_plato") ) );
			}
			s.close();
			this.cerrar();
			return listaMenu;
		}
		catch ( SQLException e){
			this.cerrar();
			return null;			
		}
	}
	
	
}
