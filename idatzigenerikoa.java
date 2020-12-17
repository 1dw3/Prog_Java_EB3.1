package ebaluaketa3;

public class idatzigenerikoa <T>{
	T baliogenerikoa;
	
	/*public idatzigenerikoa (T balioa){
		baliogenerikoa=balioa;
		}*/
	
	public <U> void idatzi (U balioa){
		this.baliogenerikoa=(T) balioa;
		System.out.println("Balioaren edukia:  " + balioa);
	}

}
