package evaluacion3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class ComplejoMainSerializable {

	public static void main(String[] args) {
		// crea un objeto de la clase Complejo y lo guarda en el fichero complejos.dat. 
		// Después lee los datos del complejo desde complejos.dat y 
		// muestra el valor del complejo leído por pantalla.
		
		Complejo c = new Complejo(3.0,5.0);
		
		try {
			// grabo los datos en complejos.dat
			FileOutputStream fos=new FileOutputStream("complejos.dat");
			ObjectOutputStream oos = new ObjectOutputStream (fos);	
			
			// lo grabo
			oos.writeObject(c);

			// cierro el fichero 		
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// leo los datos desde complejos.dat
		try {
			FileInputStream fis=new FileInputStream("complejos.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			// convierte los bytes leídos en un objeto de la clase Complejo
			c = (Complejo)ois.readObject(); 
			
			ois.close(); 		
			// muestro los datos leidos
			System.out.println("Complejo: "+c);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
	}
}
