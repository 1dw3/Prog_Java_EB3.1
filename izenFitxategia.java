package eb3;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class izenFitxategia {

	public static void main(String[] args) {
		
		// izenak eskatzen ditu eta gordeko ditu izenak.txt fitxategian 
		// Kate hutsa sartu arte
		// Amaitzean, fitxategia pantailatik aterako du
		
		// Izenak fitxategian idatzi
		
		try {
			File fitxategia=new File ("izenak.txt");
			FileWriter fitxategiaidatzi = null;
			PrintWriter pw = null;
			fitxategiaidatzi = new FileWriter(fitxategia, true);
			pw = new PrintWriter(fitxategiaidatzi);
		
			
			// Skanner klaseko objektu bat deklaratu
			Scanner teklatua = new Scanner(System.in);
			// Izen bat irakurri
			String izena=null;
			String abizena=null;
			System.out.print("Sartu izen bat(hutsa amaitzeko): ");
			izena=teklatua.nextLine();
			while(!izena.equals("")){
				// zuria ez den bitartean
				// fitxategian idatzi
				System.out.print("Sartu abizena: ");
				abizena=teklatua.nextLine();
				pw.println(izena+" "+abizena);
				//System.out.println("Izena: "+izena);
				// Beste izen bat irakurri
				System.out.print("Sartu izen bat(hutsa amaitzeko): ");
				izena=teklatua.nextLine();
			}
			// teklatua itxi
			teklatua.close();
			// fitxategia itxi
			fitxategiaidatzi.close();
		} catch (FileNotFoundException ioe) {
			// fitxategia ez badu ikusten
			System.out.print("errorea idaztean. Fitxategia ezin idatzi \n");
			
		}catch (IOException ioe) {
			// sarrera/irteera salbuespenak jasoko ditu
			//ioe.printStackTrace();
			ioe.printStackTrace();
			
		}
		
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
			fr.close();
			
			// fitxategia itxi
			
		} catch (FileNotFoundException fnfe) {
			// Fitxategia ez baldin badu ikusten
			System.out.println("Errorea irakurtzean. Fitxategia ezin jaso");
			//fnfe.printStackTrace();
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
		}
		
		
	}

}
