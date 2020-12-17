package eb3;

public class Haria1 extends Thread {
	String Izena;
	
	public Haria1 (String Izena) {
		this.Izena=Izena;
		
		}
	
	public void run() {
		System.out.println(Izena+" hasi da ");
		for (int i=1;i<5;i++) {
			System.out.println(i+Izena);
		}
		System.out.println(Izena+" amaitu da ");
		
	}
}
