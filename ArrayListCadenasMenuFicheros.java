package ebaluaketa3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class ArrayListCadenasMenuFicheros {

	public static void main(String[] args) {
		
		String cadena;
		Scanner teclado = new Scanner(System.in);
		ArrayList<String> arrayListString = new ArrayList<String>();
		
		int opcion;
		int posicion;
		
		boolean modificado = false;
		
		// abro el fichero en modo lectura
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		archivo = new File ("cadenas.txt");
		
		try {
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
			// cargo el contenido del fichero en el ArrayList
			while((cadena=br.readLine())!=null){
				arrayListString.add(cadena);
			}
			// cierro el FileReader
			br.close();
			fr.close();
			
			
			// muestro un mensaje informativo
			System.out.println("Datos cargados con éxito.");
			
		} catch (FileNotFoundException e) {
			// si no se encuentra el archivo
			System.out.println("Error al abrir el fichero.");
		} catch (IOException e) {
			// si se produce una excepcion de entrada/salida
			System.out.println("Error al leer los datos del fichero.");
		}
		
		do {
			
			// muestro el menu
			System.out.println("1. Añadir String");
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
				// Añadir
				// leo cadena
				System.out.print("Introduzca un String: ");
				cadena = teclado.nextLine();
				
				// la añado al ArrayList
				arrayListString.add(cadena);
				
				//actualizo el valor de modificado
				modificado = true;
				break;
			case 2:
				// Buscar
				// leo cadena
				System.out.print("Introduzca un String: ");
				cadena = teclado.nextLine();
				// la busco en el ArrayList
				if (arrayListString.contains(cadena)){
					// si se encuentra en el array
					// obtengo su posicion
					posicion = arrayListString.indexOf(cadena);
					System.out.println("El elemento " + cadena + " se encuentra en la posición " + posicion);
				}
				else {
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
				if (arrayListString.contains(cadena)){
					// si se encuentra en el array
					// lo borro
					arrayListString.remove(cadena);
					System.out.println("El elemento " + cadena + " ha sido borrado.");
					//actualizo el valor de modificado
					modificado = true;
				}
				else {
					// si NO se encuentra en el array
					// muestro un mensaje de error
					System.out.println("El elemento " + cadena + " NO se encuentra en el array.");
				}
				
				break;			
			case 4:
				// listar
				if(arrayListString.isEmpty()){
					// si NO hay elementos en el array
					// muestro un mensaje de error
					System.out.println("El array está vacío.");
				}
				else {
					// si hay elementos en el array
					// los muestro
					for (posicion=0; posicion < arrayListString.size(); posicion ++){
						System.out.println(arrayListString.get(posicion));	
					}
				}
				break;
			case 0:
				// muestro un mensaje de despedida
				System.out.println("Agur.");
				break;
			default:
				// si se introduce una opción incorrecta
				System.out.println("Error. Opción Incorrecta.");
			}// fin_switch
		}while (opcion != 0);
			
		// cierro el Scanner
		teclado.close();
		
		// compruebo si los datos han cambiado
		if (modificado){
			// si han cambiado los grabo en el fichero
			FileWriter fw = null;
			PrintWriter pw = null;
			try {
				fw = new FileWriter("cadenas.txt");
				pw = new PrintWriter(fw);
				// grabo el contenido del ArrayList en el fichero
				for(posicion=0;posicion < arrayListString.size();posicion++){
					cadena = arrayListString.get(posicion);
					pw.println(cadena);
				}
				
				// cierro el FileWriter
				pw.close();
				fw.close();
				
				// muestro un mensaje informativo
				System.out.println("Datos grabados con éxito.");
				
			} catch (IOException e) {
				// si se produce una excepcion de entrada/salida
				System.out.println("Error al escribir los datos en el fichero.");
			}	
		}
	}

}
