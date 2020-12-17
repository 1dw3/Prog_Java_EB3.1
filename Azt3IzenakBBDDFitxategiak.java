package eb3;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import eb3.PertsonaBBDD;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.Font;

public class Azt3IzenakBBDDFitxategiak extends JFrame implements ActionListener,FocusListener{


	private static final long serialVersionUID = -7738502548771528496L;

	private JPanel edukiontzia;
	
	private JLabel lblIzena;
	private JPanel Datuakpanela;
	private JButton btnSartu;
	private JButton btnEzabatu;
	private JButton btnGarbitu;
	
	//Taldeen zerrrenda
	private JList<PertsonaBBDD> lstPertsonak;
	//zerrendaren datu modeloa
	private DefaultListModel<PertsonaBBDD> dlmPertsonak;
	
	boolean datuakaldatuta=false;
	
	private boolean aldatua = false;
	private JTextField txtIzena;
	private JLabel lblAbizena;
	private JTextField txtAbizena;
	private JScrollPane scrollPane;
	private JPanel egoeraPanela;
	private JLabel lblEstado;
	private JLabel lblOraingoegoera ;
	private JLabel lblNan;
	private JTextField txtNan;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Azt3IzenakBBDDFitxategiak frame = new Azt3IzenakBBDDFitxategiak();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Azt3IzenakBBDDFitxategiak() {
		setTitle("Azt3IzenakBBDDFitxategiak_pro ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 336);
		edukiontzia = new JPanel();
		edukiontzia.setBorder(new EmptyBorder(5, 5, 5, 5));
		edukiontzia.setLayout(new BorderLayout(0, 0));
		setContentPane(edukiontzia);
		
		// aplikazioa ixtekoa kontrolatu
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				try {
					
					DatuakGorde();
				} 
				catch (Exception e) {
					e.printStackTrace(System.out);
					
					System.out.println("!!!ERROR irakurtzen");
				}
				finally {
					
				}
			}
		});
		
		Datuakpanela = new JPanel();
		edukiontzia.add(Datuakpanela, BorderLayout.NORTH);
		
		lblNan = new JLabel("NAN");
		Datuakpanela.add(lblNan);
		
		txtNan = new JTextField();
		Datuakpanela.add(txtNan);
		txtNan.setColumns(10);
		
		lblIzena = new JLabel("Izena");
		Datuakpanela.add(lblIzena);
		lblIzena.setHorizontalAlignment(SwingConstants.CENTER);
	  
	  txtIzena = new JTextField();
	  txtIzena.setHorizontalAlignment(SwingConstants.RIGHT);
	  txtIzena.addActionListener(this);
	  txtIzena.addFocusListener(this);
	  Datuakpanela.add(txtIzena);
	  txtIzena.setColumns(10);
	  
	  lblAbizena = new JLabel("Abizena");
	  Datuakpanela.add(lblAbizena);
	  
	  txtAbizena = new JTextField();
	  txtAbizena.setHorizontalAlignment(SwingConstants.RIGHT);
	  txtAbizena.addActionListener(this);
	  txtAbizena.addFocusListener(this);
	  Datuakpanela.add(txtAbizena);
	  txtAbizena.setColumns(10);
	  
	  btnSartu = new JButton("Sartu");
	  btnSartu.addActionListener(this);
	  Datuakpanela.add(btnSartu);
	  
	  btnEzabatu = new JButton("Ezabatu");
	  btnEzabatu.addActionListener(this);
	  Datuakpanela.add(btnEzabatu);
	  
	  btnGarbitu = new JButton("Garbitu");
	  btnGarbitu.addActionListener(this);
	  Datuakpanela.add(btnGarbitu);
		
		// zerrendaren datamodela
	  dlmPertsonak = new DefaultListModel<PertsonaBBDD>();
		// lstPertsonak
		lstPertsonak = new JList<PertsonaBBDD>();
		lstPertsonak.setModel(dlmPertsonak);
		scrollPane = new JScrollPane(lstPertsonak);
		edukiontzia.add(scrollPane, BorderLayout.CENTER);
		
		egoeraPanela = new JPanel();
		FlowLayout flowLayout = (FlowLayout) egoeraPanela.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		edukiontzia.add(egoeraPanela, BorderLayout.SOUTH);
		
		lblEstado = new JLabel("Egoera: ");
		egoeraPanela.add(lblEstado);
		
		lblOraingoegoera  = new JLabel("Aldaketa barik");
		lblOraingoegoera .setFont(new Font("Tahoma", Font.BOLD, 16));
		egoeraPanela.add(lblOraingoegoera );
		
	  // zerrendan kargatu
	  /***************** Lectura ********************************/
	 int errorea;
	 DatuakKargatu();
	 /* if (errorea != 0){
		  JOptionPane.showMessageDialog(edukiontzia,(String)"Datuak kargatzean errorea.","Errorea",JOptionPane.ERROR_MESSAGE,null);
	  }*/
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		//  Action listener
		Object o = ae.getSource();
		if ((o == btnSartu) || (o == txtIzena) || (o == txtAbizena)){
			//  btnSartu edo txtZenbakitzaile edo txtIzendatzaile sakatu baldin bada
			PertsonaBBDD balioa;
			String nan;
			String izena;
			String abizena;
			nan = txtNan.getText();
			izena = txtIzena.getText();
			abizena = txtAbizena.getText();
			balioa = new PertsonaBBDD(nan,izena,abizena);
			if(!dlmPertsonak .contains(balioa)){
				// Balioa JLitean sartu
				// Ez badago datuetan
				dlmPertsonak.addElement(balioa);
				// altaturen balioa aldatu
				aldatua = true;
				// Egoera barra eguneratu
				lblOraingoegoera .setText("Datuak aldatuta");
				datuakaldatuta=true;
			}
		}
		else if (o == btnEzabatu){
			// btnEzabatu sakatu bada
			//  datu guztian ezabatu behar baldin baditut
	  	int[]indizeak = lstPertsonak.getSelectedIndices();
	  	int Aukerakop = indizeak.length;

	  	if (Aukerakop > 0){
	  		// elementu aukeratuak baldin badaude
	  		for(int pos=Aukerakop-1;pos>=0;pos--){
		  		// posizio horretako elementua ezabatu
		  		dlmPertsonak.remove(indizeak[pos]);
		  	}
	  		// aldatuaren balioa aldatu
				aldatua = true;
				// egoera barra eguneratu
				lblOraingoegoera .setText("Datuak aldatuta");
				datuakaldatuta=true;
	  	}
	  	
		}
		else if (o == btnGarbitu){
			// btnGarbitu sakatu baldin bada
			if (!dlmPertsonak.isEmpty()){
				//zerrenda ez baldin badago utzik
				// zerrenda garbitu
				dlmPertsonak.clear();
				// aldatuaren balioa aldatu
				aldatua = true;
				// egoera barra eguneratu
				lblOraingoegoera .setText("Datos aldatuas");
			}
		}
		
	}
	
	// 	errazionalak.dat fitxategitik datuak kargatu.
	// 0 bueltatzen du datuak ondo kargatu baldin badira,  -1 errorea baldin badago
	@SuppressWarnings("resource")
	private void DatuakKargatu(){
		// Datubaseko datuak jaso
		lstPertsonak.setModel(dlmPertsonak);
				try {
					Connection konexioa = DriverManager.getConnection("jdbc:mysql://localhost:3306/eb3", "root", "");
					java.sql.Statement st = konexioa.createStatement();
					int zenbat=0;
					String orden = "SELECT * FROM pertsonak ";
					ResultSet rs = ((java.sql.Statement) st).executeQuery(orden);
					while(rs.next()) {
						PertsonaBBDD P1 = new PertsonaBBDD (rs.getString("nan"),rs.getString("izena"),
								rs.getString("abizena"));
						dlmPertsonak.add( zenbat, P1);
						
						zenbat+=1;
					}
			
			}catch(Exception e) {
				e.printStackTrace(System.out);
			
				System.out.println("!!!ERROR");
			}
	}		
		
	// datuakgorde, datuak errazionalak.dat fitxategian gorde
	// 0 bueltatzen du datuak ondo kargatu baldin badira,  -1 errorea baldin badago
	void DatuakGorde() throws IOException, ClassNotFoundException{
		// datuak errazionalak.dat fitxategian gordeko ditut
	
		
		
		if (datuakaldatuta) {
			
			try {
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/eb3", "root", "");
				java.sql.Statement st = conexion.createStatement();
				String orden = "DELETE FROM PERTSONAK";
				st.executeUpdate(orden);
			
				for(int i=0;dlmPertsonak.size()>i;i++) {
					
					orden = "INSERT INTO PERTSONAK VALUES ('"+dlmPertsonak.get(i).getNan()+"','"+dlmPertsonak.get(i).getIzena()+"','"+dlmPertsonak.get(i).getAbizena()+"')";
					st.executeUpdate(orden);
				}
				conexion.close();
				
			}catch(Exception excepcion) {
				System.out.println("!!!ERROR");
			}
			try {
				
				
				FileOutputStream fos = new FileOutputStream("pertsonak.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				PertsonaBBDD c;
				for(int pos = 0; pos<dlmPertsonak.size();pos++) {
					c = dlmPertsonak.get(pos);
					oos.writeObject(c);
				}
				oos.close();
				fos.close();
			}catch(Exception excepcion) {
				System.out.println("!!!ERROR");
			}
			
			FileInputStream fis = new FileInputStream("pertsonak.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			while(fis.available()>0) {
				PertsonaBBDD P1 = (PertsonaBBDD) ois.readObject();
			
			}
		}	
	}

	@Override
	public void focusGained(FocusEvent fe) {
		JTextComponent jtc = (JTextComponent)fe.getSource();
		jtc.setSelectionStart(0);
		jtc.setSelectionEnd(jtc.getText().length());
	}

	@Override
	public void focusLost(FocusEvent fe) {
		JTextComponent jtc = (JTextComponent)fe.getSource();
		jtc.setSelectionStart(0);
		jtc.setSelectionEnd(0);
	}
	
}

