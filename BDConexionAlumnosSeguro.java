package eb3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;

public class BDConexionAlumnosSeguro {
	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdikasleak", "root", "");
			// si se ha conectado correctamente
			//System.out.println("Conexión Correcta.");
			//Statement st = conexion.createStatement();
			//ResultSet rs = st.executeQuery("SELECT * FROM ikasleak");
			PreparedStatement ps=(PreparedStatement) conexion.prepareStatement ("SELECT * FROM ikasleak where nan=?");
			ps.setString(1, "11111111A");
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
			   System.out.println("nan: "+rs.getObject("nan")+", izena: "+rs.getObject("izena")+
			      ", abizenak: "+rs.getObject("abizenak")+
			      ", taldea: "+rs.getObject("taldea"));
			}
			// cierro el ResultSet
			//rs.close();
			// cierro el Statement despues de realizar la consulta
			//st.close();
			ps.close();
			
			// abro una nueva instancia del Statement 
			// st = conexion.createStatement();
			// actualizo el valor del grupo del alumno '11111111A' a '1DW3'
			//st.executeUpdate("UPDATE alumnos SET grupo='1DW3' WHERE dni='11111111A'");
			// cierro el Statement despues de realizar la consulta
			//st.close();
			
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
