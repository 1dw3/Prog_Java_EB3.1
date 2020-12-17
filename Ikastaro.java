package eb3;

import java.io.Serializable;

public class Ikastaro implements Serializable {
	String izena;
	int orduak;
	int urtea;
	
	public Ikastaro() {
		
	}
	public Ikastaro(String izena, int orduak, int urtea) {
		this.izena=izena;
		this.orduak=orduak;
		this.urtea=urtea;
	}
	@Override
	public String toString() {
		return "Ikastaro [izena=" + izena + ", orduak=" + orduak + ", urtea=" + urtea + "]";
	}

}
