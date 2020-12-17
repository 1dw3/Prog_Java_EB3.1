package ebaluaketa3;

/*import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;*/
import java.io.*;



public class fitxategibitarrazenbakiak {

	public static void main(String[] args) {
		byte[] datuak = new byte[10];
		int i=0;
		try {
			//File fitxategiairakurri = null;
			//FileReader fr = null;
			//BufferedReader br = null;
			File fitxategiairakurri = new File ("zenbakiak.txt");
			FileReader fr = new FileReader (fitxategiairakurri);
			BufferedReader br = new BufferedReader(fr);
			
			FileOutputStream fileOutput = new FileOutputStream ("zenbakiak.bin");
			BufferedOutputStream bufferedOutput = new BufferedOutputStream (fileOutput);
			
			// fitxategiaren edukia atera
			System.out.println("Fitxategiaren edukia");
			String lerroa=null;
			while((lerroa=br.readLine())!=null){
				System.out.println(lerroa);
				datuak[i]=(byte)Integer.parseInt(lerroa);
				System.out.println(datuak[i]);
			}
			
			bufferedOutput.write(datuak, 0, 10);
			fr.close();
			bufferedOutput.close();
			
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