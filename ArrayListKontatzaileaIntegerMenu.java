package ebaluaketa3;

import java.util.Scanner;
import java.util.ArrayList;

public class ArrayListKontatzaileaIntegerMenu {

	public static void main(String[] args) {
		
		//String katea;
		int osoa;
		kontatzailegenerikoa<Integer> cgi = new kontatzailegenerikoa<Integer>();
		Scanner teklatua = new Scanner(System.in);
		ArrayList<kontatzailegenerikoa<Integer>> arrayListKontatzailea = new ArrayList<kontatzailegenerikoa<Integer>>();
		
		int aukera;
		int pos;
		boolean aurkitu;
		
		do {
			
			// menua atera
			System.out.println("1. Osoa gehitu");
			System.out.println("2. Osoa bilatu");
			System.out.println("3. Osoa ezabatu");
			System.out.println("4. Osoak atera");
			System.out.println("0. Irten");
			// Aukera hartu
			System.out.print("Aukera: ");
			aukera=teklatua.nextInt();
			// \r y \n karaktereak bufferetik kendu
			//teclado.nextLine();
			
			// aukerak
			switch (aukera){
			case 1:
				// gehitu
				// osoa irakurri
				System.out.print("Sartu osoa: ");
				osoa = teklatua.nextInt();
				// ArrayListean bilatu
				for (pos=0;pos < arrayListKontatzailea.size();pos++){
					if (osoa == arrayListKontatzailea.get(pos).getBalioa()){
						// arrayan badago
						// kontatzailea gehitu
						arrayListKontatzailea.get(pos).setKontatzailea(
								arrayListKontatzailea.get(pos).
								getKontatzailea() + 1);
						// ezin da balio errepikatua egon
						break;
					}
				}
				if (pos == arrayListKontatzailea.size()){
					// Ez badago arraylistean
					// Beste berri bat sortuko dut
					cgi = new kontatzailegenerikoa<Integer>(osoa,1);
					// elementua arraylistean sartu
					arrayListKontatzailea.add(cgi);
				}
				
				break;
			case 2:
				// Bilatu
				// osoa irakurri
				System.out.print("Introduzca un Entero: ");
				osoa = teklatua.nextInt();
				// Arraylistean irakurri
				aurkitu=false;
				for (pos=0;pos< arrayListKontatzailea.size();pos++){
					if (osoa == arrayListKontatzailea.get(pos).getBalioa()){
						// si se encuentra en el array
						bilatu=true;
						System.out.println(  osoa +"Elementua: " + pos +" posizioan dago" );
						break;
					}
				}
				if (aurkitu==false){
					// Ez badago arrayan
					// errorea
					System.out.println(osoa+ " elementua ez da sartu  " );
				}
				break;		
			case 3:
				// Ezabatu
				// osoa irakurri
				System.out.print("Sartu osoa: ");
				osoa = teklatua.nextInt();
				// Arraylistean bilatu
				aurkitu=false;
				for (pos=0;pos < arrayListKontatzailea.size();pos++){
					if (osoa == arrayListKontatzailea.get(pos).getBalioa()){
						// si se encuentra en el array
						aurkitu=true;
						// la borro
						arrayListKontatzailea.get(pos).setKontatzailea
						(arrayListKontatzailea.get(pos).getKontatzailea()-1);
						System.out.println( osoa + " Elementua ezabatua.");
						break;
					}
				}
				if (aurkitu==false){
					// ez badago arrayan
					// errorea
					System.out.println(osoa + " ez dago arrayan.");
				}
				break;
			case 4:
				// zerrendatu
				if(arrayListKontatzailea.isEmpty()){
					// ez baldin badago elementurik
					// muestro un mensaje de error
					System.out.println("Arraya hutsik dago.");
				}
				else {
					// elementurik badago
					// zerrendatu
					for (pos=0; pos < arrayListKontatzailea.size(); pos ++){
						System.out.println(arrayListKontatzailea.get(pos));	
					}
				}
				break;
			case 0:
				// Agur
				System.out.println("Agur.");
				break;
			default:
				// aukera okerra bada
				System.out.println("Errorea. Aukera ezegokia");
			}// switch_amaiera
		}while (aukera != 0);
			
		// Scannera itxi
		teklatua.close();

	}

}
