package eb3;


import java.util.concurrent.TimeUnit;

public class HariaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Hariak sortu Haria1 eta Haria2 klasekoak
		Haria1 H11=new Haria1("Haria11");
		Haria1 H12=new Haria1("Haria12");
		Haria2 H21=new Haria2("Haria21");
		Haria2 H22=new Haria2("Haria22");
		
		//Hariak abian jarri
		H11.start();
		H12.start();
		H21.start();
		H22.start();
		
		
		
		
		
		
		

	}

}
