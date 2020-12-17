package ebaluaketa3;

import java.util.Scanner;
import java.util.ArrayList;

public class ArrayListContadorStringMenu {

	public static void main(String[] args) {
		
		String cadena;
		ContadorGenerico<String> cgs = new ContadorGenerico<String>();
		Scanner teclado = new Scanner(System.in);
		ArrayList<ContadorGenerico<String>> arrayListContador = new ArrayList<ContadorGenerico<String>>();
		
		int opcion;
		int posicion;
		boolean encontrado;
		
		do {
			
			// muestro el menu
			System.out.println("1. A�adir String");
			System.out.println("2. Buscar String");
			System.out.println("3. Borrar String");
			System.out.println("4. Listar String");
			System.out.println("0. Salir");
			// leo la opcion
			System.out.print("Opcion: ");
			opcion=teclado.nextInt();
			// limpio los caracteres \r y \n del buffer
			teclado.nextLine();
			
			// controlo las opciones
			switch (opcion){
			case 1:
				// A�adir
				// leo cadena
				System.out.print("Introduzca un String: ");
				cadena = teclado.nextLine();
				// la busco en el ArrayList
				encontrado=false;
				for (posicion=0;posicion < arrayListContador.size();posicion++){
					if (cadena.equals(arrayListContador.get(posicion).getValor())){
						// si se encuentra en el array
						encontrado=true;
						// incremento el contador
						arrayListContador.get(posicion).setContador(arrayListContador.get(posicion).getContador() + 1);
						// como no puede haber un valor repetido salgo del bucle
						break;
					}
				}
				if (!encontrado){
					// si no se encuentra en el ArrayList
					// creo un nuevo elemento con los datos
					cgs = new ContadorGenerico<String>(cadena,1);
					// a�ado el elemento al ArrayList
					arrayListContador.add(cgs);
				}
				
				break;
			case 2:
				// Buscar
				// leo cadena
				System.out.print("Introduzca un String: ");
				cadena = teclado.nextLine();
				// la busco en el ArrayList
				encontrado=false;
				for (posicion=0;posicion < arrayListContador.size();posicion++){
					if (cadena.equals(arrayListContador.get(posicion).getValor())){
						// si se encuentra en el array
						encontrado=true;
						System.out.println("El elemento " + cadena + " se encuentra en la posici�n " + posicion);
						break;
					}
				}
				if (encontrado==false){
					// si NO se encuentra en el array
					// muestro un mensaje de error
					System.out.println("El elemento " + cadena + " NO se encuentra en el array.");
				}
				break;		
			case 3:
				// Borrar
				// leo cadena
				System.out.print("Introduzca un String: ");
				cadena = teclado.nextLine();
				// la busco en el ArrayList
				encontrado=false;
				for (posicion=0;posicion < arrayListContador.size();posicion++){
					if (cadena.equals(arrayListContador.get(posicion).getValor())){
						// si se encuentra en el array
						encontrado=true;
						// la borro
						arrayListContador.remove(posicion);
						System.out.println("El elemento " + cadena + " ha sido borrado.");
						break;
					}
				}
				if (encontrado==false){
					// si NO se encuentra en el array
					// muestro un mensaje de error
					System.out.println("El elemento " + cadena + " NO se encuentra en el array.");
				}
				break;
			case 4:
				// listar
				if(arrayListContador.isEmpty()){
					// si NO hay elementos en el array
					// muestro un mensaje de error
					System.out.println("El array est� vac�o.");
				}
				else {
					// si hay elementos en el array
					// los muestro
					for (posicion=0; posicion < arrayListContador.size(); posicion ++){
						System.out.println(arrayListContador.get(posicion));	
					}
				}
				break;
			case 0:
				// muestro un mensaje de despedida
				System.out.println("Agur.");
				break;
			default:
				// si se introduce una opci�n incorrecta
				System.out.println("Error. Opci�n Incorrecta.");
			}// fin_switch
		}while (opcion != 0);
			
		// cierro el Scanner
		teclado.close();

	}

}
