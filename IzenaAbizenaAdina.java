package eb3;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class IzenaAbizenaAdina {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teklatua=new Scanner (System.in);
		String Izena =null;
		String Abizena = null;
		String Adina = null;
		int Posizioa = 0;
		ArrayList<IzenaDoc> Pertsona = new ArrayList<IzenaDoc>(); 
		
		try {
			File fitxategia=null;
			FileReader fr=null;
			BufferedReader br =null;
			fitxategia=new File("fitxategiIzenaAbizena.txt");
			fr=new FileReader (fitxategia);
			br=new BufferedReader(fr);
			
			String lerroa;
			while((lerroa=br.readLine())!=null) {
				
				String [] Banandu = lerroa.split("#");
				Izena = Banandu[0];
				Abizena = Banandu[1];
				IzenaDoc Izena1 = new IzenaDoc(Izena, Abizena);
				Pertsona.add(Izena1);
			}
			fr.close();
		}catch(FileNotFoundException ioe) {
			System.out.println("Errorea irakurtzean. Fitxategia ezin irakurri");
		}
		catch(IOException ioe) {
			ioe.printStackTrace();	
	}
		
		try {
			File fitxategia2=null;
			FileReader fr=null;
			BufferedReader br =null;
			fitxategia2=new File("fitxategiIzenaAdina.txt");
			fr=new FileReader (fitxategia2);
			br=new BufferedReader(fr);
			
			String lerroa;
			while((lerroa=br.readLine())!=null) {
				String [] Banandu = lerroa.split("#");
				//Izena = Banandu[0];
				Adina = Banandu[1];
				Pertsona.get(Posizioa).adinaSartu(Adina);
				Posizioa=Posizioa+1;
				
				
			}
			fr.close();
		}catch(FileNotFoundException ioe) {
			System.out.println("Errorea irakurtzean. Fitxategia ezin irakurri");
		}
		catch(IOException ioe) {
			ioe.printStackTrace();	
	}
		
		try {
			FileWriter fitxategia = null;
			PrintWriter pw = null;
			fitxategia = new FileWriter ("fitxategiIzenaAbizenaAdina.txt",true);
			pw= new PrintWriter (fitxategia);
			for(int i = 0; i<Pertsona.size();i++) {
				pw.println(Pertsona.get(i));
			}
			fitxategia.close();
			
			
			}catch(FileNotFoundException ioe) {
				System.out.println("Errorea idaztean. Fitxategia ezin idatzi");
			}
			catch(IOException ioe) {
				ioe.printStackTrace();
			}
			
	}
		
}


