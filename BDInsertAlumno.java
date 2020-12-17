package ebaluaketa3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class BDInsertAlumno {
	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/dbikasleak", "root", "");
			// si se ha conectado correctamente
			// abro una instancia del Statement 
			Statement st = conexion.createStatement();
			st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM ikasleak");
			System.out.println("___________________Sartu baino lehen ____________");
			while (rs.next())
				
			{
			   System.out.println("NAN: "+rs.getObject("nan")+", Izena: "+rs.getObject("izena")+
			      ", Abizenak: "+rs.getObject("abizenak")+
			      ", Taldea: "+rs.getObject("taldea"));
			}
			// añado un alumno
			st.executeUpdate("INSERT INTO ikasleak VALUES ('12121212A','Berria','ikaslea','1AS3')");
			// cierro el Statement despues de realizar la consulta
			st.close();
			
			
			
			
			// abro una instancia del Statement
			st = conexion.createStatement();
			rs = st.executeQuery("SELECT * FROM ikasleak");
			System.out.println("___________________Sartu eta gero ____________");
			while (rs.next())
			{
			   System.out.println("NAN: "+rs.getObject("nan")+", Izena: "+rs.getObject("izena")+
			      ", Abizenak: "+rs.getObject("abizenak")+
			      ", Taldea: "+rs.getObject("taldea"));
			}
			// cierro el ResultSet
			rs.close();
			// cierro el Statement despues de realizar la consulta
			st.close();
			
			// cierro la conexion con la base de datos
			conexion.close();
		}
		catch (SQLException | ClassNotFoundException sqle){
			// si NO se ha conectado correctamente
			sqle.printStackTrace();
			System.out.println("Error de Conexión");
		}
	}
}
