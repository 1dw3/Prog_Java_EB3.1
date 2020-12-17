package evaluacion3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.ArrayList;

public class ArrayListContadorIntegerMenuSerializable {

		@SuppressWarnings("unchecked")
		public static void main(String[] args) {
		
		//String cadena;
		int entero;
		ContadorGenerico<Integer> cgi = new ContadorGenerico<Integer>();
		Scanner teclado = new Scanner(System.in);
		ArrayList<ContadorGenerico<Integer>> arrayListContador = new ArrayList<ContadorGenerico<Integer>>();
		
		int opcion;
		int posicion;
		boolean encontrado;
		
		boolean modificado = false;
		
		// cargo los datos desde el fichero
		// leo los datos desde contadorinteger.dat
		try {
			FileInputStream fis=new FileInputStream("contadorinteger.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
							
			// mientras que no sea el final del fichero leo los datos
			while(fis.available() > 0){
				cgi = (ContadorGenerico<Integer>)ois.readObject();
				// añado el objeto leido al nuevo ArrayList
				arrayListContador.add(cgi);
			}
			ois.close(); 		
		} catch (FileNotFoundException e) {
			// si no se encuentra el archivo
			System.out.println("Error al abrir el fichero.");
		} catch (IOException e) {
			// si se produce una excepcion de entrada/salida
			System.out.println("Error al leer los datos del fichero.");
		} catch (ClassNotFoundException e) {
			// si no se reconoce la Clase a serializar
			System.out.println("Los datos de esta Clase no se pueden Serializar");
		}	
		
		do {
			
			// muestro el menu
			System.out.println("1. Añadir Entero");
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
				// Añadir
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
					// añado el elemento al ArrayList
					arrayListContador.add(cgi);
				}
				// actualizo el valor de modificado
				modificado = true;
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
						System.out.println("El elemento " + entero + " se encuentra en la posición " + posicion);
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
				// actualizo el valor de modificado
				modificado = true;
				break;
			case 4:
				// listar
				if(arrayListContador.isEmpty()){
					// si NO hay elementos en el array
					// muestro un mensaje de error
					System.out.println("El array está vacío.");
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
				// si se introduce una opción incorrecta
				System.out.println("Error. Opción Incorrecta.");
			}// fin_switch
		}while (opcion != 0);
			
		// cierro el Scanner
		teclado.close();
		
		// si los datos han sido modificados los grabo
		if (modificado){
			try {
				// grabo los datos 
				FileOutputStream fos=new FileOutputStream("contadorinteger.dat");
				ObjectOutputStream oos = new ObjectOutputStream (fos);	
				
				// recorro el ArrayList guardando los datos
				
				for(posicion=0;posicion < arrayListContador.size();posicion++){
					// grabo el objeto de esa posicion
					oos.writeObject(arrayListContador.get(posicion));
				}
				// cierro el fichero 		
				oos.close();
			} catch (IOException e) {
				// si se produce una excepcion de entrada/salida
				System.out.println("Error al escribir los datos en el fichero.");
			}
		}

	}

}
