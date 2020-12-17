package eb3;





import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class DBSelectUpdateInsertDeleteResultSet {

	public static void main(String[] args) throws ClassNotFoundException, MySQLIntegrityConstraintViolationException {
		// TODO Auto-generated method stub
		
		//SELECT EGITEKO
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection konexioa = (Connection) DriverManager.getConnection
					("jdbc:mysql://localhost/dbIkasleak", "root", "");
			// ondo burutu baldin bada
			System.out.println("Konexio egokia1.");
			// konexioa itxi
			
			
			
			Statement st = konexioa.createStatement();
			ResultSet rs = (ResultSet) st.executeQuery("SELECT * FROM ikasleak");
			
			while (rs.next()){
				System.out.println("NAN: " + rs.getObject("nan") + ", Izena: " + rs.getObject("izena")
				+ ", Abizenak: " + rs.getObject("abizenak") + ", Taldea: " + rs.getObject("taldea"));
				}
			// ResultSet itxi
			rs.close();
			// Statement itxi kontsulta egin eta gero
			st.close();
			konexioa.close();
				
				
			
			}
			catch (SQLException sqle){
			// ez baldin bada konexioa era egokian egin
			sqle.printStackTrace();
			System.out.println("Konexio errorea1");
			}
		//UPDATE EGITEKO
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection konexioa = (Connection) DriverManager.getConnection
					("jdbc:mysql://localhost/dbIkasleak", "root", "");
			// ondo burutu baldin bada
			System.out.println("Konexio egokia2.");
			// konexioa itxi
			
					
			
			Statement st = konexioa.createStatement();
			st.executeUpdate("UPDATE ikasleak SET taldea='Txo' WHERE nan='11111111A'");
			
			st.close();
			
				
				
			konexioa.close();
			}
			catch (SQLException sqle){
			// ez baldin bada konexioa era egokian egin
			sqle.printStackTrace();
			System.out.println("Konexio errorea2");
			}

		//INSERT EGITEKO
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection konexioa = (Connection) DriverManager.getConnection
					("jdbc:mysql://localhost/dbIkasleak", "root", "");
			// ondo burutu baldin bada
			System.out.println("Konexio egokia3.");
			// konexioa itxi
			
			
			
				
			
			
			Statement st = konexioa.createStatement();
			st.execute("INSERT INTO ikasleak VALUES ('77777778G','Kepa', 'Etxebarria','1DW3')");
			st.close();
			
				
				
			konexioa.close();
			//Insert egiterakoan ikaslea baldin badago, salbuespen hau agertuko da
			}catch (MySQLIntegrityConstraintViolationException mslcve) {
				System.out.println("Ikasle hori badago datubasean");
			}catch (SQLException sqle){
			// ez baldin bada konexioa era egokian egin
				
			//sqle.printStackTrace();
			System.out.println("Konexio errorea3");
			}
		

		//DELETE EGITEKO
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection konexioa = (Connection) DriverManager.getConnection
					("jdbc:mysql://localhost/dbIkasleak", "root", "");
			// ondo burutu baldin bada
			System.out.println("Konexio egokia4.");
			// konexioa itxi
			
			
			
				
			
			
			Statement st = konexioa.createStatement();
			st.execute("DELETE FROM ikasleak WHERE nan='11111111A'");
			st.close();
			
				
				
			konexioa.close();
			}
			catch (SQLException sqle){
			// ez baldin bada konexioa era egokian egin
			sqle.printStackTrace();
			System.out.println("Konexio errorea4");
			}
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection konexioa = (Connection) DriverManager.getConnection
					("jdbc:mysql://localhost/dbIkasleak", "root", "");
			// ondo burutu baldin bada
			System.out.println("Konexio egokia1.");
			// konexioa itxi
			
			
			
			Statement st = konexioa.createStatement();
			ResultSet rs = (ResultSet) st.executeQuery("SELECT * FROM ikasleak");
			
			while (rs.next()){
				System.out.println("NAN: " + rs.getObject("nan") + ", Izena: " + rs.getObject("izena")
				+ ", Abizenak: " + rs.getObject("abizenak") + ", Taldea: " + rs.getObject("taldea"));
				}
				// ResultSet itxi
				rs.close();
				// Statement itxi kontsulta egin eta gero
				st.close();
				
				
			konexioa.close();
			}
			catch (SQLException sqle){
			// ez baldin bada konexioa era egokian egin
			sqle.printStackTrace();
			System.out.println("Konexio errorea1");
			}
		
		
	}

}
