package evaluacion3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FicheroCopia {

	public static void main(String[] args) {
		// copia el fichero origen de nombre logo.png en el fichero destino de nombre logocopia.png.
		// Para ello usa un array de tipo byte con 512 posiciones. 
		// Una vez copiado, abre el fichero de imagen logocopia.png para comprobar que la copia se ha realziado correctamente.
		
		// escribo los nombres en el fichero en modo binario
		FileInputStream fileInput = null;
		BufferedInputStream bufferedInput = null;
		
		FileOutputStream fileOutput=null;
		BufferedOutputStream bufferedOutput = null;
		
		byte [] datos = null;
		
		try {
			// fichero origen
			fileInput = new FileInputStream("logo.png");
			bufferedInput = new BufferedInputStream(fileInput);
			// fichero destino
			fileOutput = new FileOutputStream("logocopia.png");
			bufferedOutput = new BufferedOutputStream(fileOutput);	
		
			// copio el contenido del fichero
			datos = new byte[512];

			// mientras no sea fin de fichero
			while((bufferedInput.read(datos))!=-1){
				// copio los datos al fichero destino
				bufferedOutput.write(datos,0,512);
			}
			
			// cierro el fichero origen
			bufferedInput.close();
			// cierro el fichero destino
			bufferedOutput.close();
			
			// muestro un mensaje informativo
			System.out.println("Fichero Copiado con Éxito.");
			
		} catch (FileNotFoundException fnfe) {
			// si no encuentra la ruta del archivo
			System.out.println("Error. Archivo No Encontrado");
			//fnfe.printStackTrace();
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			// ioe.printStackTrace();
			System.out.println("Error al Copiar los Datos.");
		}
		
		
	}

}
