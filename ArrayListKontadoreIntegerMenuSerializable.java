package ebaluaketa3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.ArrayList;

public class ArrayListKontadoreIntegerMenuSerializable {

		@SuppressWarnings("unchecked")
		public static void main(String[] args) {
		
		//String cadena;
		int entero;
		kontatzailegenerikoa<Integer> kgi = new kontatzailegenerikoa<Integer>();
		Scanner teklatua = new Scanner(System.in);
		ArrayList<kontatzailegenerikoa<Integer>> arrayListKontadore = new ArrayList<kontatzailegenerikoa<Integer>>();
		
		int aukera;
		int posizioa;
		boolean aurkitua;
		
		boolean aldatua = false;
		
		// cargo los datos desde el fichero
		// leo los datos desde contadorinteger.dat
		try {
			FileInputStream fis=new FileInputStream("kontadoreinteger.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
							
			// mientras que no sea el final del fichero leo los datos
			while(fis.available() > 0){
				kgi = (kontatzailegenerikoa<Integer>)ois.readObject();
				// añado el objeto leido al nuevo ArrayList
				arrayListKontadore.add(kgi);
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
			// leo la aukera
			System.out.print("aukera: ");
			aukera=teklatua.nextInt();
			// limpio los caracteres \r y \n del buffer
			//teclado.nextLine();
			
			// controlo las aukeraes
			switch (aukera){
			case 1:
				// Añadir
				// leo un entero
				System.out.print("Introduzca un Entero: ");
				entero = teklatua.nextInt();
				// lo busco en el ArrayList
				for (posizioa=0;posizioa < arrayListKontadore.size();posizioa++){
					if (entero == arrayListKontadore.get(posizioa).getBalioa()){
						// si se encuentra en el array
						// incremento el contador
						arrayListKontadore.get(posizioa).setBalioa(arrayListKontadore.get(posizioa).getKontatzailea() + 1);
						// como no puede haber un valor repetido salgo del bucle
						break;
					}
				}
				if (posizioa == arrayListKontadore.size()){
					// si no se encuentra en el ArrayList
					// creo un nuevo elemento con los datos
					kgi = new kontatzailegenerikoa<Integer>(entero,1);
					// añado el elemento al ArrayList
					arrayListKontadore.add(kgi);
				}
				// actualizo el valor de aldatua
				aldatua = true;
				break;
			case 2:
				// Buscar
				// leo un entero
				System.out.print("Introduzca un Entero: ");
				entero = teklatua.nextInt();
				// lo busco en el ArrayList
				aurkitua=false;
				for (posizioa=0;posizioa < arrayListKontadore.size();posizioa++){
					if (entero == arrayListKontadore.get(posizioa).getBalioa()){
						// si se encuentra en el array
						aurkitua=true;
						System.out.println("El elemento " + entero + " se encuentra en la posición " + posizioa);
						break;
					}
				}
				if (aurkitua==false){
					// si NO se encuentra en el array
					// muestro un mensaje de error
					System.out.println("El elemento " + entero + " NO se encuentra en el array.");
				}
				break;		
			case 3:
				// Borrar
			// leo un entero
				System.out.print("Introduzca un Entero: ");
				entero = teklatua.nextInt();
				// la busco en el ArrayList
				aurkitua=false;
				for (posizioa=0;posizioa < arrayListKontadore.size();posizioa++){
					if (entero == arrayListKontadore.get(posizioa).getBalioa()){
						// si se encuentra en el array
						aurkitua=true;
						// la borro
						arrayListKontadore.remove(posizioa);
						System.out.println("El elemento " + entero + " ha sido borrado.");
						break;
					}
				}
				if (aurkitua==false){
					// si NO se encuentra en el array
					// muestro un mensaje de error
					System.out.println("El elemento " + entero + " NO se encuentra en el array.");
				}
				// actualizo el valor de aldatua
				aldatua = true;
				break;
			case 4:
				// listar
				if(arrayListKontadore.isEmpty()){
					// si NO hay elementos en el array
					// muestro un mensaje de error
					System.out.println("El array está vacío.");
				}
				else {
					// si hay elementos en el array
					// los muestro
					for (posizioa=0; posizioa < arrayListKontadore.size(); posizioa ++){
						System.out.println(arrayListKontadore.get(posizioa));	
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
		}while (aukera != 0);
			
		// cierro el Scanner
		teklatua.close();
		
		// si los datos han sido aldatuas los grabo
		if (aldatua){
			try {
				// grabo los datos 
				FileOutputStream fos=new FileOutputStream("kontadoreinteger.dat");
				ObjectOutputStream oos = new ObjectOutputStream (fos);	
				
				// recorro el ArrayList guardando los datos
				
				for(posizioa=0;posizioa < arrayListKontadore.size();posizioa++){
					// grabo el objeto de esa posizioa
					
					
					kgi=arrayListKontadore.get(posizioa);
					System.out.println(kgi);
					oos.writeObject(kgi);
					
				}
				// cierro el fichero 		
				oos.close();
			} catch (IOException e) {
				// si se produce una excepcion de entrada/salida
				System.out.println("Datuak idaztean errorea.");
			}
		}

	}

}
