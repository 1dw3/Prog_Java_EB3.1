package evaluacion3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ProductorP1 implements Runnable{
	private final BlockingQueue<String> cola01;
	
	public ProductorP1(BlockingQueue<String> bq) {
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

class ProductorP2 implements Runnable{
	private final BlockingQueue<String> cola02;
	
	public ProductorP2(BlockingQueue<String> bq) {
		cola02 = bq;
	}
	
	@Override
	public void run() {
		try{
			String valor = "P02";
			int numeroPieza = 1;
			while(numeroPieza <= 100){
				// espero un tiempo
				Thread.sleep(1333);
				// pongo el valor en la cola
				cola02.put(valor);
				numeroPieza++;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
class ProductorP3 implements Runnable{

	private final BlockingQueue<String> cola01;
	private final BlockingQueue<String> cola02;
	
	public ProductorP3(BlockingQueue<String> bq1,BlockingQueue<String> bq2) {
		this.cola01 = bq1;
		this.cola02 = bq2;
	}
	
	public void run(){
		try{
			String valor = "";
			int numeroPieza = 1;
			while(numeroPieza <= 100){
				// cojo el elemento de cola01
				valor = this.cola01.take();
				// cojo el elemento de cola02 y lo añado al anterior
				valor = valor + this.cola02.take();
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
public class BlockingQueueCadenaProduccion2P1C {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BlockingQueue<String> bq1 = new ArrayBlockingQueue<String>(100);
		BlockingQueue<String> bq2 = new ArrayBlockingQueue<String>(100);
		ProductorP1 p01 = new ProductorP1(bq1);
		ProductorP2 p02 = new ProductorP2(bq2);
		ProductorP3 p03 = new ProductorP3(bq1,bq2);
		
		new Thread(p01).start();
		new Thread(p02).start();
		new Thread(p03).start();

	}
}
