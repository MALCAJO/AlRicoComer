package BaseDatos;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;
import Main.MainProyecto;
import modelos.Pedido;
import modelos.Oferta;
import modelos.Linea_pedido;

public class BD_Pedido extends BD_Conecta{
	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Pedido(String fileName) {
		super(fileName);
		// TODO Auto-generated constructor stub
	}
	
	//Metodo para generar un pedido
	public  int nuevo_pedido( Pedido ped, Vector<Linea_pedido> ve){	
		
		String cadenaSQL="INSERT INTO pedido VALUES('" + ped.getN_pedido()+ "','" +
		ped.getFecha_pedido()+"','"+ ped.getCod_personal() +"','"+ ped.getCod_restaurante()+"','"+ped.getDireccion_entrega()+"')"; 
		double importe_total=0;
		try{
			this.abrir();
			s=c.createStatement();
			int filas=s.executeUpdate(cadenaSQL);
			if (filas!=0){
				// Nos recorremos el vector insertando las líneas 
				for(int i=0;i<ve.size();i++){
					Linea_pedido linea=ve.get(i);
					String cadenaLinea="INSERT INTO linea_pedido VALUES('" + linea.getN_pedido()+ "','" +
							linea.getN_plato()+"','"+ linea.getCantidad() +"','"+ linea.getFecha_hora()+"','"+linea.getPrecio()+"')";
					s.executeUpdate(cadenaLinea);
					importe_total=importe_total+(linea.getCantidad()*linea.getPrecio());
					
				}
				String precioActu="UPDATE  pedido SET importe_total=" +importe_total+ " WHERE num_pedido = " +ped.getN_pedido();
				s.executeUpdate(precioActu);
				}
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
