package ebaluaketa3;

/*import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;*/
import java.io.*;



public class fitxategibitarra {

	public static void main(String[] args) {
		try {
						
			FileOutputStream fileOutput = new FileOutputStream ("proba.bin", true);
			BufferedOutputStream bufferedOutput = new BufferedOutputStream (fileOutput);
			byte[] datuak = new byte[20];
			datuak[0]='a';
			datuak[1]='b';
			datuak[2]=2;
			datuak[3]=3;
			datuak[4]=4;
			datuak[5]=5;
			datuak[6]=6;
			datuak[7]=7;
			datuak[8]=8;
					
			bufferedOutput.write(datuak, 0, 9);
			bufferedOutput.close();
					
		
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
		}
		try
		{
			FileInputStream fileinput= new FileInputStream("proba.bin");
			BufferedInputStream bufferedinput = new BufferedInputStream(fileinput);
			
			byte[] datuak1 = new byte[100];
			bufferedinput.read(datuak1);
			System.out.println("Fitxategiaren edukia:");
			for(int i=0;i<100;i++){
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
