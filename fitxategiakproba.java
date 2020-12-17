package ebaluaketa3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class fitxategiakproba {

	public static void main(String[] args) {
		
				
					FileWriter fitxategiaidatzi = null;
					PrintWriter pw = null;
					fitxategiaidatzi = new FileWriter("izenak.txt");
					pw = new PrintWriter(fitxategiaidatzi);
				
					
					// Skanner klaseko objektu bat deklaratu
					Scanner teklatua = new Scanner(System.in);
					// Izen bat irakurri
					String izena=null;
					System.out.print("Sartu izen bat(hutsa amaitzeko): ");
					izena=teklatua.nextLine();
					while(!izena.equals("")){
						// zuria ez den bitartean
						// fitxategian idatzi
						pw.println(izena);
						System.out.println("Izena: "+izena);
						// Beste izen bat irakurri
						System.out.print("Sartu izen bat(hutsa amaitzeko): ");
						izena=teklatua.nextLine();
					
					// teklatua itxi
					teklatua.close();
					// fitxategia itxi
					fitxategiaidatzi.close();
				
				// Izenak irakurri
				
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
					while((lerroa=br.readLine())!=null){
					System.out.println(lerroa);
					}
					
					// fitxategia itxi
					fr.close();
				} catch (FileNotFoundException fnfe) {
					// Fitxategia ez baldin badu ikusten
					System.out.println("Errorea. Fitxategia ezin jaso");
					//fnfe.printStackTrace();
				} catch (IOException ioe) {
					// TODO Auto-generated catch block
					ioe.printStackTrace();
				}
				
				
			}

		

	}
}


