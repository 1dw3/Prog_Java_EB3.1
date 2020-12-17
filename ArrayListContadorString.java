package ebaluaketa3;

import java.util.ArrayList;

public class ArrayListContadorString {

	public static void main(String[] args) {
		
		//creo unos elementos de prueba
		ContadorGenerico<String> cgs1 = new ContadorGenerico<String>("1",1);
		ContadorGenerico<String> cgs2 = new ContadorGenerico<String>("2",2);
		ContadorGenerico<String> cgs3 = new ContadorGenerico<String>("3",3);
		ContadorGenerico<String> cgs4 = new ContadorGenerico<String>("4",4);
		ContadorGenerico<String> cgs5 = new ContadorGenerico<String>("5",5);
		
		// creo el ArrayList
		ArrayList<ContadorGenerico<String>> arrayListContador = new ArrayList<ContadorGenerico<String>>();
		
		// añado los elementos de prueba al ArrayList
		arrayListContador.add(cgs1);
		arrayListContador.add(cgs2);
		arrayListContador.add(cgs3);
		arrayListContador.add(cgs4);
		arrayListContador.add(cgs5);
		
		// muestro el contenido del ArrayList
		for (int posicion=0; posicion < arrayListContador.size(); posicion ++){
			System.out.println(arrayListContador.get(posicion));	
		}

	}

}
