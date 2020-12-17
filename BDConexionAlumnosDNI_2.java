//Acceso a base de datos Metodo tradicional posibilidad inyección de sql

package eb3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;

public class BDConexionAlumnosDNI_2 {
	public static void main(String[] args) {
		System.out.println ("introduce un DNI: ");
		Scanner teclado = new Scanner(System.in);
		String DNI;
		DNI=teclado.next();
		try{
			
			//Metodo tradicional
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdikasleak", "root", "");
			// si se ha conectado correctamente
			//System.out.println("Conexión Correcta.");
			Statement st = conexion.createStatement();
			String Katea="SELECT * FROM ikasleak where nan='"+DNI+"'";
			ResultSet rs = st.executeQuery(Katea);
			
			
			
			
			
			//st.execute("SELECT * FROM ikasleak where nan='"+DNI+"'");
			PreparedStatement pstmt = (PreparedStatement) conexion.prepareStatement("SELECT * FROM ikasleak WHERE nan = ? ");
			
			pstmt.setString(1, DNI);
			ResultSet rs = pstmt.executeQuery();
			
			//ResultSet rs = st.executeQuery("SELECT * FROM ikasleak where nan='"+DNI+"'");
			
			
			
			while (rs.next())
			/*{
			   System.out.println("nan: "+rs.getObject("nan")+", izena: "+rs.getObject("izena")+
			      ", abizenak: "+rs.getObject("abizenak")+
			      ", taldea: "+rs.getObject("taldea"));
			}*/
			{
				   System.out.println("nan: "+rs.getObject(1)+", izena: "+rs.getObject("izena")+
				      ", abizenak: "+rs.getObject("abizenak")+
				      ", taldea: "+rs.getObject("taldea"));
				}
			
			//SqlCommand command = connection.CreateCommand();
			//command.CommandText = “SELECT * FROM Customers WHERE CustomerID = @CustomerID“;
			//command.Parameters.Add(
			      // new SqlParameter(“@CustomerID“, SqlDbType.NChar, 5)).Value = "GSDC3"
			// cierro el ResultSet
			rs.close();
			// cierro el Statement despues de realizar la consulta
			//st.close();
			
			
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
