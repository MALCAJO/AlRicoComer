package BaseDatos;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;
import Main.MainProyecto;
import modelos.Usu_Registrado;

public class BD_Usuario extends BD_Conecta{
	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Usuario(String fileName) {
		super(fileName);
		// TODO Auto-generated constructor stub
	}
	
//Método para dar de alta un usuario.
	public  int alta_usuario( Usu_Registrado usu){	
		String cadenaSQL="INSERT INTO usuario_registrado VALUES('" + usu.getEmail()+ "','" +
		usu.getContraseña()+"','"+ usu.getNombre() +"','"+ usu.getApellidos()+"','"+ usu.getDireccion_habitual()+"','"+ usu.getCod_postal() +"','"+ usu.getCod_postal() +"')"; 				
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
//Método para borrar usuario.
	public int borrar_usuario( Usu_Registrado usu){
		String cadenaSQL="DELETE FROM usuario_registrado WHERE `email` = '" + usu.getEmail()+"' ";
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
//Método para cambiar contraseña de  usuario.
	public int editar_contra_usuario( Usu_Registrado usu){
		String cadenaSQL="UPDATE usuario_registrado SET 'contrasena'= '" + usu.getContraseña() + "' WHERE `email`= '" + usu.getEmail()+"' ";
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
//Método para verificar el login
	public int verificar_login(String email, String contrasena){
		String cadenaSQL="SELECT * From usuario_registrado WHERE email = '" +email +"'AND contrasena ='"+ contrasena+"'";
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
}
