package Main;

import java.util.Scanner;
import java.util.Vector;

import BaseDatos.BD_Menu;
import BaseDatos.BD_Restaurante;
import BaseDatos.BD_Usuario;
import modelos.Menu;
import modelos.Restaurante;
import modelos.Usu_Registrado;

public class Main_pruebas_Marina {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Scanner sc=new Scanner(System.in);;
				int  telefono,cod_postal, opc = 0, codres;
				int filas;
				String email;
				String contrasena;
				String direc,nombre,apellido, regist;
				String direccion;
				int i=0;

				BD_Menu bdmenu=new BD_Menu("base_propiedades.xml");
				BD_Restaurante bdrest=new BD_Restaurante("base_propiedades.xml");		
				BD_Usuario bdusu=new BD_Usuario("base_propiedades.xml");	
				
				do{			
					System.out.println("Menu de opciones:");
					System.out.println("1. Hacer pedido");
					System.out.println("2. Registro de nuevo usuario");
					System.out.println("3. Listar restaurantes");
					System.out.println("4. Salir");
					opc = sc.nextInt();
					switch(opc){
					case 1://Para hacer pedido entra por aqui
						sc.nextLine();
						do{
							System.out.println("Eres un usuario registrado?(si/no)");
							regist =sc.nextLine().toUpperCase();
						}while(!regist.equals("SI") && !regist.equals("NO"));
						
						//si es un usuario registrado
						if(regist.equals("SI")){
							System.out.println("Introduce tu email: ");
							email=sc.nextLine();
							System.out.println("Y contraseña: ");
							contrasena=sc.nextLine();
							Usu_Registrado usuarior = bdusu.verificar_login(email, contrasena);
							if(usuarior==null)
								System.out.println("Error en la conexión.");
							else{
								if (usuarior.getApellidos()==null)
									System.out.println("el usuario y la contraseña no coinciden");
								
								else{
									//si es del tipo usuario por aqui
									if(usuarior.getTipo().equals("admin")){
										do{
											System.out.println("Menu de opciones:");
											System.out.println("1. Añadir restaurante");
											System.out.println("2. Borrar restaurante");
											System.out.println("3. Borrar usuario");
											System.out.println("4. Añadir empleado");
											System.out.println("5. Borrar empleado");
											System.out.println("6. Añadir oferta");
											System.out.println("7. Borrar oferta");
											System.out.println("8. Añadir Vehiculo");
											System.out.println("9. Borrar vehiculo");
											System.out.println("10. Modificar matricula");
											System.out.println("11. Salir");
											opc = sc.nextInt();
										}while(opc > 11);
									
										switch(opc){
										case 1:
											System.out.println("dime direccion ");
											direc=sc.nextLine();
											System.out.println("dime el nombre del restaurante");
											nombre=sc.nextLine();
											System.out.println("dime el codigo postal");
											cod_postal=sc.nextInt();
											System.out.println("dime el telefono");
											telefono=sc.nextInt();
											System.out.println("dime el cif");
											sc.nextLine();
											String cif=sc.nextLine();
											Restaurante r1= new Restaurante(direc,cod_postal,telefono,cif,nombre);
											int comprob=bdrest.añadir_Restaurante(r1);
										break;
										case 2:
											System.out.println("dime el codigo del restaurante");
											int cod_res=sc.nextInt();
											bdrest.borrar_Restaurante(cod_res);
										break;
										
											}
									}
								}
							}
						}	
					}
				}while(opc!=4);
	}
}
	