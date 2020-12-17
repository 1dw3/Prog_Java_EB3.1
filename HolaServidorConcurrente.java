package evaluacion3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HolaServidorConcurrente {
    private static int puerto = 8888;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        
        System.out.println("Port: " + puerto);

        Socket socket = null;
        try {
            serverSocket = new ServerSocket(puerto);
            int numeroCliente = 1;
            while (true){
            	// Acepto peticiones de múltiples clientes
	            socket = serverSocket.accept();
	            
	            // creo un nuevo hilo de ejecucion o thread por cada cliente conectado
	            // este thread contiene dentro de su metodo run el codigo que se ejecuta en el servidor por cada cliente
	            
	            Thread t = new ThreadHolaServidorConcurrente(socket,numeroCliente);
	            
	            // ejecuto el nuevo hilo de ejecucion
	            t.start();
	            
	            // Incremento el número de cliente
	            numeroCliente++;
            }
        } catch (IOException ex) {
            Logger.getLogger(HolaServidorConcurrente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ex) {
                    Logger.getLogger(HolaServidorConcurrente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }
}

