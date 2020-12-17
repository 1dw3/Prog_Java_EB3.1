package ebaluaketa3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class ArrayListKateakMenuFitxategia {

	public static void main(String[] args) {
		
		String katea;
		Scanner teklatua = new Scanner(System.in);
		ArrayList<String> arrayListString = new ArrayList<String>();
		
		int aukera;
		int posizioa;
		
		boolean aldatua = false;
		
		// fitxategia ireki irakurtzeko
		File fitxategia = null;
		FileReader fr = null;
		BufferedReader br = null;
		fitxategia = new File ("kateak.txt");
		
		try {
			fr = new FileReader (fitxategia);
			br = new BufferedReader(fr);
			// fitxategiaren edukia arraylistean sartu
			while((katea=br.readLine())!=null){
				arrayListString.add(katea);
			}
			// file reader itxi
			br.close();
			fr.close();
			
			
			// datuak kargatuta
			System.out.println("Datuak irakurrita.");
			
		} catch (FileNotFoundException e) {
			// fitxategia ez baldin badago
			System.out.println("fitxategia ezin ireki.");
		} catch (IOException e) {
			// io salbuespena
			System.out.println("Datuak irakurtzean errorea.");
		}
		
		do {
			
			// menua atera
			System.out.println("1. Katea gehitu");
			System.out.println("2. Katea bilatu");
			System.out.println("3. Katea ezabatu");
			System.out.println("4. Kateak zerrendatu");
			System.out.println("0. Irten");
			//  aukera irakurri
			System.out.print("aukera: ");
			aukera=teklatua.nextInt();
			//  \r y \n bufferretik kendu
			teklatua.nextLine();
			
			//  aukerak kontrolatu
			switch (aukera){
			case 1:
				// Gehitu
				// katea irakurri
				System.out.print("Katea sartu: ");
				katea = teklatua.nextLine();
				
				// ArrayListean sartu
				arrayListString.add(katea);
				
				//aldatua jarri
				aldatua = true;
				break;
			case 2:
				// Bilatu
				// katea irakurri
				System.out.print("Katea sartu: ");
				katea = teklatua.nextLine();
				// Arraylistean bilatu
				if (arrayListString.contains(katea)){
					// arrayan baldin badago
					// posizioa lortu
					posizioa = arrayListString.indexOf(katea);
					System.out.println( katea + " elementua " + posizioa+" posizioan dago ");
				}
				else {
					// arrayan ez baldin badago
					// errorea
					System.out.println(katea+ " elementua ez dago arrayan.");
				}
				break;
			case 3:
				// Ezabatu
				// katea irakurri
				System.out.print("Katea sartu: ");
				katea = teklatua.nextLine();
				// Arraylistean bilatu
				if (arrayListString.contains(katea)){
					// arrayan baldin badago
					// ezabatu
					arrayListString.remove(katea);
					System.out.println( katea + "elementua ezabatua.");
					// aldatua
					aldatua = true;
				}
				else {
					// arrayan ez baldin badago
					// errorea
					System.out.println( katea + " Elementua ez dago arrayan.");
				}
				
				break;			
			case 4:
				// zerrendatu
				if(arrayListString.isEmpty()){
					// elementurik ez baldin badago
					// errorea
					System.out.println("Arraya hutsik dago.");
				}
				else {
					//  elementurik baldin badago
					// atera
					for (posizioa=0; posizioa < arrayListString.size(); posizioa ++){
						System.out.println(arrayListString.get(posizioa));	
					}
				}
				break;
			case 0:
				// agurra
				System.out.println("Agur.");
				break;
			default:
				// aukera ez egokia
				System.out.println("Errorea, aukera ez egokia.");
			}// switch amaiera
		}while (aukera != 0);
			
		// Teklatua itxi
		teklatua.close();
		
		// datuak aldatu baldin badira
		if (aldatua){
			// fitxategian gorde
			FileWriter fw = null;
			PrintWriter pw = null;
			try {
				fw = new FileWriter("kateak.txt");
				pw = new PrintWriter(fw);
				// Arraylisteko datuak fitxategira
				for(posizioa=0;posizioa < arrayListString.size();posizioa++){
					katea = arrayListString.get(posizioa);
					pw.println(katea);
				}
				
				// FileWriter itxi
				pw.close();
				fw.close();
				
				// informazioa eman
				System.out.println("Datuak gordeta.");
				
			} catch (IOException e) {
				// io salbuespena
				System.out.println("Datuak ezin gorde. Errorea.");
			}	
		}
	}

}
