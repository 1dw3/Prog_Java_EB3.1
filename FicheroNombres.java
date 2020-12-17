package ebaluaketa3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FicheroNombres {

	public static void main(String[] args) {
		// solicita nombres que va guardando en un fichero de texto de nombre nombres.txt 
		// hasta que se introduzca una cadena en blanco ("") que no se guarda. 
		// Después muestra el contenido del fichero por pantalla
		
		// escribo los nombres en el fichero
		try {
			FileWriter fichero = null;
			PrintWriter pw = null;
			fichero = new FileWriter("nombres.txt");
			pw = new PrintWriter(fichero);
			// defino un objeto de la clase Scanner y de nombre teclado
			Scanner teclado = new Scanner(System.in);
			// leo un nombre
			String nombre=null;
			System.out.print("Introduzca un nombre (nombre en blanco para fin): ");
			nombre=teclado.nextLine();
			while(!nombre.equals("")){
				// mientras no sea un nombre en blanco
				// lo escribo en el fichero
				pw.println(nombre);
				//System.out.println("Nombre: "+nombre);
				// leo otro nombre
				System.out.print("Introduzca un nombre (nombre en blanco para fin): ");
				nombre=teclado.nextLine();
			}
			// cierro el teclado
			teclado.close();
			// cierro el fichero
			fichero.close();
		} catch (IOException ioe) {
			// captura las excepciones de entrada / salida
			ioe.printStackTrace();
		}
		
		// leo los nombres desde el fichero
		
		try {
			File archivo = null;
			FileReader fr = null;
			BufferedReader br = null;
			archivo = new File ("nombres.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
			// muestro el contenido del fichero
			System.out.println("Contenido del Fichero");
			String linea=null;
			while((linea=br.readLine())!=null){
			System.out.println(linea);
			}
			
			// cierro el fichero
			fr.close();
		} catch (FileNotFoundException fnfe) {
			// si no encuentra la ruta del archivo
			System.out.println("Error. Archivo No Encontrado");
			//fnfe.printStackTrace();
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
		}
		
		
	}

}
