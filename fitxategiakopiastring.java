package ebaluaketa3;

import java.util.Scanner;
import java.io.*;
import java.util.Scanner;
public class fitxategiakopiastring {

	public static void main(String[] args) {
		Scanner teklatua = new Scanner(System.in);
		String jat_fitxategia;
		String hel_fitxategia;
		String lerroa;
		System.out.println("Sartu jatorrizko fitxategiaren izena");
		jat_fitxategia=teklatua.nextLine();
		System.out.println("Sartu helburu fitxategiaren izena");
		hel_fitxategia=teklatua.nextLine();
		
		try{
			//File fitxategiairakurri=null;
			//FileReader fr=null;
			//BufferedReader br =null;
			File fitxategiairakurri=new File(jat_fitxategia);
			FileReader fr=new FileReader (fitxategiairakurri);
			BufferedReader br=new BufferedReader(fr);
			
			try{
				FileWriter fitxategiaidatzi = new FileWriter(hel_fitxategia);
				PrintWriter pw = new PrintWriter(fitxategiaidatzi);
				while((lerroa=br.readLine())!=null){
					System.out.println(lerroa);
					pw.println(lerroa);
				}
				pw.close();
				
			}catch (IOException ioe) {
				// captura las excepciones de entrada / salida
				// sarrera/irteera salbuespenak jasoko ditu
				//ioe.printStackTrace();
				System.out.print("errorea idaztean. Fitxategia ezin idatzi \n");
			}
			br.close();
						
		}catch (IOException ioe) {
			// captura las excepciones de entrada / salida
			// sarrera/irteera salbuespenak jasoko ditu
			//ioe.printStackTrace();
			System.out.print("errorea irakurtzean. Fitxategia ezin irakurri \n");
			
		}
	

	}

}
