package ebaluaketa3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class izenabizenakFitxategia {

	public static void main(String[] args) {
		// izenak eskatuko ditu, izenak.txt fitxategian gordetzeko 
		// (" ") sartu arte. Kate hau ez da gordeko 
		// Gero, fitxategiaren edukia pantailatik aterako du
		
		
		int aukera=1;
		String izena;
		String abizena;
		
		//String izenabizena;
		// menua atera eta aukera hartu
		// scanner klaseko objektu bat sortu
		Scanner teklatua = new Scanner(System.in);
		while (aukera!=5){
			System.out.print("Izen abizenen fitxategia kudeatu \n");
			System.out.print("1.- izen-abizenak sartu\n");
			System.out.print("2.- izen-abizen guztiak ikusi\n");
			System.out.print("3.- bilaketa izenez\n");
			System.out.print("4.- bilaketa abizenez\n");
			System.out.print("Beste edozer, irten \n");
			aukera=teklatua.nextInt();
	
			
	     
			switch (aukera){
			case 1:
				try {
					FileWriter fitxategiaidatzi = null;
					PrintWriter pw = null;
					fitxategiaidatzi = new FileWriter("izenabizenak.txt");
					pw = new PrintWriter(fitxategiaidatzi);
					// izen bat irakurri
					izena=teklatua.nextLine();
					System.out.print("Sartu izena (hutsa amaitzeko): ");
					izena=teklatua.nextLine();
					while(!izena.equals("")){
						System.out.print("Sartu abizena: ");
						abizena=teklatua.nextLine();
						// fitxategian idatzi
						pw.println(izena+"."+abizena);
						//System.out.println("Izena: "+izena);
						// Beste izen bat irakurri
						System.out.print("Sartu izena (hutsa amaitzeko): ");
						izena=teklatua.nextLine();
					}
					// Teklatua itxi
					// teklatua.close();
					// fitxategia itxi
					fitxategiaidatzi.close();
				} catch (IOException ioe) {
					// irteera/sarrera salbuespenak jasoko ditu
					ioe.printStackTrace();
				}
			
				break;
			case 2:
				try {
					File fitxategiairakurri = null;
					FileReader fr = null;
					BufferedReader br = null;
					fitxategiairakurri = new File ("izenabizenak.txt");
					fr = new FileReader (fitxategiairakurri);
					br = new BufferedReader(fr);
					// Fitxategiaren edukia pantailatik atera
					System.out.println("Fitxategiaren edukia");
					String lerroa=null;
					while((lerroa=br.readLine())!=null){
					System.out.println(lerroa);
					}
					
					// fitxategia itxi
					fr.close();
				} catch (FileNotFoundException fnfe) {
					// Fitxategia ez badu aurkitzen
					System.out.println("Errorea, fitxategia ezin da ireki");
					//fnfe.printStackTrace();
				} catch (IOException ioe) {
					// TODO Auto-generated catch block
					ioe.printStackTrace();
				}
				break;
			case 3:
				try {
					File fitxategiairakurri = null;
					FileReader fr = null;
					BufferedReader br = null;
					fitxategiairakurri = new File ("izenabizenak.txt");
					fr = new FileReader (fitxategiairakurri);
					br = new BufferedReader(fr);
					// fitxategiaren edukia atera
					System.out.println("Fitxategiaren edukia");
					String lerroa=null;
					String izenafitx=null;
					boolean badago=false;
					izena=teklatua.nextLine();
					System.out.println("sartu izena: ");
					izena=teklatua.nextLine();
					while((lerroa=br.readLine())!=null){
						int espazioa=lerroa.indexOf(".");
						
						izenafitx=lerroa.substring(0, espazioa);
						
						if (izena.equals(izenafitx))
						{
							badago=true;
							System.out.println("badago");
							System.out.println(lerroa);
						}
					}
					if (!badago){
						
					 
						System.out.println("ez dago");
					}
							
						// fitxategia itxi
					//teklatua.close();	
				} catch (FileNotFoundException fnfe) {
					// Fitxategia ez baldin badu ikusten
					System.out.println("Errorea irakurtzean. Fitxategia ezin ireki");
					//fnfe.printStackTrace();
				} catch (IOException ioe) {
					// TODO Auto-generated catch block
					ioe.printStackTrace();
				}
				
				
				
				break;
			case 4:
				try {
					File fitxategiairakurri = null;
					FileReader fr = null;
					BufferedReader br = null;
					fitxategiairakurri = new File ("izenabizenak.txt");
					fr = new FileReader (fitxategiairakurri);
					br = new BufferedReader(fr);
					// fitxategiaren edukia atera
					System.out.println("Fitxategiaren edukia");
					String lerroa=null;
					String abizenafitx=null;
					boolean badago=false;
					izena=teklatua.nextLine();
					System.out.println("sartu abizena: ");
					abizena=teklatua.nextLine();
					while((lerroa=br.readLine())!=null){
						int espazioa=lerroa.indexOf(".");
						
						abizenafitx=lerroa.substring(espazioa+1);
						
						if (abizena.equals(abizenafitx))
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
					//teklatua.close();	
				} catch (FileNotFoundException fnfe) {
					// Fitxategia ez baldin badu ikusten
					System.out.println("Errorea irakurtzean. Fitxategia ezin ireki");
					//fnfe.printStackTrace();
				
				} catch (IOException ioe) {
					// TODO Auto-generated catch block
					ioe.printStackTrace();
				}
			break;
					
		default:
		
			
		}
	
		}
		teklatua.close();
	}
	
}
