package ebaluaketa3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.*;

import com.sun.rowset.CachedRowSetImpl;

import java.sql.ResultSet;

public class BDUpdateIkasleakRowset {
	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/dbikasleak", "root", "");
			
			
			
			
			// ondo konektatu baldin bada
			// Statement berria 
			Statement st = conexion.createStatement();
			
			//Resulset berria
			ResultSet rs = st.executeQuery("SELECT * FROM ikasleak");
			
			System.out.println("--------Aldaketak egin baino lehen-----------------");
			/*while (rs.next())
			{
			   System.out.println("NAN: "+rs.getObject("nan")+", Izena: "+rs.getObject("izena")+
			      ", Abizenak: "+rs.getObject("abizenak")+
			      ", Taldea: "+rs.getObject("taldea"));
			}*/
			// Resulset itxi
			CachedRowSet crs = new CachedRowSetImpl();
            crs.populate(rs);
            
            System.out.println("hau da");
            crs.first();
            for (int j=1;j<=crs.size();j++){
	            for(int i=1;i<5;i++){
	            	System.out.println(crs.getObject(i));     
	            	}
	            crs.next();
		}
         // Set column values and insert
            crs.moveToInsertRow();
            crs.updateString(1, "12121212A");
            crs.updateString(2, "Izenaproba12");
            crs.updateString(3, "Abizenakproba12");
            crs.updateString(4, "1dw3");
            crs.insertRow();
            
      crs.close();

            System.out.println("1 row inserted.");
            
            System.out.println("hau da sartu eta gero");
            //crs.next();
            /*for (int j=1;j<=crs.size();j++){
	            for(int i=1;i<5;i++){
	            	System.out.println(crs.getObject(i));     
	            	}
	            crs.next();
		}*/
			rs.close();
			// Statement itxi
			st.close();
			
			
			
			
			st = conexion.createStatement();
			//  '11111111A' nan duen ikasleari  '1DW3' jarri
			st.executeUpdate("UPDATE ikasleak SET taldea='2DW3' WHERE nan='11111111A'");
			// Statement itxi
			st.close();
			
			
			
			
			// abro una nueva instancia del Statement
			st = conexion.createStatement();
			rs = st.executeQuery("SELECT * FROM ikasleak");
			System.out.println("--------Aldaketak egin eta gero-----------------");
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
