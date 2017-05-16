package BaseDatos;
/*
 * 
Lee los datos de un archivo de propiedades
 */

import java.sql.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;


public class BD_Conecta {
	private String dbms;
	private String dbName;
	private String usuario;
	private String pass;
	protected Connection c;
	
	private String driver;
	private String serverName;
	private int portNumber;
	private Properties prop;
	
	public  BD_Conecta(String fileName) {	
	   try{
		this.prop = new Properties();
	    prop.loadFromXML(Files.newInputStream(Paths.get(fileName)));

		this.dbms = this.prop.getProperty("dbms");
		this.driver = this.prop.getProperty("driver");
		this.dbName = this.prop.getProperty("database_name");
		this.usuario = this.prop.getProperty("user_name");
		this.pass = this.prop.getProperty("password");
		this.serverName = this.prop.getProperty("server_name");
		this.portNumber = Integer.parseInt(this.prop.getProperty("port_number"));

	
	   }catch(FileNotFoundException e){
		   System.out.println("No se encuentra el archivo de configuración");  
	   }catch(InvalidPropertiesFormatException e){
		   System.out.println("Error formato fichero de configuración");
	   }catch(IOException e){
		   System.out.println("Error abriendo fichero de configuración");
	   }
	

	}
	
	public void abrir(){
		
		try{
			c = null;
			Properties connectionProps = new Properties();
			connectionProps.put("user", this.usuario);
			connectionProps.put("password", this.pass);
			c = DriverManager.getConnection("jdbc:" + this.dbms + "://"
					+ this.serverName + ":" + this.portNumber + "/" + this.dbName,
					connectionProps);
		}
		catch (SQLException e ){
			System.out.println(e.getMessage());
		}
	
	}	
	

	public void cerrar(){
		try{
			if (c!=null){
				c.close();
				c=null;}
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
			
		}
	}
	
	
}