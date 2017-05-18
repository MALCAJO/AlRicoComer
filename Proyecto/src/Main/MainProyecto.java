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

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cod_postal, menu = 0, codres;
		String email;
		String contrasena;
		int codpos=0;
		String direc, regist;
		String direccion;
		int i=0;

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

				//cambiar a usuario registrado o no.

				do{
					System.out.println("eres un usuario registrado?");
					regist = br.readLine().toUpperCase();
				}while(!regist.equals("SI") && !regist.equals("NO"));


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


							}else{
								if(direc.equals("NO")){

								}
							}
							if(direc.equals("NO")){
								try{
									do{
										System.out.println("dime un codigo postal: ");
										codpos = Integer.parseInt(br.readLine());
									}while(codpos<0 || codpos>99999 || codpos+"".length()!=5);
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
									System.out.print("dime el restaurante que quieres");
									codres = Integer.parseInt(br.readLine());

								}}}





					break;

				}
				//problem
//abvhnjcghjkcgkvhjkcvhjkcg
				if(regist.equals("NO")){
					try{
						//do{
						System.out.println("dime un codigo postal: ");
						codpos = Integer.parseInt(br.readLine());
						//}while(codpos<0 || codpos>99999 || codpos+"".length()!=5);
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
						System.out.print("dime el restaurante que quieres");
						codres = Integer.parseInt(br.readLine());

					}//error
					break;
				}





			case 2:




				break;

			}

		} while (menu != 4);
	}

}
