package BaseDatos;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;
import Main.MainProyecto;
import modelos.Pedido;
import modelos.Oferta;

public class BD_Pedido extends BD_Conecta{
	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Pedido(String fileName) {
		super(fileName);
		// TODO Auto-generated constructor stub
	}
	
	//Metodo para generar un pedido
	public  pedido nuevo_pedido( Pedido ped){	
		String cadenaSQL="INSERT INTO pedidos VALUES('" + ped.getN_pedido()+ "','" +
		ped.getFecha_pedido()+"','"+ ped.getCod_personal() +"','"+ ped.getCod_restaurante()+"','"+ped.getDireccion_entrega()+"')"; 
		
		try{
			this.abrir();
			s=c.createStatement();
			int filas=s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return pedido;//si entra por aqui el pedido es correcto
		}
		catch ( SQLException e){	
			this.cerrar();
			return null;
		}
	}
}
