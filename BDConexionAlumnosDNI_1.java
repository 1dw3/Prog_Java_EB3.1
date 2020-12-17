//Acceso a base de datos Metodo tradicional posibilidad inyección de sql

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
			System.out.println("Conexión Correcta.");
			
			//Creación del statemente
			Statement st = conexion.createStatement();
			
			// Obtengo los datos del parametro
			System.out.println ("introduce un DNI: ");
			Scanner teclado = new Scanner(System.in);
			String DNI;
			DNI=teclado.nextLine();
			
			//Creación de la sentencia sql
			String Katea="SELECT * FROM ikasleak where nan='"+DNI+"'";
			//11111111A' union select nan, kodeirakas, nota, nota from notak where nan ='11111111A ";
			System.out.println(Katea);
			//Obtención de datos
			ResultSet rs = st.executeQuery(Katea);
			
			//Gestión de datos
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
			
			System.out.println("Error de Conexión");
			
			//Si quiero que aparezca el error
			sqle.printStackTrace();
		}
	}
}
