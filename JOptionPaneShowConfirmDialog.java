package ebaluaketa3;

import javax.swing.JOptionPane;

public class JOptionPaneShowConfirmDialog {

	public static void main(String[] args) {
		// mezu hau ateratzen duen elkarrizketa koadroa
		
		int aukera = JOptionPane.showConfirmDialog(
				null,(String)"Elkarrizketa koadroak. Proba",
				"Baieztatze elkarrizketa koadroa",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,null);
		
		
		String mezua="";
		if (aukera == JOptionPane.YES_OPTION){
			// Bai sakatu du
			mezua = "Bai";
		}
		else if (aukera == JOptionPane.NO_OPTION){
			// Ez sakatu badu
			mezua = "Ez";
		}
		else if (aukera == JOptionPane.CANCEL_OPTION){
			// Utzi sakatu badu
			mezua = "Utzi";
		}
		else if (aukera == JOptionPane.CLOSED_OPTION){
			// leihoa itxi bada
			mezua = "Itxi leihoa";
		}
		else{
			// si ha habido un Error
			mezua = "Errorea";
		}
		mezua =  mezua + " aukera sakatu da";
		// muestro el cuadro de díalogo con la respuesta
		JOptionPane.showMessageDialog(null,(String)mezua,"Erantzuna",JOptionPane.OK_OPTION,null);
	}

}
