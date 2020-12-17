package eb3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDKonexioa {
	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection konexioa = DriverManager.getConnection("jdbc:mysql://localhost/dbikasleak", "root", "");
			// lotura ondo egina
			System.out.println("Konexio egokia.");
			// konexioa itxi
			konexioa.close();
		}
		catch (SQLException | ClassNotFoundException sqle){
			// konexioa ez bada egin era egokian
			sqle.printStackTrace();
			System.out.println("Konexio errorea");
		}
	}
}
