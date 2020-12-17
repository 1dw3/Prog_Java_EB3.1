package evaluacion3;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ChatCliente extends Thread{
	private final BlockingQueue<String> colaEscritura;
	private final BlockingQueue<String> colaLectura;
	private String nombre;
	
	public ChatCliente(String n,BlockingQueue<String> bqEscritura,BlockingQueue<String> bqLectura) {
		this.nombre = n;
		colaEscritura = bqEscritura;
		colaLectura = bqLectura;
	}
	
	@Override
	public void run() {
		// creo un nuevo thread para que se encargue de la escritura
		ChatClienteEscritura clienteEscritura = new ChatClienteEscritura(this.nombre,colaEscritura);
		// creo un nuevo thread para que se encargue de la lectura
		ChatClienteLectura clienteLectura = new ChatClienteLectura(this.nombre,colaLectura);
		
		try{
			clienteEscritura.start();
			clienteLectura.start();
			while(clienteEscritura.isAlive() || clienteLectura.isAlive()){
				// espero a que finalicen los hilos de lectura y escritura
				
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
}
// clase para los hilos que leen de la cola
class ChatClienteLectura extends Thread{
	private final BlockingQueue<String> colaLectura;
	private String nombre;
	
	public ChatClienteLectura(String n,BlockingQueue<String> bqLectura) {
		colaLectura = bqLectura;
		this.nombre=n;
	}
	
	@Override
	public void run() {
		String mensaje="";
		try {
			// cojo el mensaje de la cola
			mensaje = this.colaLectura.take();
			while (!mensaje.equals("fin")){
				// mientras el otro cliente no escriba fin
				// muestro el mensaje por pantalla
				System.out.println(this.nombre+": "+mensaje);
				// cojo otro mensaje de la cola
				mensaje = this.colaLectura.take();
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}

//clase para los hilos que escriben en una cola
class ChatClienteEscritura extends Thread{
	private final BlockingQueue<String> colaEscritura;
	private String nombre;
	
	public ChatClienteEscritura(String n,BlockingQueue<String> bqEscritura) {
		colaEscritura = bqEscritura;
		this.nombre=n;
	}

	@Override
	public void run() {
		String mensaje="";
		//defino un objeto de la clase Scanner y de nombre teclado
		Scanner teclado = new Scanner(System.in);
		try {
			// el mensaje fin tambien se mete en la cola
			System.out.println(this.nombre+": ");
			// leo el mensaje del teclado
			mensaje = teclado.nextLine();
			// pongo el mensaje en la cola de escritura
			colaEscritura.put(mensaje);
			while (!mensaje.equals("fin")){
				// leo el mensaje del teclado
				mensaje = teclado.nextLine();
				// pongo el mensaje en la cola de escritura
				colaEscritura.put(mensaje);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		// cierro el Scanner
		teclado.close();
	}
}

// clase BlockingQueueChat2Clientes
public class BlockingQueueChat2Clientes {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// cola donde escribe el cliente1 y lee el cliente2
		BlockingQueue<String> bq1 = new ArrayBlockingQueue<String>(100);
		// cola donde escribe el cliente2 y lee el cliente1
		BlockingQueue<String> bq2 = new ArrayBlockingQueue<String>(100);
		
		ChatCliente cliente1 = new ChatCliente("Cliente1",bq1,bq2);
		ChatCliente cliente2 = new ChatCliente("Cliente2",bq2,bq1);
		
		cliente1.start();
		cliente2.start();

	}
}
