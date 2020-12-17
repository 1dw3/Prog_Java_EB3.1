package ebaluaketa3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class BDDeleteIkaslea {
	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
			// si se ha conectado correctamente
			// abro una instancia del Statement 
			Statement st = conexion.createStatement();
			// borro un alumno DELETE FROM contacto WHERE 
			st.executeUpdate("DELETE FROM alumnos WHERE dni='12345678A'");
			// cierro el Statement despues de realizar la consulta
			st.close();
			
			// abro una instancia del Statement
			st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM alumnos");
			while (rs.next())
			{
			   System.out.println("DNI: "+rs.getObject("dni")+", nombre: "+rs.getObject("nombre")+
			      ", Apellidos: "+rs.getObject("apellidos")+
			      ", Grupo: "+rs.getObject("grupo"));
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
