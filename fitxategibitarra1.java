package ebaluaketa3;

/*import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;*/
import java.io.*;
import java.util.ArrayList;

import ebaluaketa2.Alumno;



public class fitxategibitarra1 {

	public static void main(String[] args) {
		ArrayList<String> ALI = new ArrayList<String>();
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
			//System.out.println(lerroa);
			
			for (int i=lerroa.length();i<128;i++){
				lerroa=lerroa+' ';
			}
			ALI.add(lerroa);
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
		for (int i=0;i<ALI.size();i++){
			System.out.println(ALI.get(i));
		}
		try {
			
			FileOutputStream fileOutput = new FileOutputStream ("proba.bin");
			BufferedOutputStream bufferedOutput = new BufferedOutputStream (fileOutput);
			byte[] bina= new byte[128];
			for (int i=0;i<ALI.size();i++){
				bina=ALI.get(i).getBytes();
			    bufferedOutput.write(bina, 0, 128);
			}
			
			
			
			bufferedOutput.close();
			
		
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
		}
		try
		{
			FileInputStream fileinput= new FileInputStream("proba.bin");
			BufferedInputStream bufferedinput = new BufferedInputStream(fileinput);
			
			byte[] datuak1 = new byte[128*ALI.size()];
			bufferedinput.read(datuak1);
			System.out.println("Fitxategiaren edukia:");
			for(int i=0;i<128*ALI.size();i++){
				System.out.println(datuak1[i]);
			}
			
			
		}
		
		catch (FileNotFoundException fnfe) {
			// Fitxategia ez baldin badu ikusten
			System.out.println("Errorea irakurtzean. Fitxategia ezin jaso");
			//fnfe.printStackTrace();
		}
		catch (IOException ioe) {
		// TODO Auto-generated catch block
		ioe.printStackTrace();
	}
	}

}
