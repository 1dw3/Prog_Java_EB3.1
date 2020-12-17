package evaluacion3;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierAutobus {
  public static void main(String[] args) {
    int numeroPasajeros = 56;
    final CyclicBarrier barreraInicio = new CyclicBarrier(numeroPasajeros + 1);
    final CyclicBarrier barreraFin = new CyclicBarrier(numeroPasajeros + 1);

    for (int i = 0; i < numeroPasajeros; i++) {
        Thread hilo = new Thread() {
            public void run() {
                try {            	
                	// el pasajero espera hasta que lleguen los otros pasajeros
                  barreraInicio.await();
                  System.out.println("Subiendo al autobús ...");
                  barreraFin.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        hilo.start();
    }

    try {
        System.out.println("Esperando a que lleguen todos los pasajeros.");
        barreraInicio.await();
        barreraFin.await();
        System.out.println("Autobús Completo. En Marcha ...");
    } catch (Exception e) {
        e.printStackTrace();
    }

}

}