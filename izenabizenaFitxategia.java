package ebaluaketa3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class izenabizenaFitxategia {

	public static void main(String[] args) {
		

		// izenak eskatzen ditu eta gordeko ditu izenak.txt fitxategian 
		// Kate hutsa sartu arte
		// Amaitzean, fitxategia pantailatik aterako du
		
		// Izenak fitxategian idatzi
		// Skanner klaseko objektu bat deklaratu
		// Skanner klaseko objektu bat deklaratu
		Scanner teklatua = new Scanner(System.in);
		try {
			File fitxategiairakurri = null;
			FileReader fr = null;
			BufferedReader br = null;
			fitxategiairakurri = new File ("izenak.txt");
			fr = new FileReader (fitxategiairakurri);
			br = new BufferedReader(fr);
			// fitxategiaren edukia atera
			System.out.println("Fitxategiaren edukia");
			String lerroa=null;
			String izenafitx=null;
			boolean badago=false;
			System.out.println("sartu izena: ");
			String izena=teklatua.nextLine();
			while((lerroa=br.readLine())!=null){
				int espazioa=lerroa.indexOf(" ");
				
				izenafitx=lerroa.substring(0, espazioa);
				
				if (izena.equals(izenafitx))
				{
					badago=true;
				}
				
			
			}
			if (badago){
				System.out.println("badago");
			}
			else 
				System.out.println("ez dago");
			
					
				// fitxategia itxi
			teklatua.close();	
		} catch (FileNotFoundException fnfe) {
			// Fitxategia ez baldin badu ikusten
			System.out.println("Errorea irakurtzean. Fitxategia ezin ireki");
			//fnfe.printStackTrace();
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
		}
		
		
		}
			
			
	}
	
