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
	
//M�todo para dar de alta un usuario.
	public  int alta_usuario( Usu_Registrado usu){	
		String cadenaSQL="INSERT INTO usuario_registrado VALUES('" + usu.getEmail()+ "','" +usu.getContrase�a()+"','"+ usu.getNombre() +"','"+ usu.getApellidos()+"','"+ usu.getDireccion_habitual()+"','"+ usu.getCod_postal() +"','"+ usu.getCod_oferta() +"')"; 				
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
//M�todo para borrar usuario.
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
			this.cerrar();
			return -1;
		}
	}
//M�todo para cambiar contrase�a de  usuario.
	public int editar_contra_usuario( Usu_Registrado usu){
		String cadenaSQL="UPDATE usuario_registrado SET 'contrasena'= '" + usu.getContrase�a() + "' WHERE `email`= '" + usu.getEmail()+"' ";
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
//M�todo para comprobar si un email esta en uso en la BBDD
	public int comprobar_email(String email){
		String cadenaSQL="SELECT * FROM usuario_registrado WHERE email = '"+email+"' ";				
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);	
			if(reg.next()){
				s.close();
				this.cerrar();
				return 1;
			}
			s.close();
			this.cerrar();
			return 0;			
		}
		catch ( SQLException e){
			this.cerrar();
			return -1;
		}				
	}
//M�todo para verificar el login y que devuelve un objeto usuario
	public Usu_Registrado verificar_login(String email, String contrasena){
		
		String cadenaSQL="SELECT * FROM usuario_registrado WHERE email = '" +email +"'AND contrasena ='"+ contrasena+"'";
		Usu_Registrado Usuario=new Usu_Registrado(email,contrasena);		
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			if ( reg.next()){
				
				Usuario.setCod_oferta(reg.getInt("cod_oferta"));
				Usuario.setEmail(reg.getString("email"));
				Usuario.setCod_postal(reg.getInt("cod_postal"));
				Usuario.setNombre(reg.getString("nombre"));
				Usuario.setApellidos(reg.getString("apellidos"));
				Usuario.setContrase�a(reg.getString("contrasena"));
				Usuario.setDireccion_habitual(reg.getString("direccion"));							
			}
			s.close();
			this.cerrar();
			return Usuario;
		}
		catch ( SQLException e){	
			this.cerrar();
			return null;
		}
	}
}
