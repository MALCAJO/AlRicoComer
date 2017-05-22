package Main;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;
import BaseDatos.BD_Menu;
import BaseDatos.BD_Restaurante;
import BaseDatos.BD_Usuario;
import modelos.*;

public class Main_pruebas {
	static Scanner sc;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);;
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
								if(usuarior.getTipo().equals("usuar")){
									do{
										System.out.println("quieres realizar el pedido en tu direccion habitual? ");
										direc =sc.nextLine().toUpperCase();
									}while(!direc.equals("SI")&!direc.equals("NO"));
								
									//muestra los restaurantes del codigo postal de la direccion de entrega habitual
									if (direc.equals("SI")){
										
										//System.out.println(direccion = usuarior.getDireccion_habitual());
										cod_postal = usuarior.getCod_postal();
										System.out.println("Tienes estos restaurantes a tu disposición:");
										Vector <Restaurante> restaurantes=bdrest.listarRestaurantesXzona(cod_postal);
										for (i=0;i<restaurantes.size();i++)
											System.out.println((i+1)+ ".- "+restaurantes.get(i).toString());
										System.out.println("Introduce el codigo de restaurante para ver sus platos:");
										codres=sc.nextInt();
										Vector <Menu>  menus=bdmenu.listarmenusXrestaurante(codres);
										if (menus==null){
											System.out.println("En este momento no podemos realizar la operación");
										}
										else{
											System.out.println("Platos: ");
											for (i=0;i<menus.size();i++)
												System.out.println((i+1)+ ".- "+menus.get(i).toString());													
										}
										
									}
									
									else{
										System.out.println("Introduce el código postal de la zona donde quieres el pedido: ");
										cod_postal=sc.nextInt();
										Vector <Restaurante> restaurantes=bdrest.listarRestaurantesXzona(cod_postal);
										for (i=0;i<restaurantes.size();i++)
											System.out.println((i+1)+ ".- "+restaurantes.get(i).toString());
										System.out.println("Introduce el codigo de restaurante para ver sus platos:");
										codres=sc.nextInt();
										Vector <Menu>  menus=bdmenu.listarmenusXrestaurante(codres);
										if (menus==null){
											System.out.println("En este momento no podemos realizar la operación");
										}
										else{
											System.out.println("Platos: ");
											for (i=0;i<menus.size();i++)
												System.out.println((i+1)+ ".- "+menus.get(i).toString());													
										}
									}
								}
								//si es un usuario tipo restaurante por aqui..
								if(usuarior.getTipo().equals("resta")){
									codres= bdrest.buscar_codrestaurante(usuarior.getNombre(), usuarior.getDireccion_habitual());
									Vector <Menu>  menus=bdmenu.listarmenusXrestaurante(codres);
									System.out.println("Opciones:");
									System.out.println("1- Añadir nuevo menu.");
									System.out.println("2- Borrar un menu de la lista.");
									System.out.println("3- Modificar precio de menu.");
									System.out.println("4- Salir.");
									opc=sc.nextInt();
									switch(opc){
									
										case 1://añadir menu
											
											break;
										case 2://borrar menu											
											System.out.println("Que menu deseas eliminar?");
											if (menus==null){
												System.out.println("En este momento no podemos realizar la operación");
											}
											else{
												System.out.println("Platos: ");
												for (i=0;i<menus.size();i++)
													System.out.println((i+1)+ ".- "+menus.get(i).toString());													
											}
											System.out.println("Introduce el codigo de menu:");
											System.out.println(codres);
											int cod_menu=sc.nextInt();
											int menu=bdmenu.borrar_menu(cod_menu);
											if(menu==1)
												System.out.println("Menu borrado");
											if(menu==0)
												System.out.println("No se ha eliminado ningún menu");
											if(menu==-1)
												System.out.println("Ha surgido un error en el proceso, vuelva a intentarlo.");
											
											break;
										case 3://modificar menu
											
											break;
										case 4:
											System.out.println("Hasta pronto.");
											break;
										default:
											System.out.println("En serio?");
									}
									
								}
								//el administrador
								else{
									System.out.println("eres el admin");
								}
							}
						}
						
					}
					
					//si es un visitante
					else{
						
					}
					
					break;
				case 2://Para darte de alta en la aplicación 
					
					//email, contraseña,nombre, apellido,direccion,cod postal y codigo_oferta=1"la de bienvenida"
					System.out.println("A continuación te pediremos los datos para poder realizar el registro.");
					sc.nextLine();
					System.out.println("Cual es tu nombre?");
					nombre=sc.nextLine();
					System.out.println("Apellido?");
					do{
						apellido=sc.nextLine();
						System.out.println("Email: ");//hacer comprobacion de email.
						email=sc.nextLine();
						filas=bdusu.comprobar_email(email);
						switch(filas){
							case 0:
								System.out.println("Email disponible.");
								break;
							case 1:
								System.out.println("El email introducido ya pertenece a un usuario registrado");
								break;
							case -1:
								System.out.println("Lo sentimo, ha ocurrido un problema durante el registro. Vuelva a intentarlo.");
								break;							
						}
					}while(filas!=0);	
					System.out.println("Contraseña:");
					contrasena= sc.nextLine();
					System.out.println("Direccion:");
					direccion=sc.nextLine();
					System.out.println("Código postal");
					cod_postal=sc.nextInt();
					System.out.println("Y por último, teléfono:");
					telefono=sc.nextInt();
					String tipo="usuar";
					//creamos el usuario_registrado nuevo
					Usu_Registrado usu=new Usu_Registrado( direccion, telefono,email, cod_postal, nombre, apellido, contrasena, direccion, 1,tipo);
					filas=bdusu.alta_usuario(usu);
					switch(filas){
						case 1:
							System.out.println("Registro completado con exito");
							break;
						case 0:
							System.out.println("El registro no se ha podido realizar.");
							break;
						case -1:
							System.out.println("Lo sentimo, ha ocurrido un problema durante el registro. Vuelva a intentarlo.");
							break;							
					}
										
					break;
				case 3://Lista los restaurante por codigo postal o todos los que estan dados de alta en la aplicación.					
					System.out.println("1. Lista los restaurante de un codigo postal.");
					System.out.println("2. Listar todos los restaurantes de la aplicación");
					System.out.println("3. Salir sin listar");	
					opc = sc.nextInt();
					
	//Marina no sabe escribir				
					switch(opc){
						case 1://lista los restaurantes solo de un codigo postal
							System.out.println("introduce el codigo postal en el que estas interesado:");
							cod_postal = sc.nextInt();
							Vector <Restaurante> restaurantesXzona=bdrest.listarRestaurantesXzona(cod_postal);
							if (restaurantesXzona==null){
								System.out.println("En este momento no podemos realizar la operación");

							}else{
								System.out.println("Listado de restaurantes");
								for (i=0;i<restaurantesXzona.size();i++){
									System.out.println((i+1)+ ".- "+restaurantesXzona.get(i).toString());
								}
								System.out.println("Introduce el codigo de restaurante para ver sus platos:");
								codres=sc.nextInt();
								Vector <Menu>  menus=bdmenu.listarmenusXrestaurante(codres);
								if (menus==null){
									System.out.println("En este momento no podemos realizar la operación");
								}
								else{
									System.out.println("Platos: ");
									for (i=0;i<menus.size();i++)
										System.out.println((i+1)+ ".- "+menus.get(i).toString());													
								}
							}
							
							break;
						case 2://lista todos los restaurantes en la aplicacion
							Vector <Restaurante> restaurantes=bdrest.listarRestaurantes();
							if (restaurantes==null){
								System.out.println("En este momento no podemos realizar la operación");

							}else{
								System.out.println("Listado de restaurantes");
								for (i=0;i<restaurantes.size();i++)
									System.out.println((i+1)+ ".- "+restaurantes.get(i).toString());
								System.out.println("Introduce el codigo de restaurante para ver sus platos:");
								codres=sc.nextInt();
								Vector <Menu>  menus=bdmenu.listarmenusXrestaurante(codres);
								if (menus==null){
									System.out.println("En este momento no podemos realizar la operación");

								}else{
									System.out.println("Platos: ");
									for (i=0;i<menus.size();i++)
										System.out.println((i+1)+ ".- "+menus.get(i).toString());													
								}
							}
							
							break;
						case 3:
							System.out.println("Como gustes");
							break;
						default:
							System.out.println("En serio??");
					}
					
					break;
				case 4://Sales de la aplicación.
					System.out.println("Hasta pronto");
					break;
				default://Entradas erroneas en el menu
					System.out.println("En serio??");	
			
			}
		}while(opc!=4);
	}

}
