//Acceso a base de datos Metodo tradicional posibilidad inyecci�n de sql

package eb3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;

public class BDConexionAlumnosDNI_1 {
	public static void main(String[] args) {
		
		try{
			
			//Conexion con BBDD
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdikasleak", "root", "");
			
			// si se ha conectado correctamente
			System.out.println("Conexi�n Correcta.");
			
			//Creaci�n del statemente
			Statement st = conexion.createStatement();
			
			// Obtengo los datos del parametro
			System.out.println ("introduce un DNI: ");
			Scanner teclado = new Scanner(System.in);
			String DNI;
			DNI=teclado.nextLine();
			
			//Creaci�n de la sentencia sql
			String Katea="SELECT * FROM ikasleak where nan='"+DNI+"'";
			//11111111A' union select nan, kodeirakas, nota, nota from notak where nan ='11111111A ";
			System.out.println(Katea);
			//Obtenci�n de datos
			ResultSet rs = st.executeQuery(Katea);
			
			//Gesti�n de datos
			while (rs.next())
			{
					
				   System.out.println("nan: "+rs.getObject(1)+", izena: "+rs.getObject("izena")+
				      ", abizenak: "+rs.getObject("abizenak")+
				      ", taldea: "+rs.getObject("taldea"));
				   
				   
				}
			
			
			// cierro el ResultSet
			rs.close();
			
			// cierro el Statement despues de realizar la consulta
			st.close();
			
			
			// Cierro la conexion
			conexion.close();
		}
		catch (SQLException | ClassNotFoundException sqle){
			// si NO se ha conectado correctamente
			
			System.out.println("Error de Conexi�n");
			
			//Si quiero que aparezca el error
			sqle.printStackTrace();
		}
	}
}
