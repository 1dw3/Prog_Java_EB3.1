package evaluacion3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class ComplejoMainSerializableArrayList {

	public static void main(String[] args) {
		// crea cinco objetos de la clase Complejo y los almacena en un ArrayList. 
		// Después recorre el ArrayList guardando los datos de los objetos de tipo Complejo en el fichero alcomplejos.dat. 
		// Al finalizar lee los datos desde alcomplejos.dat y los almacena en un nuevo ArrayList. 
		// Para terminar recorre el ArrayList  mostrando el valor de los objetos de tipo Complejo almacenados en él.
		
		// creo cinco objetos de la clase Complejo
		Konplexu c1 = new Konplexu(3.0,1.0);
		Konplexu c2 = new Konplexu(7.0,5.0);
		Konplexu c3 = new Konplexu(2.0,3.0);
		Konplexu c4 = new Konplexu(5.0,7.0);
		Konplexu c5 =new Konplexu (1.2,3.2);
		
		c5=new Konplexu(1.2,3.2);
		
		
		// los almaceno en un ArrayList
		ArrayList<Konplexu> arrayListComplejos = new ArrayList<Konplexu>();
		
		arrayListComplejos.add(c1);
		arrayListComplejos.add(c2);
		arrayListComplejos.add(c3);
		arrayListComplejos.add(c4);
		arrayListComplejos.add(c5);
		
		try {
			// grabo los datos en alcomplejos.dat
			FileOutputStream fos=new FileOutputStream("alcomplejos.dat");
			ObjectOutputStream oos = new ObjectOutputStream (fos);	
			
			// recorro el ArrayList guardando los datos de los objetos de tipo Complejo en el fichero alcomplejos.dat
			
			for(int posicion=0;posicion < arrayListComplejos.size();posicion++){
				// grabo el objeto de la clase Complejo de esa posicion
				oos.writeObject(arrayListComplejos.get(posicion));
			}
			// cierro el fichero 		
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// leo los datos desde alcomplejos.dat
		try {
			FileInputStream fis=new FileInputStream("alcomplejos.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Konplexu c;
			
			// creo un nuevo ArrayList
			ArrayList<Konplexu> arrayListComplejosNuevo = new ArrayList<Konplexu>();
			
			// mientras que no sea el final del fichero leo los datos
			while(fis.available() > 0){
				c = (Konplexu)ois.readObject();
				// añado el objeto leido al nuevo ArrayList
				arrayListComplejosNuevo.add(c);
			}
			ois.close(); 		
			// muestro los datos leidos
			for(int posicion=0;posicion < arrayListComplejosNuevo.size();posicion++){
				// muestro el objeto de la clase Complejo de esa posicion
				System.out.println("Complejo: " + arrayListComplejosNuevo.get(posicion));
			}
			
		} catch (IOException e) {
		// si se produce una excepcion de entrada/salida
					System.out.println("Error al leer los datos del fichero.");
		} catch (ClassNotFoundException e) {
			// si no se reconoce la Clase a serializar
			System.out.println("Los datos de esta Clase no se pueden Serializar");
		}	
	
	}
}
