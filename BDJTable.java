package ebaluaketa3;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class BDJTable extends JPanel {

	private static final long serialVersionUID = -2604328808879514435L;

	private boolean DEBUG = false;
        // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; // use specific driver for your database
    static final String DB_URL = "jdbc:mysql://localhost/bdalumnos";
    // Database credentials
    static final String USER = "root";
    static final String PASS = "";
    Connection conn = null;
    Statement stmt = null;
    static Vector<Vector<String>> data = new Vector<Vector<String>>();

    public BDJTable() {
        super(new GridLayout(1,0));


        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Nan");
        columnNames.add("Izena");
        columnNames.add("Abizenak");
        columnNames.add("Taldea");


      String query = "select * from ikasleak";


        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	conn = DriverManager.getConnection("jdbc:mysql://localhost/dbikasleak", "root", "");
          
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {

                Vector<String> vstring = new Vector<String>();


                vstring.add(rs.getString("Nan"));
                vstring.add(rs.getString("Izena"));
                vstring.add(rs.getString("Abizenak"));
                vstring.add(rs.getString("Taldea"));
                vstring.add("\n\n\n\n\n\n\n");

                data.add(vstring);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

      //  final JTable table = new JTable(data, columnNames);
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        final JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Database Data");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        BDJTable newContentPane = new BDJTable();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

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
