package ebaluaketa3;

import java.util.ArrayList;

public class ArrayListKontatzaileaInteger extends kontatzailegenerikoa{

	public static void main(String[] args) {
		
		//Objektuak sortu
		kontatzailegenerikoa<Integer> kg1 = new kontatzailegenerikoa<Integer>(1,0);
		kontatzailegenerikoa<String> kg2 = new kontatzailegenerikoa<String>("Katea1",0);
		kontatzailegenerikoa<Double> kg3 = new kontatzailegenerikoa<Double>(3.0,0);
		kontatzailegenerikoa<Integer> kg4 = new kontatzailegenerikoa<Integer>(4,0);
		kontatzailegenerikoa<Integer> kg5 = new kontatzailegenerikoa<Integer>(5,0);
		
		// ArrayList sortu
		ArrayList<kontatzailegenerikoa> arrayListKontatzailea = 
				new ArrayList<kontatzailegenerikoa>();
		
		
		arrayListKontatzailea.add(kg1);
		arrayListKontatzailea.add(kg2);
		arrayListKontatzailea.add(kg3);
		arrayListKontatzailea.add(kg4);
		arrayListKontatzailea.add(kg5);
		
		
		
		/*kontatzailegenerikoa<Integer> kg10 = new kontatzailegenerikoa<Integer>();
		for (int i=0; i<5;i++){
			 kg10.setBalioa(i+1);
			 arrayListKontatzailea.add(kg1);
		} */
		
			
		
		
		// Objektuak arraylistean sartu
		
		
		// Arraylista aurkeztu
		for (int pos=0; pos < arrayListKontatzailea.size(); pos ++){
			System.out.println(arrayListKontatzailea.get(pos));	
		}

	}

}
