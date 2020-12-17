package eb3;

public class IzenaDoc {
	private String Izena;
	private String Abizena;
	private String  Adina;
	
	
	IzenaDoc(String izena,String abizena){
		setIzena(izena);
		setAbizena(abizena);
		setAdina("0");
		}
	
	public void adinaSartu(String adina){
		setAdina(adina);
	}
	
	
	@Override
	public String toString() {
		return Izena +"#"+ Abizena +"#"+  Adina ;
	}



	public String getIzena() {
		return Izena;
	}
	public void setIzena(String izena) {
		Izena = izena;
	}
	public String getAbizena() {
		return Abizena;
	}
	public void setAbizena(String abizena) {
		Abizena = abizena;
	}
	public String getAdina() {
		return Adina;
	}
	public void setAdina(String adina) {
		Adina = adina;
	}
}
