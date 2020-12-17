package evaluacion3;

import java.util.ArrayList;

public class ArrayListContadorInteger {

	public static void main(Integer[] args) {
		
		//creo unos elementos de prueba
		ContadorGenerico<Integer> cgs1 = new ContadorGenerico<Integer>(1,1);
		ContadorGenerico<Integer> cgs2 = new ContadorGenerico<Integer>(2,2);
		ContadorGenerico<Integer> cgs3 = new ContadorGenerico<Integer>(3,3);
		ContadorGenerico<Integer> cgs4 = new ContadorGenerico<Integer>(4,4);
		ContadorGenerico<Integer> cgs5 = new ContadorGenerico<Integer>(5,5);
		
		// creo el ArrayList
		ArrayList<ContadorGenerico<Integer>> arrayListContador = new ArrayList<ContadorGenerico<Integer>>();
		
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
