package evaluacion3;

import java.util.Scanner;
import java.util.ArrayList;

public class ArrayListContadorIntegerMenu {

	public static void main(String[] args) {
		
		//String cadena;
		int entero;
		ContadorGenerico<Integer> cgi = new ContadorGenerico<Integer>();
		Scanner teclado = new Scanner(System.in);
		ArrayList<ContadorGenerico<Integer>> arrayListContador = new ArrayList<ContadorGenerico<Integer>>();
		
		int opcion;
		int posicion;
		boolean encontrado;
		
		do {
			
			// muestro el menu
			System.out.println("1. A�adir Entero");
			System.out.println("2. Buscar Entero");
			System.out.println("3. Borrar Entero");
			System.out.println("4. Listar Entero");
			System.out.println("0. Salir");
			// leo la opcion
			System.out.print("Opcion: ");
			opcion=teclado.nextInt();
			// limpio los caracteres \r y \n del buffer
			//teclado.nextLine();
			
			// controlo las opciones
			switch (opcion){
			case 1:
				// A�adir
				// leo un entero
				System.out.print("Introduzca un Entero: ");
				entero = teclado.nextInt();
				// lo busco en el ArrayList
				for (posicion=0;posicion < arrayListContador.size();posicion++){
					if (entero == arrayListContador.get(posicion).getValor()){
						// si se encuentra en el array
						// incremento el contador
						arrayListContador.get(posicion).setContador(arrayListContador.get(posicion).getContador() + 1);
						// como no puede haber un valor repetido salgo del bucle
						break;
					}
				}
				if (posicion == arrayListContador.size()){
					// si no se encuentra en el ArrayList
					// creo un nuevo elemento con los datos
					cgi = new ContadorGenerico<Integer>(entero,1);
					// a�ado el elemento al ArrayList
					arrayListContador.add(cgi);
				}
				
				break;
			case 2:
				// Buscar
				// leo un entero
				System.out.print("Introduzca un Entero: ");
				entero = teclado.nextInt();
				// lo busco en el ArrayList
				encontrado=false;
				for (posicion=0;posicion < arrayListContador.size();posicion++){
					if (entero == arrayListContador.get(posicion).getValor()){
						// si se encuentra en el array
						encontrado=true;
						System.out.println("El elemento " + entero + " se encuentra en la posici�n " + posicion);
						break;
					}
				}
				if (encontrado==false){
					// si NO se encuentra en el array
					// muestro un mensaje de error
					System.out.println("El elemento " + entero + " NO se encuentra en el array.");
				}
				break;		
			case 3:
				// Borrar
			// leo un entero
				System.out.print("Introduzca un Entero: ");
				entero = teclado.nextInt();
				// la busco en el ArrayList
				encontrado=false;
				for (posicion=0;posicion < arrayListContador.size();posicion++){
					if (entero == arrayListContador.get(posicion).getValor()){
						// si se encuentra en el array
						encontrado=true;
						// la borro
						arrayListContador.remove(posicion);
						System.out.println("El elemento " + entero + " ha sido borrado.");
						break;
					}
				}
				if (encontrado==false){
					// si NO se encuentra en el array
					// muestro un mensaje de error
					System.out.println("El elemento " + entero + " NO se encuentra en el array.");
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
