package eb3;

public class copia {
	String Izena;
	String Abizena;
	String Adina;
	
	public copia(String izena, String abizena, String adina) {
		Izena = izena;
		Abizena = abizena;
		Adina = adina;
	}

	@Override
	public String toString() {
		return Izena + "#" + Abizena + "#" + Adina  ;
	}

}
