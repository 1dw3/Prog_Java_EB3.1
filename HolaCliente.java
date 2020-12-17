package ebaluaketa3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HolaCliente {
	private static int puerto = 8888;
    private static String ipServidor="127.0.0.1";
    
    public static void main(String[] args) {

        Socket socket = null;
        try {
            InetAddress inetAddress = InetAddress.getByName(ipServidor);
            
            socket = new Socket(inetAddress, puerto);
            System.out.println("Conectado al Servidor " + inetAddress + " en el Puerto " + puerto);
            
            // recibo los datos del servidor
            String datos;
            Scanner teclado = new Scanner(socket.getInputStream());
            datos = teclado.nextLine();
            
            // escribo el mensaje recibido
            System.out.println("Mensaje: "+datos);

            // cierro el teclado
            teclado.close();
        } catch (UnknownHostException ex) {
            Logger.getLogger(HolaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HolaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if( socket != null){
                try {
                    socket.close();
                } catch (IOException ex) {
                    Logger.getLogger(HolaCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
