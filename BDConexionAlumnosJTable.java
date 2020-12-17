package ebaluaketa3;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BDConexionAlumnosJTable extends JPanel{

	private static final long	serialVersionUID	= -4296118790806780891L;
	
	static Vector<Vector<String>> data = new Vector<Vector<String>>();
	
	
	// Panel BDConexionAlumnosJTable
	public BDConexionAlumnosJTable() {
		super(new GridLayout(1,0));

    Vector<String> columnNames = new Vector<String>();
    columnNames.add("NAN");
    columnNames.add("Izena");
    columnNames.add("Abizenak");
    columnNames.add("Taldea");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/dbikasleak", "root", "");
			// si se ha conectado correctamente
			
			// selecciono todos los alumnos
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM ikasleak");
			
			// añado uno a uno los alumnos al vector de datos
			while (rs.next()) {
				Vector<String> vstring = new Vector<String>();
		  vstring.add(rs.getString("nan"));
	      vstring.add(rs.getString("izena"));
	      vstring.add(rs.getString("abizenak"));
	      vstring.add(rs.getString("taldea"));
	      //vstring.add("\n\n\n\n\n\n\n");
        data.add(vstring);
			}		
			
			// creo la JTable
			DefaultTableModel model = new DefaultTableModel(data, columnNames);
      final JTable table = new JTable(model);
      table.setPreferredScrollableViewportSize(new Dimension(500, 70));
      table.setFillsViewportHeight(true);

      // creo un scroll pane y le añado la tabla
      JScrollPane scrollPane = new JScrollPane(table);

      // añado el scroll pane al panel de la clase BDConexionAlumnosJTable
      this.add(scrollPane);
			
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
  // creo la interfaz grafica (GUI)
	// por seguridad este hilo deberia ser llamado desde el hilo event-dispatching
 
  public static void createAndShowGUI() {
      // creo el JFrame de la aplicacion
      JFrame frame = new JFrame("BDAlumnos - JTable");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // creo el panel donde va la JTable
      BDConexionAlumnosJTable newContentPane = new BDConexionAlumnosJTable();
      newContentPane.setOpaque(true); //content panes must be opaque
      frame.setContentPane(newContentPane);

      // muestro el frame
      frame.pack();
      frame.setVisible(true);
  }

 // main
  public static void main(String[] args) {
      //Schedule a job for the event-dispatching thread:
     //creating and showing this application's GUI.
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
          public void run() {
             createAndShowGUI();
          }
     });
  }
	
}
