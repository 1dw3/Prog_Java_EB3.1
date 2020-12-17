package ebaluaketa3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;







public class DBKonexioa {
	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection konexioa = DriverManager.getConnection("jdbc:mysql://localhost/dbikasleak", "root", "");
			// Ondo konekatu baldin bada
			System.out.println("Konexio egokia.");
			// konexioa itxi
			konexioa.close();
		}
		catch (SQLException | ClassNotFoundException sqle){
			// Konexioa ondo ez baldin bada egiten
			sqle.printStackTrace();
			System.out.println("Konexio errorea");
		}
	}
}
