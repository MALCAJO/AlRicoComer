package Main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import BaseDatos.BD_Menu;
import BaseDatos.BD_Restaurante;
import BaseDatos.BD_Usuario;
import modelos.*;


public class MainProyecto {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//prueba
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cod_postal, menu = 0, codres=0;
		String email;
		String contrasena;
		int codpos=0;
		String direc, regist;
		String direccion, nombre, apellido;
		int i=0,filas,telefono=0, codigo = 0,salida=0;

		BD_Menu bdmenu=new BD_Menu("base_propiedades.xml");
		BD_Restaurante bdrest=new BD_Restaurante("base_propiedades.xml");		
		BD_Usuario bdusu=new BD_Usuario("base_propiedades.xml");		

		do {
			try {
				System.out.println("Menu");
				System.out.println("1. identificarse");
				System.out.println("2. dar de alta");
				System.out.println("3. listar restaurantes");
				System.out.println("4. salir");
				menu = Integer.parseInt(br.readLine());
			} catch (NumberFormatException N) {
				System.out.println(N.getMessage());
			}
			catch (IOException e){
				System.out.println(e.getMessage());
				System.exit(0);
			}


			switch (menu) {

			case 1:

				do{//usuario registrado o no
					System.out.println("eres un usuario registrado?");
					regist = br.readLine().toUpperCase();
				}while(!regist.equals("SI") && !regist.equals("NO"));

				//usuario registrado
				if (regist.equals("SI")){
					System.out.println("login");
					System.out.println("email:");
					email = br.readLine();
					System.out.println("contraseña:");
					contrasena = br.readLine();
					Usu_Registrado usuarior = bdusu.verificar_login(email, contrasena);

					if(usuarior==null)
						System.out.println("error, no se ha podido conectar");
					else
						if (usuarior.getApellidos()==null)
							System.out.println("el usuario y la contraseña no coinciden");
						else{
							if(usuarior.getTipo().equals("usuar")){
								do{
									System.out.println("quieres realizar el pedido en tu direccion habitual? ");
									direc = br.readLine().toUpperCase();
								}while(!direc.equals("SI")&!direc.equals("NO"));

								if (direc.equals("SI")){
									//quitar los syso
									System.out.println(direccion = usuarior.getDireccion_habitual());
									cod_postal = usuarior.getCod_postal();
									System.out.println("estos son los restaurantes del codigo postal");
									Vector <Restaurante> restaurantes=bdrest.listarRestaurantesXzona(cod_postal);
									for (i=0;i<restaurantes.size();i++)
										System.out.println((i+1)+ ".- "+restaurantes.get(i).toString());

									System.out.println("que restaurante quieres, escribe su codigo?");
									codigo = Integer.parseInt(br.readLine());
									Vector <Menu> menus=bdmenu.listarmenusXrestaurante(codres);
									for (i=0;i<menus.size();i++)
										System.out.println(menus.get(i).toString());
									//agregar escoger menu comida



								}else{

									if(direc.equals("NO")){
										try{
											do{
												System.out.println("dime un codigo postal: ");
												codpos = Integer.parseInt(br.readLine());
											}while(codpos<0 || codpos>99999);
										}catch(NumberFormatException e){
											System.out.println(e.getMessage());
										}
										Vector <Restaurante> restaurantes=bdrest.listarRestaurantesXzona(codpos);
										if (restaurantes==null){
											System.out.println("En este momento no podemos realizar la operación");

										}else{
											System.out.println("Listado de restaurantes");
											for (i=0;i<restaurantes.size();i++)
												System.out.println((i+1)+ ".- "+restaurantes.get(i).toString());
											try{
												System.out.println("que restaurante quieres, escribe su codigo?");
												codigo = Integer.parseInt(br.readLine());
											}catch(NumberFormatException e){
												System.out.println(e.getMessage());
											}
											Vector <Menu> menus=bdmenu.listarmenusXrestaurante(codres);
											for (i=0;i<menus.size();i++)
												System.out.println(menus.get(i).toString());
											//agregar escoger menu comida
											try{
												do{
													System.out.println("para salir mete un 0");
													System.out.println("o dime el plato que quieres agregar"); 
													salida = Integer.parseInt(br.readLine());
												}while(salida!=0);
											}catch(NumberFormatException e){
												System.out.println(e.getMessage());
											}
										}}}}

							if(usuarior.getTipo().equals("admin")){
								try{
									do{
										System.out.println("1. añadir restaurante");
										System.out.println("2. borrar restaurante");
										System.out.println("3. borrar usuario");
										System.out.println("4. añadir empleado");
										System.out.println("4. borrar empleado");
										System.out.println("5.añadir oferta");
										System.out.println("6. borrar oferta");
										System.out.println("7. alta vehiculo");
										System.out.println("8. baja vehiculo");
										System.out.println("9. modificar matricula");
										salida = Integer.parseInt(br.readLine());
									}while(salida!=10);
								}catch(NumberFormatException e){
									System.out.println(e.getMessage());
								}

								switch(salida){

								case 1:
									System.out.println("direccion");
									direccion = br.readLine();
									System.out.println("nombre");
									nombre = br.readLine();
									try{
									System.out.println("codigo postal");
									codpos = Integer.parseInt(br.readLine());
									}catch(NumberFormatException e){
										System.out.println(e.getMessage());
									}
									try{
									System.out.println("telefono");
									telefono = Integer.parseInt(br.readLine());
									}catch(NumberFormatException e){
										System.out.println(e.getMessage());
									}
									
									break;

								case 2:

									break;

								case 3:

									break;	

								case 4:

									break;

								case 5:

									break;

								case 6:

									break;

								case 7:

									break;

								case 8:

									break;

								case 9:

									break;

								default:

									break;

								}


							}
							else{
								if(usuarior.getTipo().equals("resta")){
									try{
										do{
											//con nombre y direccion obtener cod rest
											System.out.println("1. añadir menu");
											System.out.println("2. borrar menu");
											System.out.println("3. cambiar precio");
											salida = Integer.parseInt(br.readLine());
										}while(salida!=4);
									}catch(NumberFormatException e){
										System.out.println(e.getMessage());
									}

								}}
						}
					break;



				}
				//usuario no registrado
				if(regist.equals("NO")){
					try{
						do{
							System.out.println("dime un codigo postal: ");
							codpos = Integer.parseInt(br.readLine());
						}while(codpos<0 || codpos>99999);
					}catch(NumberFormatException e){
						System.out.println(e.getMessage());
					}
					Vector <Restaurante> restaurantes=bdrest.listarRestaurantesXzona(codpos);
					if (restaurantes==null){
						System.out.println("En este momento no podemos realizar la operación");

					}else{
						System.out.println("Listado de restaurantes");
						for (i=0;i<restaurantes.size();i++)
							System.out.println((i+1)+ ".- "+restaurantes.get(i).toString());
						try{	
							System.out.print("dime el restaurante que quieres");
							codres = Integer.parseInt(br.readLine());
						}catch(NumberFormatException e){
							System.out.println(e.getMessage());
						}
						Vector <Menu> menus=bdmenu.listarmenusXrestaurante(codres);
						for (i=0;i<menus.size();i++)
							System.out.println(menus.get(i).toString());
						//agregar escoger menu comida
					}
					break;
				}





			case 2:

				System.out.println("A continuación te pediremos los datos para poder realizar el registro.");

				System.out.println("Cual es tu nombre?");
				nombre=br.readLine();
				System.out.println("Apellido?");
				apellido = br.readLine();
				do{

					System.out.println("Email: ");//hacer comprobacion de email.
					email=br.readLine();
					filas=bdusu.comprobar_email(email);
					switch(filas){
					case 0:
						System.out.println("Email disponible.");
						break;
					case 1:
						System.out.println("El email introducido ya pertenece a un usuario registrado");
						break;
					case -1:
						System.out.println("Lo sentimos, ha ocurrido un problema durante el registro. Vuelva a intentarlo.");
						break;							
					}
				}while(filas!=0);	
				System.out.println("Contraseña:");
				contrasena= br.readLine();
				System.out.println("Direccion:");
				direccion=br.readLine();
				try{
					do{
						System.out.println("Código postal");
						codpos=Integer.parseInt(br.readLine());
					}while(codpos<0 || codpos>99999);
				}catch(NumberFormatException e){
					System.out.println(e.getMessage());
				}
				try{
					System.out.println("Y por último, teléfono:");
					telefono=Integer.parseInt(br.readLine());
				}catch(NumberFormatException e){
					System.out.println(e.getMessage());
				}
				String tipo="usuar";
				//creamos el usuario_registrado nuevo
				Usu_Registrado usu=new Usu_Registrado( direccion, telefono,email, codpos, nombre, apellido, contrasena, direccion, 1,tipo);
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

			}

		} while (menu != 4);
	}

}
