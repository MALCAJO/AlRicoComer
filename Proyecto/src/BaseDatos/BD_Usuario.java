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
		String cadenaSQL="INSERT INTO usuario_registrado VALUES('" + usu.getEmail()+ "','" +usu.getContraseña()+"','"+ usu.getNombre() +"','"+ usu.getApellidos()+"','"+ usu.getDireccion_habitual()+"','"+ usu.getCod_postal() +"','"+ usu.getCod_oferta() +"','"+usu.getTipo()+"')"; 				
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
//Método para borrar usuario.
	public int borrar_usuario(String email){
		String cadenaSQL="DELETE FROM usuario_registrado WHERE `email` = '" + email+"' ";
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
//Método para cambiar contraseña de  usuario.
	public int editar_contra_usuario( String email,String contraseñaN, String contraseñaV){
		String cadenaSQL="UPDATE usuario_registrado SET 'contrasena'= '" + contraseñaN + "' WHERE `email`= '" +email+"'AND `contrasena`= '" +contraseñaV+"' ";
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
//Método para comprobar si un email esta en uso en la BBDD
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
//Método para verificar el login y que devuelve un objeto usuario
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
				Usuario.setContraseña(reg.getString("contrasena"));
				Usuario.setDireccion_habitual(reg.getString("direccion"));
				Usuario.setTipo(reg.getString("tipo"));
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
