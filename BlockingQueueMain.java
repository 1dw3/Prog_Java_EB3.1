package evaluacion3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ProductorBlockingQueue implements Runnable{
	private final BlockingQueue<Integer> fila;
	
	public ProductorBlockingQueue(BlockingQueue<Integer> q) {
		fila = q;
	}
	
	@Override
	public void run() {
		try{
			int val=0;
			boolean flag=true;
			while(flag){
				Thread.sleep(1333);
				if(val>1000){
					flag=false;
				}
				fila.put(val);
				val++;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}

class ConsumidorBlockingQueue implements Runnable{

	private final BlockingQueue<Integer> fila;
	private final String hiloNombre;
	
	public ConsumidorBlockingQueue(BlockingQueue<Integer> q,String nom) {
		fila = q;
		hiloNombre = nom;
	}
	
	public void run(){
		try{
			boolean flag=true;
			int con=0;
			while(flag){
				consumir(fila.take());
				if(con>400){
					flag=false;
				}
				con++;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	void consumir(Object x) throws InterruptedException{
		System.out.println("Consumiendo "+hiloNombre+" Valor de la fila: "+x);
		Thread.sleep(1000);
	}
}

public class BlockingQueueMain {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BlockingQueue<Integer> fila = new ArrayBlockingQueue<Integer>(1000);
		ProductorBlockingQueue p=new ProductorBlockingQueue(fila);
		ConsumidorBlockingQueue c1=new ConsumidorBlockingQueue(fila, "Hilo 1");
		ConsumidorBlockingQueue c2=new ConsumidorBlockingQueue(fila, "Hilo 2");
		
		new Thread(p).start();
		new Thread(c1).start();
		new Thread(c2).start();

	}
}
