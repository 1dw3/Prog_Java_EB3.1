package eb3;

import java.io.Serializable;


public class ikaslea implements Serializable{

	private static final long	serialVersionUID	= -111203257934114735L;
	
	private String Nan;
	private String Izena;
	private String Abizena;
	private String Taldea;
	
	@Override
	public String toString() {
		return "ikaslea [Nan=" + Nan + ", Izena=" + Izena + ", Abizena=" + Abizena + ", Taldea=" + Taldea + "]";
	}
	protected String getNan() {
		return Nan;
	}
	protected void setNan(String nan) {
		Nan = nan;
	}
	protected String getIzena() {
		return Izena;
	}
	protected void setIzena(String izena) {
		Izena = izena;
	}
	protected String getAbizena() {
		return Abizena;
	}
	protected void setAbizena(String abizena) {
		Abizena = abizena;
	}
	protected String getTaldea() {
		return Taldea;
	}
	protected void setTaldea(String taldea) {
		Taldea = taldea;
	}
	public ikaslea(String nan, String izena, String abizena, String taldea) {
		super();
		Nan = nan;
		Izena = izena;
		Abizena = abizena;
		Taldea = taldea;
	}
	public ikaslea() {
		
	}
	
		




}