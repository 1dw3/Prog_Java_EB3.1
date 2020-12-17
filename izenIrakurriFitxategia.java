package eb3;

import java.io.*;
public class izenIrakurriFitxategia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			File fitxategia=null;
			FileReader fr=null;
			BufferedReader br =null;
			fitxategia=new File("proba.txt");
			fr=new FileReader (fitxategia);
			br=new BufferedReader(fr);
			
			String lerroa;
			while ((lerroa=br.readLine())!=null){
			System.out.println(lerroa);
			}
		} catch (FileNotFoundException ioe) {
			// fitxategia ez badu ikusten
			System.out.print("errorea irakurtzean. Fitxategia ezin irakurri \n");
						
		}catch (IOException ioe) {
			// sarrera/irteera salbuespenak jasoko ditu
			//ioe.printStackTrace();
			ioe.printStackTrace();
						
		
		
		
		
		

		}
	}
}
