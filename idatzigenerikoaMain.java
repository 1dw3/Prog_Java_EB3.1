package ebaluaketa3;

public class idatzigenerikoaMain {

	public static void main(String[] args) {
		// Klasegenerikoaren funtzionamendua frogatu
		int i=5;
		double d=3.14;
		String s="Kaixo mundua";
		
		// idatzigenerikoa klaseko elementua sortu
		idatzigenerikoa ig= new idatzigenerikoa();
		
		// Integer
		ig.idatzi(i);

		// Double
		ig.idatzi(d);
		
		// String
		ig.idatzi(s);

	}

}
