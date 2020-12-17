package eb3;

public class Haria2 extends Thread {
	String Izena;
	
	public Haria2 (String nombre) {
		this.Izena=nombre;
		
		}
	
	public void run() {
		System.out.println(Izena+" hasi da ");
		for (int i=5;i>1;i--) {
			System.out.println(i+Izena);
		}
		System.out.println(Izena+" amaitu da ");
	}
}
