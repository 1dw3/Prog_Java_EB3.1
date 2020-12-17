package evaluacion3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Productor01 implements Runnable{
	private final BlockingQueue<String> cola01;
	
	public Productor01(BlockingQueue<String> bq) {
		cola01 = bq;
	}
	
	@Override
	public void run() {
		try{
			String valor = "P01";
			int numeroPieza = 1;
			while(numeroPieza <= 100){
				// espero un tiempo
				Thread.sleep(1333);
				// pongo el valor en la cola
				cola01.put(valor);
				numeroPieza++;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}

class Productor02 implements Runnable{

	private final BlockingQueue<String> cola01;
	private final BlockingQueue<String> cola02;
	//private final String hiloNombre;
	
	public Productor02(BlockingQueue<String> bq1, BlockingQueue<String> bq2) {
		this.cola01 = bq1;
		this.cola02 = bq2;
	}
	
	public void run(){
		try{
			int numeroPieza = 1;
			String valor = "";
			while(numeroPieza <= 100){
				// genero 100 piezas
				// cojo el elemento de cola01
				valor = this.cola01.take();
				// lo modifico
				valor = valor + "P02";
				// lo pongo en cola02
				cola02.put(valor);
				
				numeroPieza++;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
class Productor03 implements Runnable{

	private final BlockingQueue<String> cola02;
	
	public Productor03(BlockingQueue<String> bq2) {
		this.cola02 = bq2;
	}
	
	public void run(){
		try{
			String valor = "";
			int numeroPieza = 1;
			while(numeroPieza <= 100){
				// cojo el elemento de cola02
				valor = this.cola02.take();
				// lo modifico
				valor = valor + "P03";
				// lo muestro por pantalla
				System.out.println("Pieza Número: "+ numeroPieza + " Valor: "+valor);
				numeroPieza++;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
public class BlockingQueueCadenaProduccion {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BlockingQueue<String> bq1 = new ArrayBlockingQueue<String>(100);
		BlockingQueue<String> bq2 = new ArrayBlockingQueue<String>(100);
		Productor01 p01 = new Productor01(bq1);
		Productor02 p02 = new Productor02(bq1,bq2);
		Productor03 p03 = new Productor03(bq2);
		
		new Thread(p01).start();
		new Thread(p02).start();
		new Thread(p03).start();

	}
}
