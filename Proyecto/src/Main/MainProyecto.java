package Main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainProyecto {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cod_postal, menu = 0;
		String usuario;
		String contrasenia;

		do {
			try {
				System.out.println("Menu");
				System.out.println("1. ofertas");
				System.out.println("2. identificarse");
				System.out.println("3. dar de alta");
				System.out.println("4. salir");
				menu = Integer.parseInt(br.readLine());
			} catch (NumberFormatException N) {
				System.out.println(N.getMessage());
			}

			switch (menu) {

			case 1:

				System.out.println("estas son las ofertas");

				break;

			case 2:

				System.out.println("dime tu usuario");
				usuario = br.readLine();
				System.out.println("dime tu contraseña");
				contrasenia = br.readLine();

				break;

			}

		} while (menu != 4);

		System.out.println("dime tu codigo postal");
		cod_postal = Integer.parseInt(br.readLine());

	}

}
