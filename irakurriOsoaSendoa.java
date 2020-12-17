package ebaluaketa3;

import java.util.Scanner;

public class irakurriOsoaSendoa {

	public static void main(String[] args) {
		// zenbaki osoa era sendoan irakurri teklatutik 
		int znbk=0;
		String balioa="";
		
		// Scanner klaseko objektua sortu teklatua izenarekin
		Scanner teklatua = new Scanner(System.in);
		char [] array ;
		
		try {
			// Znbk irakurri
			System.out.print("Sartu balio osoa: ");
			balioa = teklatua.nextLine();
			znbk = Integer.parseInt(balioa);
			array=balioa.toCharArray();
		}
		catch (NumberFormatException e){
			System.out.println("Zenbaki akastuna: " + balioa);
			// Balio egokian bilakatuko dut
			char karakterea;
			String BalioEgokia="";
			for(int pos=0;pos<balioa.length();pos++){
				karakterea = balioa.charAt(pos); 
				if(Character.isDigit(karakterea)){
					// Digito egokia baldin bada
					// Stringean gehitu
					BalioEgokia = BalioEgokia+karakterea;
				}
				else if(karakterea=='I' || karakterea=='l'){
					//  'l' karakterea baldin bada
					// '1' karakterea gehituko dut
					BalioEgokia = BalioEgokia + '1';
				}
				else if((Character.toLowerCase(karakterea)=='o')){
					//  'o' edo 'O' karaktereak baldin badira
					//  '0' karakterea gehitu
					BalioEgokia = BalioEgokia +'0';
				}
			}
			// BalioEgokia lortuta
			// int moduan jarri
			if (BalioEgokia==""){
				BalioEgokia = BalioEgokia +'0';
			}
			znbk = Integer.parseInt(BalioEgokia);
		}
		// datu egokia daukat
		
		// Teklatua itxi
		teklatua.close();
		
		// mezua atera
		System.out.println("Sartutako datua  " + znbk +" da ");
		
	}

}
