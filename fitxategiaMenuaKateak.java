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

public class fitxategiaMenuaKateak {

	public static void main(String[] args) {
		
		String katea;
		Scanner teklatua = new Scanner(System.in);
		ArrayList<String> arrayListKateak = new ArrayList<String>();
		
		int aukera;
		int posizioa;
		
		boolean aldatua = false;
		
		// fitxategia ireki irakurtzeko
		// File fitxategia = null;
		// FileReader fr = null;
		// BufferedReader br = null;
		// fitxategia = new File ("kateak.txt");
		
		try {
			File fitxategia = new File ("kateak.txt");
			FileReader fr = new FileReader (fitxategia);
			BufferedReader br = new BufferedReader(fr);
			// fitxategiaren edukia arraylistera pasatu
			while((katea=br.readLine())!=null){
				arrayListKateak.add(katea);
			}
			// FileReader itxi
			br.close();
			fr.close();
			
			
			// informatzeko mezua
			System.out.println("Datuak jasota.");
			
		} catch (FileNotFoundException e) {
			// fitxategia ez baldin badago
			System.out.println("Fitxategia zabaltzean errorea.");
		} catch (IOException e) {
			// S/I salbuespena sortzen bada
			System.out.println("Datuak jasotzen errorea.");
		}
		
		do {
			
			// menua atera
			System.out.println("1. Katea gehitu");
			System.out.println("2. Katea bilatu");
			System.out.println("3. Katea ezabatu");
			System.out.println("4. Kateak zerrendatu");
			System.out.println("0. Irten");
			// Aukera irakurri
			System.out.print("Aukera: ");
			aukera=teklatua.nextInt();
			// \r eta \n karaktereak bufferretik kendu 
			teklatua.nextLine();
			
			// aukerak kudeatu
			switch (aukera){
			case 1:
				// Gehitu
				// katea irakurri
				System.out.print("Sartu katea: ");
				katea = teklatua.nextLine();
				
				// Arraylistean gehitu
				arrayListKateak.add(katea);
				
				//Aldatu dela adierazi
				aldatua = true;
				break;
			case 2:
				// Bilatu
				// katea irakurri
				System.out.print("Sartu katea: ");
				katea = teklatua.nextLine();
				//  ArrayListean bilatu
				if (arrayListKateak.contains(katea)){
					// Baldin  badago
					// posizioa jaso
					posizioa = arrayListKateak.indexOf(katea);
					System.out.println( katea + " elementua " + posizioa +"posizioan dago");
				}
				else {
					// Ez baldin badago
					// Errorea
					System.out.println(katea + " elementua " + "ez dago fitxategian");
				}
				break;
			case 3:
				// Ezabatu
				//  katea irakurri
				System.out.print("Sartu katea: ");
				katea = teklatua.nextLine();
				// ArrayListean bilatu
				if (arrayListKateak.contains(katea)){
					// arrayan baldin badago
					// Ezabatu
					arrayListKateak.remove(katea);
					System.out.println( katea + " elementua ezabatua.");
					//aldatua balioa aldatuta
					aldatua = true;
				}
				else {
					// Arrayan ez badago
					// Errorea
					System.out.println( katea + " Elementua ez dago fitxategian.");
				}
				
				break;			
			case 4:
				// Zerrendatu
				if(arrayListKateak.isEmpty()){
					// Ez baldin badago elementurik
					// Errorea
					System.out.println("Fitxategia hutsik dago.");
				}
				else {
					// Arrayan elementurik baldin badago
					// aurkeztu
					for (posizioa=0; posizioa < arrayListKateak.size(); posizioa ++){
						System.out.println(arrayListKateak.get(posizioa));	
					}
				}
				break;
			case 0:
				// Agur mezua
				System.out.println("Agur.");
				break;
			default:
				// si se introduce una opción incorrecta
				System.out.println("Errorea. Aukera desegokia.");
			}// switch_amaiera
		}while (aukera != 0);
			
		// Scannerra itxi
		teklatua.close();
		
		// datuak aldatu baldin badira
		if (aldatua){
			// aldatu baldin badira, fitxategia idatzi
			FileWriter fw = null;
			PrintWriter pw = null;
			try {
				fw = new FileWriter("kateak.txt");
				pw = new PrintWriter(fw);
				// fitxategia idatzi arraylistetik
				for(posizioa=0;posizioa < arrayListKateak.size();posizioa++){
					katea = arrayListKateak.get(posizioa);
					pw.println(katea);
				}
				
				//  FileWriter itxi
				pw.close();
				fw.close();
				
				// Mezua
				System.out.println("Datuak gordeta.");
				
			} catch (IOException e) {
				// S\I salbuespena ematen baldin bada
				System.out.println("Errorea datuak idaztean.");
			}	
		}
	}

}
