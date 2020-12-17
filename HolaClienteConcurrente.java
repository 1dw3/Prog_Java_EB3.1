package evaluacion3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HolaClienteConcurrente {
	private static int puerto = 8888;
    private static String ipServidor="127.0.0.1";
    
    public static void main(String[] args) {

        Socket socket = null;
        try {
            InetAddress inetAddress = InetAddress.getByName(ipServidor);
            
            socket = new Socket(inetAddress, puerto);
            System.out.println("InetAddress: " + inetAddress);
            System.out.println("Port: " + puerto);
            
            // recibo los datos del servidor
            String datos;
            Scanner scanner = new Scanner(socket.getInputStream());
            datos = scanner.nextLine();
            
            // escribo el mensaje recibido
            System.out.println("Mensaje: "+datos);

            // cierro el Scanner
            scanner.close();
            
            // una vez recibido el mensaje
            // finaliza la ejecución del cliente
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(HolaClienteConcurrente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HolaClienteConcurrente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if( socket != null){
                try {
                    socket.close();
                } catch (IOException ex) {
                    Logger.getLogger(HolaClienteConcurrente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
