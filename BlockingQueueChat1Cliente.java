package evaluacion3;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ChatClienteUnico extends Thread{
	private final BlockingQueue<String> colaEscritura;
	
	public ChatClienteUnico(BlockingQueue<String> bqEscritura) {
		colaEscritura = bqEscritura;
	}
	
	@Override
	public void run() {
		String mensaje="";
		//defino un objeto de la clase Scanner y de nombre teclado
		Scanner teclado = new Scanner(System.in);
		
		try{
			
			// leo el mensaje del teclado
			System.out.println("Escribe un mensaje: ");
			mensaje = teclado.nextLine();
			// lo escribo en la cola del servidor
			colaEscritura.put(mensaje);
			while(!mensaje.equals("fin")){
				// leo otro mensaje del teclado
				System.out.println("Escribe un mensaje: ");
				mensaje = teclado.nextLine();
				// lo escribo en la cola del servidor
				colaEscritura.put(mensaje);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		// cierro el Scanner
		teclado.close();
	}
}

// clase del Servidor / Monitor
public class BlockingQueueChat1Cliente {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// cola donde escribe el cliente1 y lee el servidor
		BlockingQueue<String> bq1 = new ArrayBlockingQueue<String>(100);
		// cola donde escribe el cliente2 y lee el cliente1
		//BlockingQueue<String> bq2 = new ArrayBlockingQueue<String>(100);
		
		ChatClienteUnico cliente1 = new ChatClienteUnico(bq1);
		
		cliente1.start();
		
		// leo mensajes de la cola
		String mensaje = "";
		try {
			mensaje = bq1.take();
			System.out.println("Mensaje Recibido: "+mensaje);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(!mensaje.equals("fin")){
			// mientras no llegue el mensaje fin
			try {
				mensaje = bq1.take();
				System.out.println("Mensaje Recibido: "+mensaje);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// muestro un mensaje de fin
		System.out.println("Fin del Programa.");
	}
}
