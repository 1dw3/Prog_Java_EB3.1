package EB3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import java.awt.Color;
import java.awt.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.event.MouseAdapter;
import javax.swing.JComboBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.FlowLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BizkaiBasketMain_1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1548180793340965123L;
	// JPanel declares
	private JPanel contentPane;
	private JPanel Login;
	private JPanel Taldeak;
	private JPanel panelInfoTaldeak;
	private JPanel panelInfoLogin;
	private JPanel adminMenu;
	private JPanel Jokalariak;
	private JPanel panelInfoJokalariak;
	private JPanel Erabiltzaileak;
	private JPanel panelInfoErabiltzaileak;

	// JButton declares
	private JButton btnLogin;
	private JButton btnBezero;
	private JButton btnGehi;
	private JButton btnAldatu;
	private JButton btnEzabatu;
	private JButton btnErabiltzaileak;
	private JButton btnTaldeak;
	private JButton btnJokalariak;
	private JButton btnPartiduak;
	private JButton btnAdmin;
	private JButton btnKlasifikazioa;

	// JTextfield declares
	private JTextField txtTaldeKodea;
	private JTextField txtTaldeIzena;
	private JTextField txtTaldeHerria;
	private JTextField txtTaldeHelbide;
	private JTextField txtTaldeZelaia;
	private JTextField txtErabiltzaileaLogin;
	private JTextField txtJokalariaNan;
	private JTextField txtJokalariaIzena;
	private JTextField txtJokalariaAbizena;

	// JLabel declares
	private JLabel lblErabiltzailea;
	private JLabel lblLoginInfo;
	private JLabel lblSartu;
	private JLabel lblBezero;
	private JLabel lblPasahitza;
	private JPasswordField pwPasahitza;
	private JLabel lblInfoTaldeak;
	private JLabel lblKodeaTaldea;
	private JLabel lbTaldeIzena;
	private JLabel lbTaldeHerria;
	private JLabel lbTaldeHelbide;
	private JLabel lbTaldeZelaia;
	private JLabel lblEmaitzaPartiduak;
	private JLabel lblSeparador;
	private JLabel lblInfoJokalariak;
	private JLabel lblJokalariIzena;
	private JLabel lblJokalariTaldea;
	private JLabel lblInfoErabiltzaileak;
	private JLabel lblIzenaErabilztaile;

	private JScrollPane scrollPaneTaldea;

	private JList<Taldeak> listTaldeak;
	private JList<Jokalariak> listJokalariak;
	private JList<Partiduak> listPartiduak;
	private JList<Erabiltzaileak> listErabiltzaileak;

	private JPanel Menu;

	private JPanel Partiduak;
	private JPanel panelInfoPartiduak;
	private JLabel lblInfoPartiduak;
	private JLabel lblKodeaPartidua;
	private JLabel lblEtxekoa;
	private JLabel lblKanpokoa;
	private JLabel lblData;
	private JLabel lblNanJokalaria;
	private JLabel lblJokalariAbizena;
	private JLabel lblErabiltzaileaErabiltzaileak;
	private JLabel lblAbizenaErabiltzaile;
	private JLabel lblJarnudaldia;

	private JTextField txtKodeaPartiduak;
	private JTextField txtEtxekoPartiduak;
	private JTextField txtKanpokoPartiduak;

	private JScrollPane scrollPanePartiduak;
	private JScrollPane scrollPaneJokalariak;
	private JTextField txtData;
	private JTextField txtEmaitzaLokala;
	private JTextField txtEmaitzaKanpokoa;
	private JPanel Klasifikazioa;
	private JPanel panelInfoKlasifikazioa;
	private JLabel lblInfoKlasifikazioa;
	private JLabel lblPostua;
	private JLabel lblPuntuak;
	private JScrollPane scrollPaneKlasifikazioa;

	private Boolean panelTaldeak = false;
	private Boolean panelJokalariak = false;
	private Boolean panelKlasifikazioa = false;
	private Boolean panelPartiduak = false;
	private Boolean panelErabiltzaile = false;
	private Boolean panelAdmin = false;
	private Boolean aldatuta = false;
	private Boolean aldatutaTaldeak = false;

	private JComboBox<String> comboBoxJokalariTaldeak;
	private JComboBox<String> comboBoxBaimenak;
	private JComboBox<String> comboBoxJokalariKod_Klub;
	
	private JSpinner spinnerJardunaldia;
	
	private ArrayList<Partiduak> AR_partiduak = new ArrayList<Partiduak>();
	private ArrayList<Taldeak> AR_taldeak = new ArrayList<Taldeak>();
	private ArrayList<Erabiltzaileak> AR_erabiltzaileak = new ArrayList<Erabiltzaileak>();
	private ArrayList<Jokalariak> AR_jokalariak = new ArrayList<Jokalariak>();

	// DefaultListModel deklaratu

	DefaultListModel<Jokalariak> dlmj;
	DefaultListModel<Taldeak> dlmt;
	DefaultListModel<Erabiltzaileak> dlme;
	DefaultListModel<Partiduak> dlmp;
	DefaultListModel<String> dlms;
	
	private  int saiakerak = 3;
	
	Connection konexioaPartiduak;
	CachedRowSet crsPartiduak;

	
	private JTextField txtIzenaErabiltzaile;
	private JTextField txtAbizenaErabiltzaile;
	private JTextField txterabiltzaileaErabiltzaile;
	private JLabel lblPasahitzaErabiltzaile;
	private JTextField txtPasahitzaErabiltzaile;
	private JLabel lblBaimenaErabiltzaile;
	
	private int Jardunaldiak[][] = {{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19},
			{5,16,3,12,13,0,19,2,15,4,11,8,7,14,1,10,9,18,17,6},
			{16,11,2,5,18,7,14,1,12,9,10,3,8,19,6,15,4,13,0,17},
			{15,16,3,4,5,8,11,2,7,10,9,0,17,18,13,14,1,6,19,12},
			{10,17,6,5,16,8,13,3,0,11,12,7,14,19,2,9,18,15,4,1},
			{3,7,5,14,15,19,11,18,8,2,1,13,9,6,4,10,17,12,0,16},
			{2,4,18,0,19,11,14,9,7,17,12,5,10,8,1,3,6,16,13,15},
			{2,18,16,10,5,13,15,7,8,12,9,1,6,3,4,11,17,19,0,14},
			{7,5,3,17,12,16,10,15,13,6,19,0,1,2,18,4,14,8,11,9},
			{2,10,16,18,5,11,15,3,7,13,8,4,9,19,6,14,17,1,0,12},
			{3,5,19,7,14,2,11,13,12,18,10,6,8,0,1,15,4,16,17,9},
			{3,14,18,8,16,2,5,10,15,9,7,1,12,11,6,19,0,4,13,17},
			{2,0,19,1,16,13,5,18,11,3,10,12,8,15,9,7,4,6,17,14},
			{3,19,18,10,14,11,15,17,7,16,12,4,1,8,6,2,0,5,13,9},
			{2,12,9,3,8,7,10,0,11,6,5,15,16,14,19,13,18,1,4,17},
			{3,0,19,5,14,10,15,12,7,11,1,16,9,4,6,8,17,2,13,18},
			{2,13,18,14,16,9,5,17,11,15,12,1,10,19,8,3,4,7,0,6},
			{3,16,19,4,14,12,15,2,7,0,1,11,9,5,6,18,17,8,13,10},
			{0,15,18,3,16,19,5,1,11,17,12,6,10,9,8,13,4,14,2,7}};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BizkaiBasketMain frame = new BizkaiBasketMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @return
	 */

	public void TaldeDatabaseKargatu() {
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			Connection konexioa = DriverManager.getConnection("jdbc:mysql://localhost/bizkaiabasket", "root", "");
			// ondo burutu baldin bada
			System.out.println("Konexio egokia.");

			Statement st = konexioa.createStatement();
			ResultSet rse = st.executeQuery("SELECT * FROM equipo");

			while (rse.next()) {
				Taldeak ObJTaldea = new Taldeak(rse.getObject("Cod_club").toString(),
						rse.getObject("Nombre").toString(), rse.getObject("Municipio").toString(),
						rse.getObject("Correo").toString(), rse.getObject("Estadio").toString());
				dlmt.addElement(ObJTaldea);
				AR_taldeak.add(ObJTaldea);
				
				

			}

			// ResultSet itxi
			rse.close();
			// Statement itxi kontsulta egin eta gero
			st.close();
			// konexioa itxi
			konexioa.close();

		}

		catch (SQLException sqle) {
			// ez baldin bada konexioa era egokian egin
			sqle.printStackTrace();
			System.out.println("Konexio errorea");
		}
	}

	public void JokalariDatabaseKargatu() {
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			Connection konexioa = DriverManager.getConnection("jdbc:mysql://localhost/bizkaiabasket", "root", "");
			// ondo burutu baldin bada
			System.out.println("Konexio egokia.");

			Statement st = konexioa.createStatement();
			ResultSet rsj = st.executeQuery("SELECT * FROM jugadores");
			while (rsj.next()) {
				String taldeIzena = null;
				for(int i = 0; i<dlmt.size(); i++) {
					if(rsj.getObject("Cod_club").equals(dlmt.get(i).getKodea())) {
						taldeIzena = dlmt.get(i).getIzena();
					}
				}
				Jokalariak ObjJokalariak = new Jokalariak(rsj.getObject("DNI").toString(),
						rsj.getObject("Nombre").toString(), rsj.getObject("Apellido").toString(),taldeIzena
						);
				
				dlmj.addElement(ObjJokalariak);
				AR_jokalariak.add(ObjJokalariak);
				
				
			}

			// ResultSet itxi
			rsj.close();
			// Statement itxi kontsulta egin eta gero
			st.close();
			// konexioa itxi
			konexioa.close();

		}

		catch (SQLException sqle) {
			// ez baldin bada konexioa era egokian egin
			sqle.printStackTrace();
			System.out.println("Konexio errorea");
		}
	}

	public void TaldeComboboxKargatu() {
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			Connection konexioa = DriverManager.getConnection("jdbc:mysql://localhost/bizkaiabasket", "root", "");
			// ondo burutu baldin bada
			System.out.println("Konexio egokia.");

			Statement st = konexioa.createStatement();
			ResultSet rsj = st.executeQuery("SELECT Nombre FROM equipo");

			while (rsj.next()) {

				comboBoxJokalariTaldeak.addItem(rsj.getObject("Nombre").toString());

			}

			// ResultSet itxi
			rsj.close();
			// Statement itxi kontsulta egin eta gero
			st.close();
			// konexioa itxi
			konexioa.close();

		}

		catch (SQLException sqle) {
			// ez baldin bada konexioa era egokian egin
			sqle.printStackTrace();
			System.out.println("Konexio errorea");
		}
	}
	
	
	public void ErabiltzaileDatabaseKargatu() {
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("$objectdb/db/Erabiltzaileak.odb");
				EntityManager em = emf.createEntityManager();
				
				TypedQuery< Erabiltzaileak > tq1 =
						em.createQuery("SELECT p FROM Erabiltzaileak p ", Erabiltzaileak.class);
						List<Erabiltzaileak> results = tq1.getResultList();
						for (Erabiltzaileak p : results) {
						dlme.addElement(p);
						}
				
	}
	
	
	public void JokalariCod_clubComboboxKargatu() {
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			Connection konexioa = DriverManager.getConnection("jdbc:mysql://localhost/bizkaiabasket", "root", "");
			// ondo burutu baldin bada
			System.out.println("Konexio egokia.");

			Statement st = konexioa.createStatement();
			ResultSet rsj = st.executeQuery("SELECT Cod_Club FROM equipo ");

			while (rsj.next()) {

				comboBoxJokalariKod_Klub.addItem(rsj.getObject("Cod_Club").toString());

			}

			// ResultSet itxi
			rsj.close();
			// Statement itxi kontsulta egin eta gero
			st.close();
			// konexioa itxi
			konexioa.close();

		}

		catch (SQLException sqle) {
			// ez baldin bada konexioa era egokian egin
			sqle.printStackTrace();
			System.out.println("Konexio errorea");
		}
	}
	
	
	public void PartiduakKargatu (){
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			Connection konexioa = DriverManager.getConnection("jdbc:mysql://localhost/bizkaiabasket", "root", "");
			// ondo burutu baldin bada
			System.out.println("Konexio egokia.");

			Statement st = konexioa.createStatement();
			ResultSet rsj = st.executeQuery("SELECT * FROM partidos ");

			while (rsj.next()) {
				int Jardunaldia = Integer.parseInt(rsj.getObject("Jornada").toString());
				int emaitzaLokal = Integer.parseInt(rsj.getObject("Resultado_local").toString());
				int emaitzaKanpokoa = Integer.parseInt(rsj.getObject("Resultado_visitante").toString());
				
				
				Partiduak ObjPartiduak = new Partiduak(rsj.getObject("Cod_partido").toString(),
				Jardunaldia, rsj.getObject("Equipo_local").toString(),rsj.getObject("Equipo_visitante").toString(),"0000-00-00",emaitzaLokal,emaitzaKanpokoa);
				dlmp.addElement(ObjPartiduak);
				AR_partiduak.add(ObjPartiduak);

			}

			// ResultSet itxi
			rsj.close();
			// Statement itxi kontsulta egin eta gero
			st.close();
			// konexioa itxi
			konexioa.close();

		}

		catch (SQLException sqle) {
			// ez baldin bada konexioa era egokian egin
			sqle.printStackTrace();
			System.out.println("Konexio errorea");
		}
	}
	
	public void ErabiltzaileakKargatu(){
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("$objectdb/db/Erabiltzaileak.odb");
				EntityManager em = emf.createEntityManager();
				
				TypedQuery< Erabiltzaileak > tq1 =
						em.createQuery("SELECT e FROM Erabiltzaileak e", Erabiltzaileak.class);
		List<Erabiltzaileak> results = tq1.getResultList();
		for (Erabiltzaileak e : results) {
			AR_erabiltzaileak.add(e);

		}
	}

	public BizkaiBasketMain() throws IOException, ClassNotFoundException{
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				if (aldatuta){
					try{
					
					
					// Ondo konektatu baldin bada
					// datuen eguneratze automatikoa desgaitu
					konexioaPartiduak.setAutoCommit(false);
				
					crsPartiduak.acceptChanges(konexioaPartiduak);
					} catch (SQLException sqle) {
						System.out.println("Ez");
						sqle.printStackTrace();
						JOptionPane.showMessageDialog(null,(String)"Errorea. Ezin izan dira datuak gorde",
								"Errorea",JOptionPane.ERROR_MESSAGE,null);
						
					}
				}
			}
		});
		
		ErabiltzaileakKargatu();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 912, 709);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(44, 62, 80));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1072, 842);
		contentPane.add(layeredPane);
		layeredPane.setLayout(null);

		Menu = new JPanel();
		Menu.setLayout(null);
		Menu.setOpaque(false);
		Menu.setBorder(null);
		Menu.setBackground(Color.WHITE);
		Menu.setBounds(20, 510, 858, 63);
		layeredPane.add(Menu);

		btnTaldeak = new JButton("Taldeak");
		btnTaldeak.setFocusPainted(false);
		btnTaldeak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelTaldeak = true;
				panelJokalariak = false;
				panelKlasifikazioa = false;
				panelPartiduak = false;
				layeredPane.removeAll();
				Taldeak.setVisible(true);
				layeredPane.add(Taldeak);
				layeredPane.add(Menu);
				layeredPane.add(adminMenu);
				Menu.setVisible(true);
				layeredPane.repaint();
				layeredPane.revalidate();
				

			}
		});
		btnTaldeak.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnTaldeak.setFont(new Font("Tahoma", Font.BOLD, 21));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnTaldeak.setFont(new Font("Tahoma", Font.BOLD, 16));
			}
		});

		btnJokalariak = new JButton("Jokalariak");
		btnJokalariak.setRequestFocusEnabled(false);
		btnJokalariak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxJokalariTaldeak.getSelectedIndex() < 0) {
					TaldeComboboxKargatu();
				}

				panelTaldeak = false;
				panelJokalariak = true;
				panelKlasifikazioa = false;
				panelPartiduak = false;
				layeredPane.removeAll();
				Jokalariak.setVisible(true);
				layeredPane.add(Jokalariak);
				layeredPane.add(adminMenu);
				layeredPane.add(Menu);
				Menu.setVisible(true);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnJokalariak.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnJokalariak.setFont(new Font("Tahoma", Font.BOLD, 21));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnJokalariak.setFont(new Font("Tahoma", Font.BOLD, 16));
			}
		});

		btnPartiduak = new JButton("Partiduak");
		btnPartiduak.setRequestFocusEnabled(false);
		btnPartiduak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTaldeak = false;
				panelJokalariak = false;
				panelKlasifikazioa = false;
				panelPartiduak = true;
				layeredPane.removeAll();
				Partiduak.setVisible(true);
				layeredPane.add(Partiduak);
				layeredPane.add(Menu);
				layeredPane.add(adminMenu);
				Menu.setVisible(true);
				layeredPane.repaint();
				layeredPane.revalidate();

			}
		});
		btnPartiduak.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPartiduak.setFont(new Font("Tahoma", Font.BOLD, 21));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnPartiduak.setFont(new Font("Tahoma", Font.BOLD, 16));
			}
		});

		btnKlasifikazioa = new JButton("Klasifikazioa");
		btnKlasifikazioa.setRequestFocusEnabled(false);
		btnKlasifikazioa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTaldeak = false;
				panelJokalariak = false;
				panelKlasifikazioa = true;
				panelPartiduak = false;
				layeredPane.removeAll();
				Klasifikazioa.setVisible(true);
				layeredPane.add(Klasifikazioa);
				layeredPane.add(Menu);
				layeredPane.add(adminMenu);
				Menu.setVisible(true);
				layeredPane.repaint();
				layeredPane.revalidate();
				for(int j=0;j<AR_taldeak.size();j++) {
					 AR_taldeak.get(j).setPuntuak(0);
				 }
			for (int i=0;i<AR_taldeak.size();i++) {
				
				
				dlms.removeAllElements();
				String taldea=AR_taldeak.get(i).getIzena();
				for(int p = 0; p<AR_partiduak.size();p++) {
					if(taldea.equals(AR_partiduak.get(p).getLokala())) {
						 if(AR_partiduak.get(p).getEmaitzaLokala()>AR_partiduak.get(p).getEmaitzaKanpokoa()) {
							 int puntuak=AR_taldeak.get(i).getPuntuak();
							 puntuak=puntuak+1;
							 AR_taldeak.get(i).setPuntuak(puntuak);
						 }

							
					}
					
					else if(taldea.equals(AR_partiduak.get(p).getKanpokoa())) {
						 if(AR_partiduak.get(p).getEmaitzaLokala()<AR_partiduak.get(p).getEmaitzaKanpokoa()) {
							 int puntuak=AR_taldeak.get(i).getPuntuak();
							 puntuak=puntuak+1;
							 AR_taldeak.get(i).setPuntuak(puntuak);

				}
				}
					
					
					
			}
				
			}
			
			Collections.sort(AR_taldeak);
			
			for (int o=0;o<20;o++) {
				
				 dlms.addElement(AR_taldeak.get(o).Sailkapena());
			 }

		}
			
		}
		
		);
		
		btnKlasifikazioa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnKlasifikazioa.setFont(new Font("Tahoma", Font.BOLD, 21));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnKlasifikazioa.setFont(new Font("Tahoma", Font.BOLD, 16));
			}
		});

		btnAdmin = new JButton("Admin");
		btnAdmin.setRequestFocusEnabled(false);
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				Menu.setVisible(true);
				panelAdmin = true;

				if (panelTaldeak == true) {
					adminMenu.setVisible(true);
					adminMenu.setBounds(150, 518, 650, 110);
					Menu.setBounds(20, 620, 858, 83);
					setBounds(100, 100, 924, 727);
				}
				if (panelJokalariak == true) {
					adminMenu.setVisible(true);
					adminMenu.setBounds(150, 518, 550, 110);
					Menu.setBounds(17, 620, 858, 83);
					setBounds(100, 100, 924, 727);
				}

				if (panelPartiduak == true) {
					adminMenu.setVisible(true);
					adminMenu.setBounds(150, 518, 550, 110);
					Menu.setBounds(20, 640, 858, 83);
					setBounds(100, 100, 910, 763);
					;
				}

				if (panelKlasifikazioa == true) {
					adminMenu.setVisible(true);
					adminMenu.setBounds(150, 505, 550, 110);
					Menu.setBounds(5, 600, 858, 83);
					setBounds(100, 100, 924, 727);
				}

			}
		});
		btnAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAdmin.setFont(new Font("Tahoma", Font.BOLD, 21));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAdmin.setFont(new Font("Tahoma", Font.BOLD, 16));
			}
		});
		btnAdmin.setForeground(Color.WHITE);
		btnAdmin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdmin.setContentAreaFilled(false);
		btnAdmin.setBorderPainted(false);
		btnAdmin.setBorder(null);
		btnAdmin.setBounds(649, 11, 176, 61);
		Menu.add(btnAdmin);
		btnKlasifikazioa.setForeground(Color.WHITE);
		btnKlasifikazioa.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnKlasifikazioa.setContentAreaFilled(false);
		btnKlasifikazioa.setBorderPainted(false);
		btnKlasifikazioa.setBorder(null);
		btnKlasifikazioa.setBounds(507, 11, 168, 61);
		Menu.add(btnKlasifikazioa);
		btnPartiduak.setForeground(Color.WHITE);
		btnPartiduak.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPartiduak.setContentAreaFilled(false);
		btnPartiduak.setBorderPainted(false);
		btnPartiduak.setBorder(null);
		btnPartiduak.setBounds(357, 11, 161, 61);
		Menu.add(btnPartiduak);
		btnJokalariak.setForeground(Color.WHITE);
		btnJokalariak.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnJokalariak.setContentAreaFilled(false);
		btnJokalariak.setBorderPainted(false);
		btnJokalariak.setBorder(null);
		btnJokalariak.setBounds(213, 11, 158, 61);
		Menu.add(btnJokalariak);
		btnTaldeak.setRequestFocusEnabled(false);
		btnTaldeak.setForeground(Color.WHITE);
		btnTaldeak.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTaldeak.setContentAreaFilled(false);
		btnTaldeak.setBorderPainted(false);
		btnTaldeak.setBorder(null);
		btnTaldeak.setBounds(48, 11, 176, 61);
		Menu.add(btnTaldeak);

		Login = new JPanel();
		Login.setBackground(new Color(44, 62, 80));
		Login.setBounds(0, 0, 457, 479);
		layeredPane.add(Login);
		Login.setLayout(null);

		lblErabiltzailea = new JLabel("Erabiltzailea");
		lblErabiltzailea.setForeground(new Color(236, 240, 241));
		lblErabiltzailea.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblErabiltzailea.setHorizontalAlignment(SwingConstants.CENTER);
		lblErabiltzailea.setBounds(142, 93, 155, 43);
		Login.add(lblErabiltzailea);

		txtErabiltzaileaLogin = new JTextField();
		txtErabiltzaileaLogin.setForeground(Color.WHITE);
		txtErabiltzaileaLogin.setBorder(null);
		txtErabiltzaileaLogin.setBackground(new Color(108, 122, 137));
		txtErabiltzaileaLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtErabiltzaileaLogin.setBounds(104, 147, 243, 30);
		Login.add(txtErabiltzaileaLogin);
		txtErabiltzaileaLogin.setColumns(10);

		lblPasahitza = new JLabel("Pasahitza");
		lblPasahitza.setForeground(new Color(236, 240, 241));
		lblPasahitza.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasahitza.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPasahitza.setBounds(142, 188, 155, 43);
		Login.add(lblPasahitza);

		pwPasahitza = new JPasswordField();
		pwPasahitza.setForeground(Color.WHITE);
		pwPasahitza.setBorder(null);
		pwPasahitza.setBackground(new Color(108, 122, 137));
		pwPasahitza.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pwPasahitza.setEchoChar('*');
		pwPasahitza.setBounds(104, 242, 243, 30);
		Login.add(pwPasahitza);

		btnLogin = new JButton("");
		btnLogin.setRequestFocusEnabled(false);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				for(int i = 0; i<AR_erabiltzaileak.size();i++) {
					String myPass=String.valueOf(pwPasahitza.getPassword());
					
					
					if(AR_erabiltzaileak.get(i).getErabiltzailea().equals(txtErabiltzaileaLogin.getText())&&AR_erabiltzaileak.get(i).getPasahitza().equals(myPass)) {
						
						layeredPane.removeAll();
						Taldeak.setVisible(true);
						panelTaldeak = true;
						layeredPane.add(Taldeak);
						layeredPane.add(Menu);
						layeredPane.add(adminMenu);
						Menu.setVisible(true);
						setBounds(100, 100, 901, 627);
					}
					else {
					if(saiakerak > 0) {
						
						saiakerak = saiakerak - 1;
						JOptionPane.showMessageDialog(new JFrame(),
								"Erabiltzailea edo pasahitza txarto daude."
								+ "saiakerak: "+saiakerak, "ERROR",
								JOptionPane.ERROR_MESSAGE);

					}else {
						JOptionPane.showMessageDialog(new JFrame(),
								"Saiakerak gabe geratu zara administratzailearekin kontaktatu."
								, "ERROR",
								JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
				}
					
					
				}
				
			}
		});
		btnLogin.setBorderPainted(false);
		btnLogin.setBorder(null);
		btnLogin.setRolloverIcon(new ImageIcon(BizkaiBasketMain.class.getResource("/IMG/Login_37128(1).png")));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLogin.setVerticalTextPosition(SwingConstants.TOP);
		btnLogin.setVerticalAlignment(SwingConstants.TOP);
		btnLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setIcon(new ImageIcon(BizkaiBasketMain.class.getResource("/IMG/Login_37128.png")));
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setBounds(86, 335, 123, 109);
		Login.add(btnLogin);

		btnBezero = new JButton("");
		btnBezero.setRequestFocusEnabled(false);
		btnBezero.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnBezero.setRolloverIcon(
				new ImageIcon(BizkaiBasketMain.class.getResource("/IMG/1499345621-contact_85338(1).png")));
		btnBezero.setBorder(null);
		btnBezero.setContentAreaFilled(false);
		btnBezero.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBezero.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnBezero.setVerticalAlignment(SwingConstants.BOTTOM);
		btnBezero.setIcon(new ImageIcon(BizkaiBasketMain.class.getResource("/IMG/1499345621-contact_85338.png")));
		btnBezero.setBackground(new Color(255, 255, 255));
		btnBezero.setBounds(240, 283, 123, 125);
		Login.add(btnBezero);

		panelInfoLogin = new JPanel();
		panelInfoLogin.setBackground(new Color(248, 148, 6));
		panelInfoLogin.setBounds(0, 0, 457, 82);
		Login.add(panelInfoLogin);
		panelInfoLogin.setLayout(null);

		lblLoginInfo = new JLabel("Login");
		lblLoginInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginInfo.setForeground(new Color(255, 255, 255));
		lblLoginInfo.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblLoginInfo.setBounds(99, 11, 228, 60);
		panelInfoLogin.add(lblLoginInfo);

		lblSartu = new JLabel("Sartu");
		lblSartu.setForeground(new Color(255, 255, 255));
		lblSartu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSartu.setBounds(129, 430, 91, 14);
		Login.add(lblSartu);

		lblBezero = new JLabel("Bezero");
		lblBezero.setForeground(new Color(255, 255, 255));
		lblBezero.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBezero.setBounds(272, 430, 91, 14);
		Login.add(lblBezero);

		JButton btnGaztelera = new JButton("");
		btnGaztelera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblSartu.setText("Entrar");
				lblBezero.setText("Invitado");
				btnTaldeak.setText("Equipos");
				btnJokalariak.setText("Jugadores");
				btnPartiduak.setText("Partidos");
				btnKlasifikazioa.setText("Clasificacion");
				lblErabiltzailea.setText("Usuario");
				lblPasahitza.setText("Contraseña");
				lblInfoTaldeak.setText("Pantalla de Equipos");
				lblKodeaTaldea.setText("Codigo");
				lbTaldeIzena.setText("Nombre");
				lbTaldeHerria.setText("Pueblo");
				lbTaldeHelbide.setText("Correo electronico");
				lbTaldeZelaia.setText("Campo");
				lblJokalariIzena.setText("Nombre");
				lblJokalariAbizena.setText("Apellido");
				lblJokalariTaldea.setText("Equipo");
				lblNanJokalaria.setText("DNI");
				lblInfoJokalariak.setText("Pantalla de jugadores");
				lblInfoPartiduak.setText("Pantalla de partidos");
				lblKodeaPartidua.setText("Codigo");
				lblEtxekoa.setText("Local");
				lblKanpokoa.setText("Visitante");
				lblData.setText("Fecha");
				lblEmaitzaPartiduak.setText("Resutado");
				lblPostua.setText("Posicion");
				lblPuntuak.setText("Puntos");
				lblIzenaErabilztaile.setText("Nombre");
				lblAbizenaErabiltzaile.setText("Apellido");
				lblErabiltzailea.setText("Usuario");
				lblPasahitzaErabiltzaile.setText("Contraseña");
				//comboBoxBaimenak.setModel(new DefaultComboBoxModel<String>(new String[] { "Administrador", "Usuario" }));
				lblJarnudaldia.setText("Jornada");

			}
		});
		btnGaztelera.setContentAreaFilled(false);
		btnGaztelera
				.setPressedIcon(new ImageIcon(BizkaiBasketMain.class.getResource("/IMG/Spain_flags_flag_8858(1).png")));
		btnGaztelera.setIcon(new ImageIcon(BizkaiBasketMain.class.getResource("/IMG/Spain_flags_flag_8858.png")));
		btnGaztelera.setDefaultCapable(false);
		btnGaztelera.setBorderPainted(false);
		btnGaztelera.setBorder(null);
		btnGaztelera.setBounds(368, 147, 65, 43);
		Login.add(btnGaztelera);

		JButton btnEuskera = new JButton("");
		btnEuskera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEuskera.setPressedIcon(
				new ImageIcon(BizkaiBasketMain.class.getResource("/IMG/Basquecountry_flags_flag_9313(1).png")));
		btnEuskera.setIcon(new ImageIcon(BizkaiBasketMain.class.getResource("/IMG/Basquecountry_flags_flag_9313.png")));
		btnEuskera.setDefaultCapable(false);
		btnEuskera.setContentAreaFilled(false);
		btnEuskera.setBorderPainted(false);
		btnEuskera.setBorder(null);
		btnEuskera.setBounds(369, 228, 65, 43);
		Login.add(btnEuskera);
		

		Taldeak = new JPanel();
		Taldeak.setVisible(false);
		Taldeak.setBounds(0, 0, 1146, 508);
		Taldeak.setBackground(new Color(44, 62, 80));
		layeredPane.add(Taldeak);
		Taldeak.setLayout(null);

		panelInfoTaldeak = new JPanel();
		panelInfoTaldeak.setBounds(0, 0, 905, 43);
		panelInfoTaldeak.setBackground(new Color(248, 148, 6));
		Taldeak.add(panelInfoTaldeak);
		panelInfoTaldeak.setLayout(null);

		lblInfoTaldeak = new JLabel("Taldeak pantaila");
		lblInfoTaldeak.setForeground(new Color(255, 255, 255));
		lblInfoTaldeak.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblInfoTaldeak.setHorizontalTextPosition(SwingConstants.CENTER);
		lblInfoTaldeak.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoTaldeak.setBounds(306, 0, 295, 43);
		panelInfoTaldeak.add(lblInfoTaldeak);

		lblKodeaTaldea = new JLabel("Kodea");
		lblKodeaTaldea.setBounds(28, 69, 103, 35);
		lblKodeaTaldea.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblKodeaTaldea.setHorizontalAlignment(SwingConstants.CENTER);
		lblKodeaTaldea.setForeground(new Color(255, 255, 255));
		Taldeak.add(lblKodeaTaldea);

		lbTaldeIzena = new JLabel("Izena");
		lbTaldeIzena.setBounds(174, 69, 103, 35);
		lbTaldeIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lbTaldeIzena.setForeground(Color.WHITE);
		lbTaldeIzena.setFont(new Font("Tahoma", Font.BOLD, 18));
		Taldeak.add(lbTaldeIzena);

		lbTaldeHerria = new JLabel("Herria");
		lbTaldeHerria.setBounds(336, 69, 103, 35);
		lbTaldeHerria.setHorizontalAlignment(SwingConstants.CENTER);
		lbTaldeHerria.setForeground(Color.WHITE);
		lbTaldeHerria.setFont(new Font("Tahoma", Font.BOLD, 18));
		Taldeak.add(lbTaldeHerria);

		lbTaldeHelbide = new JLabel("Helbide elektronikoa");
		lbTaldeHelbide.setBounds(513, 69, 187, 35);
		lbTaldeHelbide.setHorizontalAlignment(SwingConstants.CENTER);
		lbTaldeHelbide.setForeground(Color.WHITE);
		lbTaldeHelbide.setFont(new Font("Tahoma", Font.BOLD, 18));
		Taldeak.add(lbTaldeHelbide);

		lbTaldeZelaia = new JLabel("Zelaia");
		lbTaldeZelaia.setBounds(769, 69, 103, 35);
		lbTaldeZelaia.setHorizontalAlignment(SwingConstants.CENTER);
		lbTaldeZelaia.setForeground(Color.WHITE);
		lbTaldeZelaia.setFont(new Font("Tahoma", Font.BOLD, 18));
		Taldeak.add(lbTaldeZelaia);

		txtTaldeKodea = new JTextField();
		txtTaldeKodea.setForeground(Color.WHITE);
		txtTaldeKodea.setBounds(28, 115, 103, 29);
		txtTaldeKodea.setBackground(new Color(108, 122, 137));
		Taldeak.add(txtTaldeKodea);
		txtTaldeKodea.setColumns(10);

		txtTaldeIzena = new JTextField();
		txtTaldeIzena.setForeground(Color.WHITE);
		txtTaldeIzena.setBounds(174, 115, 103, 29);
		txtTaldeIzena.setBackground(new Color(108, 122, 137));
		txtTaldeIzena.setColumns(10);
		Taldeak.add(txtTaldeIzena);

		txtTaldeHerria = new JTextField();
		txtTaldeHerria.setForeground(Color.WHITE);
		txtTaldeHerria.setBounds(336, 115, 103, 29);
		txtTaldeHerria.setColumns(10);
		txtTaldeHerria.setBackground(new Color(108, 122, 137));
		Taldeak.add(txtTaldeHerria);

		txtTaldeHelbide = new JTextField();
		txtTaldeHelbide.setText("@BikaiaBasket.com");
		txtTaldeHelbide.setForeground(Color.WHITE);
		txtTaldeHelbide.setBounds(500, 115, 214, 29);
		txtTaldeHelbide.setColumns(10);
		txtTaldeHelbide.setBackground(new Color(108, 122, 137));
		Taldeak.add(txtTaldeHelbide);

		txtTaldeZelaia = new JTextField();
		txtTaldeZelaia.setForeground(Color.WHITE);
		txtTaldeZelaia.setBounds(769, 115, 103, 29);
		txtTaldeZelaia.setColumns(10);
		txtTaldeZelaia.setBackground(new Color(108, 122, 137));
		Taldeak.add(txtTaldeZelaia);

		scrollPaneTaldea = new JScrollPane();
		scrollPaneTaldea.setBounds(28, 172, 844, 334);
		Taldeak.add(scrollPaneTaldea);

		dlmt = new DefaultListModel<Taldeak>();
		listTaldeak = new JList<Taldeak>();
		listTaldeak.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtTaldeKodea.setText(dlmt.getElementAt(listTaldeak.getSelectedIndex()).getKodea());
				txtTaldeIzena.setText(dlmt.getElementAt(listTaldeak.getSelectedIndex()).getIzena());
				txtTaldeHerria.setText(dlmt.getElementAt(listTaldeak.getSelectedIndex()).getHerria());
				txtTaldeHelbide.setText(dlmt.getElementAt(listTaldeak.getSelectedIndex()).getHelbideElektronikoa());
				txtTaldeZelaia.setText(dlmt.getElementAt(listTaldeak.getSelectedIndex()).getZelaia());
			}
		});
		TaldeDatabaseKargatu();
		listTaldeak.setFont(new Font("Tahoma", Font.BOLD, 16));
		listTaldeak.setModel(dlmt);
		listTaldeak.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneTaldea.setViewportView(listTaldeak);

		adminMenu = new JPanel();
		adminMenu.setVisible(false);
		adminMenu.setOpaque(false);
		adminMenu.setBorder(null);
		adminMenu.setBounds(92, 519, 709, 99);
		layeredPane.add(adminMenu);
		adminMenu.setLayout(null);

		btnGehi = new JButton("");
		btnGehi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (panelTaldeak == true) {
					if (txtTaldeHelbide.getText().isEmpty() || txtTaldeHerria.getText().isEmpty()
							|| txtTaldeIzena.getText().isEmpty() || txtTaldeKodea.getText().isEmpty()
							|| txtTaldeZelaia.getText().isEmpty()) {
						JOptionPane.showMessageDialog(new JFrame(), "Mesedez ez utzi eremu hutsak ", "ERROR",
								JOptionPane.WARNING_MESSAGE);
					} else {
						if (dlmt.size() < 20) {
							Connection konexioa;
							try {
								konexioa = DriverManager.getConnection("jdbc:mysql://localhost/bizkaiabasket", "root",
										"");
								Statement st = konexioa.createStatement();
								st.executeUpdate("INSERT INTO equipo  VALUES ('" + txtTaldeKodea.getText() + "','"
										+ txtTaldeIzena.getText() + "','" + txtTaldeHerria.getText() + "','"
										+ txtTaldeZelaia.getText() + "','" + txtTaldeHelbide.getText() + "')");
								Taldeak ObJTaldea = new Taldeak(txtTaldeKodea.getText(), txtTaldeIzena.getText(),
										txtTaldeHerria.getText(), txtTaldeHelbide.getText(), txtTaldeZelaia.getText());
								AR_taldeak.add(ObJTaldea);
								dlmt.addElement(ObJTaldea);	
								comboBoxJokalariTaldeak.addItem(ObJTaldea.getIzena());
								comboBoxJokalariKod_Klub.addItem(ObJTaldea.getKodea().toString());
								
							} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
								JOptionPane.showMessageDialog(new JFrame(),
										"Errorea taldea sartzean, datuak txarto daude ", "ERROR",
										JOptionPane.ERROR_MESSAGE);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						} else {
							JOptionPane.showMessageDialog(new JFrame(), "Bakarrik 20 talde sortu ahal dira ", "ERROR",
									JOptionPane.WARNING_MESSAGE);
						}

					}
				}

				if (panelJokalariak == true) {
					if (txtJokalariaNan.getText().isEmpty() || txtJokalariaIzena.getText().isEmpty()
							|| txtJokalariaAbizena.getText().isEmpty()) {
						JOptionPane.showMessageDialog(new JFrame(), "Mesedez ez utzi eremu hutsak ", "ERROR",
								JOptionPane.WARNING_MESSAGE);
					} else {

						if (dlmj.size() < 300) {
							try {
								Connection konexioa =  DriverManager.getConnection("jdbc:mysql://localhost/bizkaiabasket", "root",
										"");
								Statement st = konexioa.createStatement();
								
								Jokalariak ObjJokalariak = new Jokalariak(txtJokalariaNan.getText(),
										txtJokalariaIzena.getText(), txtJokalariaAbizena.getText(),
										comboBoxJokalariTaldeak.getSelectedItem().toString());
								
								
								
								if (ObjJokalariak.NanBalidatu()==true) {
									st.executeUpdate("INSERT INTO jugadores  VALUES ('" + txtJokalariaNan.getText() + "','"
											+ txtJokalariaAbizena.getText() + "','" + txtJokalariaIzena.getText() + "','"
											+ comboBoxJokalariKod_Klub.getSelectedItem().toString() + "')");
									AR_jokalariak.add(ObjJokalariak);
									dlmj.addElement(ObjJokalariak);
									aldatutaTaldeak = true;
									if (aldatutaTaldeak = true) {
										try {
											System.out.println("Gordetzen...");
											FileOutputStream fos = new FileOutputStream("Jokalariak.dat", false);
											ObjectOutputStream oos = new ObjectOutputStream(fos);
											oos.writeObject(AR_jokalariak);
											oos.close();
											
											System.out.println("Aguraaa");
											
											

										} catch (IOException e) {
											e.printStackTrace();
											System.out.println("ERROR");
										}
									}else {
										System.out.println("Agur");
									}
								} else {
									JOptionPane.showMessageDialog(new JFrame(), "Nan datuak txarto daude ", "ERROR",
											JOptionPane.ERROR_MESSAGE);
								}
								
							}catch(java.sql.SQLIntegrityConstraintViolationException e1) {
								
								JOptionPane.showMessageDialog(new JFrame(), "Nan datuak txarto daude ", "ERROR",
										JOptionPane.ERROR_MESSAGE);
								
							}catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							

						} else {
							JOptionPane.showMessageDialog(new JFrame(), "Jokalari limitea gaindituta ", "ERROR",
									JOptionPane.WARNING_MESSAGE);
						}
					}
				}

				if (panelPartiduak == true) {
					if (txtKodeaPartiduak.getText().isEmpty() || txtEtxekoPartiduak.getText().isEmpty()
							|| txtKanpokoPartiduak.getText().isEmpty() || txtData.getText().isEmpty()
							|| txtEmaitzaLokala.getText().isEmpty() || txtEmaitzaKanpokoa.getText().isEmpty()) {
						JOptionPane.showMessageDialog(new JFrame(), "Mesedez ez utzi eremu hutsak ", "ERROR",
								JOptionPane.WARNING_MESSAGE);
					} else {
						if (dlmp.size() < 380) {
							
							
							int emaitzaLokala = Integer.parseInt(txtEmaitzaLokala.getText());
							int emaitzaKanpokoa = Integer.parseInt(txtEmaitzaKanpokoa.getText());
							int Jardunaldia = Integer.parseInt(spinnerJardunaldia.getValue().toString());
							Partiduak objPartiduak = new Partiduak(txtKodeaPartiduak.getText(),Jardunaldia,
									txtEtxekoPartiduak.getText(), txtKanpokoPartiduak.getText(), txtData.getText(),
									emaitzaLokala, emaitzaKanpokoa);
							dlmp.addElement(objPartiduak);
							AR_partiduak.add(objPartiduak);
						} else {
							JOptionPane.showMessageDialog(new JFrame(), "Partidu limitea gaindituta ", "ERROR",
									JOptionPane.WARNING_MESSAGE);
						}
					}
				}

				if (panelErabiltzaile == true) {
					if (txtIzenaErabiltzaile.getText().isEmpty() || txtAbizenaErabiltzaile.getText().isEmpty()
							|| txterabiltzaileaErabiltzaile.getText().isEmpty()
							|| txtPasahitzaErabiltzaile.getText().isEmpty()) {
						JOptionPane.showMessageDialog(new JFrame(), "Mesedez  ez utzi eremu hutsak ", "ERROR",
								JOptionPane.WARNING_MESSAGE);
					} else {
						if (comboBoxBaimenak.getSelectedItem().equals("Administratzailea")) {
							EntityManagerFactory emf =
									Persistence.createEntityManagerFactory("$objectdb/db/Erabiltzaileak.odb");
									EntityManager em = emf.createEntityManager();
									
									em.getTransaction().begin();
	
									Administratzaileak objAdmin = new Administratzaileak(txtIzenaErabiltzaile.getText(),
											txtAbizenaErabiltzaile.getText(), txterabiltzaileaErabiltzaile.getText(),
											txtPasahitzaErabiltzaile.getText(), comboBoxBaimenak.getSelectedItem().toString());
									dlme.addElement(objAdmin);
									AR_erabiltzaileak.add(objAdmin);
									em.persist(objAdmin);
									em.getTransaction().commit();
									
							
						} else {
							EntityManagerFactory emf =
							Persistence.createEntityManagerFactory("$objectdb/db/Erabiltzaileak.odb");
							EntityManager em = emf.createEntityManager();
							
							em.getTransaction().begin();
							
							Erabiltzaileak objErabiltzaileak = new Erabiltzaileak(txtIzenaErabiltzaile.getText(),
									txtAbizenaErabiltzaile.getText(), txterabiltzaileaErabiltzaile.getText(),
									txtPasahitzaErabiltzaile.getText(), comboBoxBaimenak.getSelectedItem().toString());
							dlme.addElement(objErabiltzaileak);
							AR_erabiltzaileak.add(objErabiltzaileak);
							em.persist(objErabiltzaileak);
							em.getTransaction().commit();
						}
					}
				}
			}

		});
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setVisible(true);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int kodeaPartidu = 0;
				for(int i=0;i<19;i++) {

					for(int j=0;j<20;j=j+2) {
						
						String lokala=dlmt.get(Jardunaldiak[i][j]).getIzena();
						String kanpokoa=dlmt.get(Jardunaldiak[i][j+1]).getIzena();
						String KodeaFinala="";
						kodeaPartidu = kodeaPartidu+1;
						if(i<9) {
							
							KodeaFinala= "0"+(i+1)+"-"+kodeaPartidu;
						}
						else {
							KodeaFinala= (i+1)+"-"+kodeaPartidu;
						}
						
						
						
						Partiduak ObjPartiduak = new Partiduak(KodeaFinala,lokala, kanpokoa,i+1);
						ObjPartiduak.EmaitzaRandom();
						
						
						
						
						try {
							konexioaPartiduak =DriverManager.getConnection("jdbc:mysql://localhost/bizkaiabasket", "root","");
							konexioaPartiduak.setAutoCommit(false);
							RowSetFactory myRowSetFactory = null;
							myRowSetFactory = RowSetProvider.newFactory();
							crsPartiduak = myRowSetFactory.createCachedRowSet();
							System.out.println("Konexio egokia");
							
							
							try {

								crsPartiduak.setCommand("SELECT * FROM partidos");
								crsPartiduak.execute(konexioaPartiduak);
						
								crsPartiduak.moveToInsertRow();
								crsPartiduak.updateString(1, ObjPartiduak.getKodea());
								crsPartiduak.updateString(2, ObjPartiduak.getData());
								crsPartiduak.updateString(3, ObjPartiduak.getLokala());
								crsPartiduak.updateString(4, ObjPartiduak.getKanpokoa());
								String Jardunaldia= String.valueOf(ObjPartiduak.getJardunaldia());
								crsPartiduak.updateString(5, Jardunaldia);
								String emaitzaLokala= String.valueOf(ObjPartiduak.getEmaitzaLokala());

								crsPartiduak.updateString(6, emaitzaLokala);
								String emaitzaKanpokoa= String.valueOf(ObjPartiduak.getEmaitzaKanpokoa());
								crsPartiduak.updateString(7, emaitzaKanpokoa);
								crsPartiduak.insertRow();
								crsPartiduak.moveToCurrentRow();
								
								// sartutako datuak eguneratu
								aldatuta = true; 
								
								// Daturen bat aldatu baldin bada
								/*if (aldatuta){
									try{
									
									// Ondo konektatu baldin bada
									// datuen eguneratze automatikoa desgaitu
									konexioa.setAutoCommit(false);
									crs.acceptChanges(konexioa);
									} catch (SQLException sqle) {
										System.out.println("Ez");
										sqle.printStackTrace();
										JOptionPane.showMessageDialog(null,(String)"Errorea. Ezin izan dira datuak gorde",
												"Errorea",JOptionPane.ERROR_MESSAGE,null);
										
									}
								} */
								
							}catch (SQLIntegrityConstraintViolationException mslcve) {
								System.out.println("Ikasle hori badago datubasean");
							}catch (SQLException sqle){
								// ez baldin bada konexioa era egokian egin
								sqle.printStackTrace();
								System.out.println("Insert errorea");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						AR_partiduak.add(ObjPartiduak);
						dlmp.addElement(ObjPartiduak);
						
						
					}
					kodeaPartidu=0;
					
				
				}
				
				for(int i=0;i<19;i++) {
					
						
					
					//10 Partiduak sortzeko
					for(int j=0;j<20;j=j+2) {
						String kanpokoa=dlmt.get(Jardunaldiak[i][j+1]).getIzena();
						String lokala=dlmt.get(Jardunaldiak[i][j]).getIzena();
						
						String KodeaFinala="";
						kodeaPartidu = kodeaPartidu+1;
							
							KodeaFinala= (20+i)+"-"+kodeaPartidu;
						
						
						
						
						Partiduak ObjPartiduak = new Partiduak(KodeaFinala,kanpokoa,lokala,20+i);
						
						ObjPartiduak.EmaitzaRandom();
						
						Connection konexioa;
						CachedRowSet crs;
						
						
						try {
							konexioa =DriverManager.getConnection("jdbc:mysql://localhost/bizkaiabasket", "root","");
							konexioa.setAutoCommit(false);
							RowSetFactory myRowSetFactory = null;
							myRowSetFactory = RowSetProvider.newFactory();
							crs = myRowSetFactory.createCachedRowSet();
							System.out.println("Konexio egokia");
							
							
							try {

									crs.setCommand("SELECT * FROM partidos");
									crs.execute(konexioa);
						
									crs.moveToInsertRow();
									crs.updateString(1, ObjPartiduak.getKodea());
									crs.updateString(2, ObjPartiduak.getData());
									crs.updateString(3, ObjPartiduak.getLokala());
									crs.updateString(4, ObjPartiduak.getKanpokoa());
									String Jardunaldia= String.valueOf(ObjPartiduak.getJardunaldia());
									crs.updateString(5, Jardunaldia);
									String emaitzaLokala= String.valueOf(ObjPartiduak.getEmaitzaLokala());

									crs.updateString(6, emaitzaLokala);
									String emaitzaKanpokoa= String.valueOf(ObjPartiduak.getEmaitzaKanpokoa());
									crs.updateString(7, emaitzaKanpokoa);
									crs.insertRow();
									crs.moveToCurrentRow();
								
								// sartutako datuak eguneratu
								aldatuta = true; 
								
								// Daturen bat aldatu baldin bada
								if (aldatuta){
									try{
									
									// Ondo konektatu baldin bada
									// datuen eguneratze automatikoa desgaitu
									konexioa.setAutoCommit(false);
									crs.acceptChanges(konexioa);
									} catch (SQLException sqle) {
										System.out.println("Ez");
										sqle.printStackTrace();
										JOptionPane.showMessageDialog(null,(String)"Errorea. Ezin izan dira datuak gorde",
												"Errorea",JOptionPane.ERROR_MESSAGE,null);
										
									}
								} 
								
							}catch (SQLIntegrityConstraintViolationException mslcve) {
								System.out.println("Ikasle hori badago datubasean");
							}catch (SQLException sqle){
								// ez baldin bada konexioa era egokian egin
								sqle.printStackTrace();
								System.out.println("Insert errorea");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						AR_partiduak.add(ObjPartiduak);
						dlmp.addElement(ObjPartiduak);
					
					}
					kodeaPartidu=0;
			}
		}
		}
		);
		btnNewButton.setBounds(577, 55, 89, 23);
		adminMenu.add(btnNewButton);
		btnGehi.setRequestFocusEnabled(false);
		btnGehi.setPressedIcon(new ImageIcon(BizkaiBasketMain.class.getResource("/IMG/sign-add-icon_34367(1).png")));
		btnGehi.setContentAreaFilled(false);
		btnGehi.setBorder(null);
		btnGehi.setBorderPainted(false);
		btnGehi.setIcon(new ImageIcon(BizkaiBasketMain.class.getResource("/IMG/sign-add-icon_34367.png")));
		btnGehi.setBounds(10, 11, 145, 67);
		adminMenu.add(btnGehi);

		btnEzabatu = new JButton("");
		btnEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (panelTaldeak == true) {
					if (!listTaldeak.isSelectionEmpty()) {
						Statement st;
						Connection konexioa;
						try {
							konexioa = DriverManager.getConnection("jdbc:mysql://localhost/bizkaiabasket", "root", "");
							st = konexioa.createStatement();
							st.executeUpdate("DELETE FROM equipo WHERE Cod_club='" + txtTaldeKodea.getText() + "'");
							comboBoxJokalariTaldeak.removeItem(dlmt.get(listTaldeak.getSelectedIndex()).getIzena());
							comboBoxJokalariKod_Klub.removeItem(dlmt.get(listTaldeak.getSelectedIndex()).getKodea());
							dlmt.remove(listTaldeak.getSelectedIndex());
							AR_taldeak.remove(listTaldeak.getSelectedIndex());
							

						} catch (java.sql.SQLIntegrityConstraintViolationException a1) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Talde horretan jokalariak daude, mesedez ezabatu talde horeen jokalari guztiak ",
									"ERROR", JOptionPane.ERROR_MESSAGE);

						}

						catch (SQLException e1) {

							e1.printStackTrace();
						}

					} else {
						JOptionPane.showMessageDialog(new JFrame(), "Mesedez klik egin talde baten ", "ERROR",
								JOptionPane.WARNING_MESSAGE);
					}
				}

				if (panelJokalariak == true) {
					if (!listJokalariak.isSelectionEmpty()) {
						Statement st;
						Connection konexioa;
						try {
							konexioa = DriverManager.getConnection("jdbc:mysql://localhost/bizkaiabasket", "root", "");
							st = konexioa.createStatement();
							st.executeUpdate("DELETE FROM jugadores WHERE DNI='" + txtJokalariaNan.getText() + "'");
							dlmj.remove(listJokalariak.getSelectedIndex());
							AR_jokalariak.remove(listJokalariak.getSelectedIndex());

						} catch (SQLException e1) {
							e1.printStackTrace();

						}
					} else {
						JOptionPane.showMessageDialog(new JFrame(), "Mesedez klik egin jokalari baten ", "ERROR",
								JOptionPane.WARNING_MESSAGE);
					}
				}

				if (panelPartiduak == true) {
					JOptionPane.showMessageDialog(new JFrame(), "Partiduak ezin dira ezabatu ", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

				if (panelErabiltzaile == true) {
					if (!listErabiltzaileak.isSelectionEmpty()) {
						
						EntityManagerFactory emf =
								Persistence.createEntityManagerFactory("$objectdb/db/Erabiltzaileak.odb");
								EntityManager em = emf.createEntityManager();
								String Katea = "DELETE FROM Erabiltzaileak  WHERE Erabiltzailea='" + txterabiltzaileaErabiltzaile.getText() + "'";
								System.out.println(Katea);
								Query q0 = em.createQuery(Katea);
								em.getTransaction().begin();
								q0.executeUpdate();
								em.getTransaction().commit();
						dlme.remove(listErabiltzaileak.getSelectedIndex());
						AR_erabiltzaileak.remove(listErabiltzaileak.getSelectedIndex());
						
						
						
					} else {
						JOptionPane.showMessageDialog(new JFrame(), "Mesedez klik egin partidu baten ", "ERROR",
								JOptionPane.WARNING_MESSAGE);
					}
				}

			}
		});
		btnEzabatu.setRequestFocusEnabled(false);
		btnEzabatu.setVerticalTextPosition(SwingConstants.TOP);
		btnEzabatu.setVerticalAlignment(SwingConstants.TOP);
		btnEzabatu.setPressedIcon(
				new ImageIcon(BizkaiBasketMain.class.getResource("/IMG/sign-delete-icon_34364(1).png")));
		btnEzabatu.setIcon(new ImageIcon(BizkaiBasketMain.class.getResource("/IMG/sign-delete-icon_34364.png")));
		btnEzabatu.setContentAreaFilled(false);
		btnEzabatu.setBorderPainted(false);
		btnEzabatu.setBorder(null);
		btnEzabatu.setBounds(130, 11, 145, 87);
		adminMenu.add(btnEzabatu);

		btnAldatu = new JButton("");
		btnAldatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (panelTaldeak == true) {
					Connection konexioa;
					Statement st;
					if (!listTaldeak.isSelectionEmpty()) {
						
						try {
							konexioa = DriverManager.getConnection("jdbc:mysql://localhost/bizkaiabasket", "root", "");
							st = konexioa.createStatement();
							st.executeUpdate("UPDATE equipo SET Nombre='"+txtTaldeIzena.getText()+"',Municipio='"+txtTaldeHerria.getText()+"',Estadio='"+txtTaldeZelaia.getText()+"',Correo='"+txtTaldeHelbide.getText()+"' WHERE Cod_club='"+txtTaldeKodea.getText()+"'");

						} catch(java.sql.SQLIntegrityConstraintViolationException e2) {
							JOptionPane.showMessageDialog(new JFrame(), "Datuak txarto jarrita", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}
						catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						Taldeak ObJTaldea = new Taldeak(txtTaldeKodea.getText(), txtTaldeIzena.getText(),
								txtTaldeHerria.getText(), txtTaldeHelbide.getText(), txtTaldeZelaia.getText());
						dlmt.set(listTaldeak.getSelectedIndex(), ObJTaldea);
						AR_taldeak.set(listTaldeak.getSelectedIndex(), ObJTaldea);
					} else {
						JOptionPane.showMessageDialog(new JFrame(), "Mesedez klik egin talde baten ", "ERROR",
								JOptionPane.WARNING_MESSAGE);
					}
				}

				if (panelJokalariak == true) {
					Connection konexioa;
					Statement st;
					if (!listJokalariak.isSelectionEmpty()) {
						String nan = txtJokalariaNan.getText();
						try {
							konexioa = DriverManager.getConnection("jdbc:mysql://localhost/bizkaiabasket", "root", "");
							st = konexioa.createStatement();
							Jokalariak objJokalari = new Jokalariak(txtJokalariaNan.getText(), txtJokalariaIzena.getText(),
									txtJokalariaAbizena.getText(), comboBoxJokalariTaldeak.getSelectedItem().toString());
							
							if (objJokalari.NanBalidatu() == true) {
								String katea = "UPDATE jugadores SET Apellido='"+txtJokalariaAbizena.getText()+"',Nombre='"+txtJokalariaIzena.getText()+"',Cod_club='"+comboBoxJokalariKod_Klub.getSelectedItem().toString()+"' WHERE DNI='"+nan+"'";
								dlmj.set(listJokalariak.getSelectedIndex(), objJokalari);
								AR_jokalariak.set(listJokalariak.getSelectedIndex(), objJokalari);
								st.executeUpdate(katea);
								
							} else {
								JOptionPane.showMessageDialog(new JFrame(), "Nan datuak txarto jarrita ", "ERROR",
										JOptionPane.WARNING_MESSAGE);
							}

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						
					} else {
						JOptionPane.showMessageDialog(new JFrame(), "Mesedez klik egin jokalari baten ", "ERROR",
								JOptionPane.WARNING_MESSAGE);
					}
				}

				if (panelPartiduak == true) {
					if (!listPartiduak.isSelectionEmpty()) {

						int emaitzaLokala = Integer.parseInt(txtEmaitzaLokala.getText());
						int emaitzaKanpokoa = Integer.parseInt(txtEmaitzaKanpokoa.getText());
						
						
						Partiduak objPartidua = new Partiduak(txtKodeaPartiduak.getText(), (int)spinnerJardunaldia.getValue(),txtEtxekoPartiduak.getText(),
								txtKanpokoPartiduak.getText(), txtData.getText(), emaitzaLokala, emaitzaKanpokoa);
						//UPDATE-a egin
						try {
							Connection konexioa;
							CachedRowSet crs;
							
							konexioa =DriverManager.getConnection("jdbc:mysql://localhost/bizkaiabasket", "root","");
							// datuen eguneratze automatikoa desgaitu
							konexioa.setAutoCommit(false);
							// CachedRowSet eratu
							
							RowSetFactory myRowSetFactory = null;
							myRowSetFactory = RowSetProvider.newFactory();
							crs = myRowSetFactory.createCachedRowSet();
							crs.setCommand("SELECT Cod_partido FROM partidos");
							crs.execute(konexioa);
						
							int cont = 0;
							while (crs.next()){
								System.out.println(cont);
								cont = cont+1;
								System.out.println("BAT");
								System.out.println(crs.getObject("Cod_partido").toString());
								System.out.println(txtKodeaPartiduak.getText());
								if (crs.getObject("Cod_partido").equals (txtKodeaPartiduak.getText())) {
									
									System.out.println("BI");
									crs.updateString(2,"2020-02-02");
									crs.updateString(3, objPartidua.getLokala());
									crs.updateString(4, objPartidua.getKanpokoa());
									crs.updateInt(5, objPartidua.getJardunaldia());
									crs.updateInt(6, objPartidua.getEmaitzaLokala());
									crs.updateInt(7, objPartidua.getEmaitzaKanpokoa());
									crs.updateRow();
									aldatuta=true;		
									}
								if (aldatuta==true){
									try{
										System.out.println("Hiru");
										System.out.println("dentro if");
									// Ondo konektatu baldin bada
									// datuen eguneratze automatikoa desgaitu
									konexioa.setAutoCommit(false);
									crs.acceptChanges(konexioa);
									dlmp.set(listPartiduak.getSelectedIndex(), objPartidua);
									AR_partiduak.set(listPartiduak.getSelectedIndex(), objPartidua);
									System.out.println("Updatea ondo eginda");
									} catch (SQLException sqle) {
										System.out.println("Ez");
										sqle.printStackTrace();
										JOptionPane.showMessageDialog(null,(String)"Errorea. Ezin izan dira datuak gorde",
												"Errorea",JOptionPane.ERROR_MESSAGE,null);
										
									}
								} 
								
							}
							
							
							
							
						}catch (SQLException sqle){
							// ez baldin bada konexioa era egokian egin
							sqle.printStackTrace();
							System.out.println("Update errorea");
						}
						
					} else {
						JOptionPane.showMessageDialog(new JFrame(), "Mesedez klik egin partidu baten ", "ERROR",
								JOptionPane.WARNING_MESSAGE);
					}
				}

				if (panelErabiltzaile == true) {
					if (!listErabiltzaileak.isSelectionEmpty()) {

						if (comboBoxBaimenak.getSelectedItem().equals("Administratzailea")) {
							
							EntityManagerFactory emf =
									Persistence.createEntityManagerFactory("$objectdb/db/Erabiltzaileak.odb");
									EntityManager em = emf.createEntityManager();
							Query q2 = em.createQuery("UPDATE Erabiltzaileak SET Izena='"+txtIzenaErabiltzaile.getText()+"',Abizena='"+txtAbizenaErabiltzaile.getText()+"',Pasahitza='"+txtPasahitzaErabiltzaile.getText()+"', Baimenak='"+comboBoxBaimenak.getSelectedItem()+"' WHERE Erabiltzailea='"+txterabiltzaileaErabiltzaile.getText()+"'");
							em.getTransaction().begin();
							q2.executeUpdate();
							em.getTransaction().commit();
							
							em.close();
							emf.close();
							Administratzaileak objAdmin = new Administratzaileak(txtIzenaErabiltzaile.getText(),
									txtAbizenaErabiltzaile.getText(), txterabiltzaileaErabiltzaile.getText(),
									txtPasahitzaErabiltzaile.getText(), comboBoxBaimenak.getSelectedItem().toString());
							dlme.set(listErabiltzaileak.getSelectedIndex(), objAdmin);
							AR_erabiltzaileak.set(listErabiltzaileak.getSelectedIndex(), objAdmin);
						} else {
							Erabiltzaileak objErabiltzaileak = new Erabiltzaileak(txtIzenaErabiltzaile.getText(),
									txtAbizenaErabiltzaile.getText(), txterabiltzaileaErabiltzaile.getText(),
									txtPasahitzaErabiltzaile.getText(), comboBoxBaimenak.getSelectedItem().toString());
							dlme.set(listErabiltzaileak.getSelectedIndex(), objErabiltzaileak);
							AR_erabiltzaileak.set(listErabiltzaileak.getSelectedIndex(), objErabiltzaileak);
						}
					}

					else {
						JOptionPane.showMessageDialog(new JFrame(), "Mesedez klik egin erabiltzaile batean ", "ERROR",
								JOptionPane.WARNING_MESSAGE);
					}
				}

			}
		});
		btnAldatu.setRequestFocusEnabled(false);
		btnAldatu.setPressedIcon(new ImageIcon(BizkaiBasketMain.class
				.getResource("/IMG/1486504369-change-edit-options-pencil-settings-tools-write_81307(1).png")));
		btnAldatu.setIcon(new ImageIcon(BizkaiBasketMain.class
				.getResource("/IMG/1486504369-change-edit-options-pencil-settings-tools-write_81307.png")));
		btnAldatu.setVerticalTextPosition(SwingConstants.TOP);
		btnAldatu.setVerticalAlignment(SwingConstants.TOP);
		btnAldatu.setContentAreaFilled(false);
		btnAldatu.setBorderPainted(false);
		btnAldatu.setBorder(null);
		btnAldatu.setBounds(259, 11, 145, 87);
		adminMenu.add(btnAldatu);

		btnErabiltzaileak = new JButton("");
		btnErabiltzaileak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelTaldeak = false;
				panelJokalariak = false;
				panelKlasifikazioa = false;
				panelPartiduak = false;
				panelErabiltzaile = true;
				layeredPane.removeAll();
				Erabiltzaileak.setVisible(true);
				layeredPane.add(Erabiltzaileak);
				layeredPane.add(Menu);
				layeredPane.add(adminMenu);
				Menu.setVisible(true);

				setBounds(100, 100, 913, 750);
			}
		});
		btnErabiltzaileak.setFocusPainted(false);
		btnErabiltzaileak.setRequestFocusEnabled(false);
		btnErabiltzaileak.setPressedIcon(new ImageIcon(BizkaiBasketMain.class
				.getResource("/IMG/business_application_addmale_useradd_insert_add_user_client_2312(1).png")));
		btnErabiltzaileak.setIcon(new ImageIcon(BizkaiBasketMain.class
				.getResource("/IMG/business_application_addmale_useradd_insert_add_user_client_2312.png")));
		btnErabiltzaileak.setContentAreaFilled(false);
		btnErabiltzaileak.setBorder(null);
		btnErabiltzaileak.setBounds(395, 0, 145, 98);
		adminMenu.add(btnErabiltzaileak);
		

		Jokalariak = new JPanel();
		Jokalariak.setVisible(false);
		Jokalariak.setLayout(null);
		Jokalariak.setBackground(new Color(44, 62, 80));
		Jokalariak.setBounds(0, 0, 905, 508);
		layeredPane.add(Jokalariak);

		panelInfoJokalariak = new JPanel();
		panelInfoJokalariak.setLayout(null);
		panelInfoJokalariak.setBackground(new Color(248, 148, 6));
		panelInfoJokalariak.setBounds(0, 0, 905, 43);
		Jokalariak.add(panelInfoJokalariak);

		lblInfoJokalariak = new JLabel("Jokalari pantaila");
		lblInfoJokalariak.setHorizontalTextPosition(SwingConstants.CENTER);
		lblInfoJokalariak.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoJokalariak.setForeground(Color.WHITE);
		lblInfoJokalariak.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblInfoJokalariak.setBounds(306, 0, 295, 43);
		panelInfoJokalariak.add(lblInfoJokalariak);

		lblNanJokalaria = new JLabel("Nan");
		lblNanJokalaria.setHorizontalAlignment(SwingConstants.CENTER);
		lblNanJokalaria.setForeground(Color.WHITE);
		lblNanJokalaria.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNanJokalaria.setBounds(158, 69, 103, 35);
		Jokalariak.add(lblNanJokalaria);

		lblJokalariIzena = new JLabel("Izena");
		lblJokalariIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblJokalariIzena.setForeground(Color.WHITE);
		lblJokalariIzena.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblJokalariIzena.setBounds(304, 69, 103, 35);
		Jokalariak.add(lblJokalariIzena);

		lblJokalariAbizena = new JLabel("Abizena");
		lblJokalariAbizena.setHorizontalAlignment(SwingConstants.CENTER);
		lblJokalariAbizena.setForeground(Color.WHITE);
		lblJokalariAbizena.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblJokalariAbizena.setBounds(454, 69, 103, 35);
		Jokalariak.add(lblJokalariAbizena);

		lblJokalariTaldea = new JLabel("Taldea");
		lblJokalariTaldea.setHorizontalAlignment(SwingConstants.CENTER);
		lblJokalariTaldea.setForeground(Color.WHITE);
		lblJokalariTaldea.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblJokalariTaldea.setBounds(562, 69, 187, 35);
		Jokalariak.add(lblJokalariTaldea);

		txtJokalariaNan = new JTextField();
		txtJokalariaNan.setForeground(Color.WHITE);
		txtJokalariaNan.setColumns(10);
		txtJokalariaNan.setBackground(new Color(108, 122, 137));
		txtJokalariaNan.setBounds(158, 115, 103, 29);
		Jokalariak.add(txtJokalariaNan);

		txtJokalariaIzena = new JTextField();
		txtJokalariaIzena.setForeground(Color.WHITE);
		txtJokalariaIzena.setColumns(10);
		txtJokalariaIzena.setBackground(new Color(108, 122, 137));
		txtJokalariaIzena.setBounds(304, 115, 103, 29);
		Jokalariak.add(txtJokalariaIzena);

		txtJokalariaAbizena = new JTextField();
		txtJokalariaAbizena.setForeground(Color.WHITE);
		txtJokalariaAbizena.setColumns(10);
		txtJokalariaAbizena.setBackground(new Color(108, 122, 137));
		txtJokalariaAbizena.setBounds(454, 115, 103, 29);
		Jokalariak.add(txtJokalariaAbizena);

		scrollPaneJokalariak = new JScrollPane();
		scrollPaneJokalariak.setBounds(10, 172, 862, 334);
		Jokalariak.add(scrollPaneJokalariak);
		dlmj = new DefaultListModel<Jokalariak>();
		listJokalariak = new JList<Jokalariak>();
		listJokalariak.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtJokalariaNan.setText(dlmj.getElementAt(listJokalariak.getSelectedIndex()).getNan());
				txtJokalariaIzena.setText(dlmj.getElementAt(listJokalariak.getSelectedIndex()).getIzena());
				txtJokalariaAbizena.setText(dlmj.getElementAt(listJokalariak.getSelectedIndex()).getAbizena());
				comboBoxJokalariTaldeak
						.setSelectedItem(dlmj.getElementAt(listJokalariak.getSelectedIndex()).getTaldea());

			}
		});
		listJokalariak.setFont(new Font("Tahoma", Font.BOLD, 16));
		JokalariDatabaseKargatu();
		listJokalariak.setModel(dlmj);
		listJokalariak.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneJokalariak.setViewportView(listJokalariak);

		comboBoxJokalariTaldeak = new JComboBox<String>();
		comboBoxJokalariTaldeak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				for(int i = 0; i< dlmt.size(); i++) {
				
					if(comboBoxJokalariTaldeak.getSelectedItem().equals(dlmt.get(i).getIzena())){
						
						comboBoxJokalariKod_Klub.setSelectedItem(dlmt.get(i).getKodea());
					}
					}
				
				
				dlmj.removeAllElements();
				
				for (int i=0;i<AR_jokalariak.size();i++) {
					if (comboBoxJokalariTaldeak.getSelectedItem().equals(AR_jokalariak.get(i).getTaldea())) {
						dlmj.addElement(AR_jokalariak.get(i));
					}
					
				}
			}
		});
		
		comboBoxJokalariTaldeak.setBounds(601, 115, 133, 29);
		Jokalariak.add(comboBoxJokalariTaldeak);
		
		comboBoxJokalariKod_Klub = new JComboBox<String>();
		comboBoxJokalariKod_Klub.setVisible(false);
		comboBoxJokalariKod_Klub.setEnabled(false);
		comboBoxJokalariKod_Klub.setBounds(761, 115, 109, 29);
		Jokalariak.add(comboBoxJokalariKod_Klub);
		JokalariCod_clubComboboxKargatu();
		

		Partiduak = new JPanel();
		Partiduak.setVisible(false);
		Partiduak.setLayout(null);
		Partiduak.setBackground(new Color(44, 62, 80));
		Partiduak.setBounds(0, 0, 905, 508);
		layeredPane.add(Partiduak);

		panelInfoPartiduak = new JPanel();
		panelInfoPartiduak.setLayout(null);
		panelInfoPartiduak.setBackground(new Color(248, 148, 6));
		panelInfoPartiduak.setBounds(0, 0, 905, 43);
		Partiduak.add(panelInfoPartiduak);

		lblInfoPartiduak = new JLabel("Partidu pantaila");
		lblInfoPartiduak.setHorizontalTextPosition(SwingConstants.CENTER);
		lblInfoPartiduak.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoPartiduak.setForeground(Color.WHITE);
		lblInfoPartiduak.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblInfoPartiduak.setBounds(306, 0, 295, 43);
		panelInfoPartiduak.add(lblInfoPartiduak);

		lblKodeaPartidua = new JLabel("Kodea");
		lblKodeaPartidua.setHorizontalAlignment(SwingConstants.CENTER);
		lblKodeaPartidua.setForeground(Color.WHITE);
		lblKodeaPartidua.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblKodeaPartidua.setBounds(25, 69, 103, 35);
		Partiduak.add(lblKodeaPartidua);

		lblEtxekoa = new JLabel("Etxekoa");
		lblEtxekoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblEtxekoa.setForeground(Color.WHITE);
		lblEtxekoa.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEtxekoa.setBounds(171, 69, 103, 35);
		Partiduak.add(lblEtxekoa);

		lblKanpokoa = new JLabel("Kanpokoa");
		lblKanpokoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblKanpokoa.setForeground(Color.WHITE);
		lblKanpokoa.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblKanpokoa.setBounds(321, 69, 103, 35);
		Partiduak.add(lblKanpokoa);

		lblData = new JLabel("Data");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblData.setBounds(434, 69, 187, 35);
		Partiduak.add(lblData);

		txtKodeaPartiduak = new JTextField();
		txtKodeaPartiduak.setForeground(Color.WHITE);
		txtKodeaPartiduak.setColumns(10);
		txtKodeaPartiduak.setBackground(new Color(108, 122, 137));
		txtKodeaPartiduak.setBounds(25, 115, 103, 29);
		Partiduak.add(txtKodeaPartiduak);

		txtEtxekoPartiduak = new JTextField();
		txtEtxekoPartiduak.setForeground(Color.WHITE);
		txtEtxekoPartiduak.setColumns(10);
		txtEtxekoPartiduak.setBackground(new Color(108, 122, 137));
		txtEtxekoPartiduak.setBounds(171, 115, 103, 29);
		Partiduak.add(txtEtxekoPartiduak);

		txtKanpokoPartiduak = new JTextField();
		txtKanpokoPartiduak.setForeground(Color.WHITE);
		txtKanpokoPartiduak.setColumns(10);
		txtKanpokoPartiduak.setBackground(new Color(108, 122, 137));
		txtKanpokoPartiduak.setBounds(321, 115, 103, 29);
		Partiduak.add(txtKanpokoPartiduak);

		scrollPanePartiduak = new JScrollPane();
		scrollPanePartiduak.setBounds(10, 163, 848, 334);
		Partiduak.add(scrollPanePartiduak);

		listPartiduak = new JList<Partiduak>();
		listPartiduak.setFont(new Font("Tahoma", Font.BOLD, 17));
		listPartiduak.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtKodeaPartiduak.setText(dlmp.getElementAt(listPartiduak.getSelectedIndex()).getKodea());
				txtEtxekoPartiduak.setText(dlmp.getElementAt(listPartiduak.getSelectedIndex()).getLokala());
				txtKanpokoPartiduak.setText(dlmp.getElementAt(listPartiduak.getSelectedIndex()).getKanpokoa());
				txtData.setText(dlmp.getElementAt(listPartiduak.getSelectedIndex()).getData());
				txtEmaitzaLokala.setText(
						String.valueOf(dlmp.getElementAt(listPartiduak.getSelectedIndex()).getEmaitzaLokala()));
				txtEmaitzaKanpokoa.setText(
						String.valueOf(dlmp.getElementAt(listPartiduak.getSelectedIndex()).getEmaitzaKanpokoa()));
			}
		});
		dlmp = new DefaultListModel<Partiduak>();
		listPartiduak.setModel(dlmp);
		listPartiduak.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPanePartiduak.setViewportView(listPartiduak);
		PartiduakKargatu();

		txtData = new JTextField();
		txtData.setForeground(Color.WHITE);
		txtData.setColumns(10);
		txtData.setBackground(new Color(108, 122, 137));
		txtData.setBounds(479, 115, 103, 29);
		Partiduak.add(txtData);

		lblEmaitzaPartiduak = new JLabel("Emaitza");
		lblEmaitzaPartiduak.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmaitzaPartiduak.setForeground(Color.WHITE);
		lblEmaitzaPartiduak.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmaitzaPartiduak.setBounds(613, 69, 187, 35);
		Partiduak.add(lblEmaitzaPartiduak);

		txtEmaitzaLokala = new JTextField();
		txtEmaitzaLokala.setForeground(Color.WHITE);
		txtEmaitzaLokala.setColumns(10);
		txtEmaitzaLokala.setBackground(new Color(108, 122, 137));
		txtEmaitzaLokala.setBounds(623, 115, 71, 29);
		Partiduak.add(txtEmaitzaLokala);

		txtEmaitzaKanpokoa = new JTextField();
		txtEmaitzaKanpokoa.setForeground(Color.WHITE);
		txtEmaitzaKanpokoa.setColumns(10);
		txtEmaitzaKanpokoa.setBackground(new Color(108, 122, 137));
		txtEmaitzaKanpokoa.setBounds(729, 115, 71, 29);
		Partiduak.add(txtEmaitzaKanpokoa);

		lblSeparador = new JLabel("/");
		lblSeparador.setForeground(Color.WHITE);
		lblSeparador.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblSeparador.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeparador.setBounds(672, 109, 80, 41);
		Partiduak.add(lblSeparador);
		
		spinnerJardunaldia = new JSpinner();
		SpinnerNumberModel snm = new SpinnerNumberModel();
		snm.setMaximum(38);
		snm.setMinimum(0);
		
		
		spinnerJardunaldia.setModel(snm);
		spinnerJardunaldia.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				dlmp.removeAllElements();
				for(int i = 0; i<AR_partiduak.size();i++) {
					
					if(AR_partiduak.get(i).getJardunaldia() == (int)spinnerJardunaldia.getValue()) {
						dlmp.addElement(AR_partiduak.get(i));
					}
				}
			}
			
			}
		);
		spinnerJardunaldia.setFont(new Font("Tahoma", Font.BOLD, 16));
		spinnerJardunaldia.setBounds(820, 115, 75, 29);
		
		Partiduak.add(spinnerJardunaldia);
		
		lblJarnudaldia = new JLabel("Jardunaldia");
		lblJarnudaldia.setForeground(Color.WHITE);
		lblJarnudaldia.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblJarnudaldia.setBounds(792, 70, 103, 35);
		Partiduak.add(lblJarnudaldia);

		Klasifikazioa = new JPanel();
		Klasifikazioa.setVisible(false);
		Klasifikazioa.setLayout(null);
		Klasifikazioa.setBackground(new Color(44, 62, 80));
		Klasifikazioa.setBounds(0, 0, 905, 508);
		layeredPane.add(Klasifikazioa);

		panelInfoKlasifikazioa = new JPanel();
		panelInfoKlasifikazioa.setLayout(null);
		panelInfoKlasifikazioa.setBackground(new Color(248, 148, 6));
		panelInfoKlasifikazioa.setBounds(0, 0, 905, 43);
		Klasifikazioa.add(panelInfoKlasifikazioa);

		lblInfoKlasifikazioa = new JLabel("Klasifikazio pantaila");
		lblInfoKlasifikazioa.setHorizontalTextPosition(SwingConstants.CENTER);
		lblInfoKlasifikazioa.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoKlasifikazioa.setForeground(Color.WHITE);
		lblInfoKlasifikazioa.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblInfoKlasifikazioa.setBounds(306, 0, 295, 43);
		panelInfoKlasifikazioa.add(lblInfoKlasifikazioa);

		lblPostua = new JLabel("Postua");
		lblPostua.setHorizontalAlignment(SwingConstants.CENTER);
		lblPostua.setForeground(Color.WHITE);
		lblPostua.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPostua.setBounds(248, 67, 103, 35);
		Klasifikazioa.add(lblPostua);

		lblPuntuak = new JLabel("Puntuak");
		lblPuntuak.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntuak.setForeground(Color.WHITE);
		lblPuntuak.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPuntuak.setBounds(535, 67, 103, 35);
		Klasifikazioa.add(lblPuntuak);

		scrollPaneKlasifikazioa = new JScrollPane();
		scrollPaneKlasifikazioa.setBounds(76, 140, 731, 334);
		Klasifikazioa.add(scrollPaneKlasifikazioa);
		
		JList<String> listKlasifikazioa = new JList<String>();
		listKlasifikazioa.setFont(new Font("Tahoma", Font.BOLD, 15));
		dlms = new DefaultListModel<String>();
		listKlasifikazioa.setModel(dlms);
		listKlasifikazioa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneKlasifikazioa.setViewportView(listKlasifikazioa);

		Erabiltzaileak = new JPanel();
		Erabiltzaileak.setVisible(false);
		Erabiltzaileak.setBounds(0, 0, 897, 508);
		Erabiltzaileak.setBackground(new Color(44, 62, 80));
		layeredPane.add(Erabiltzaileak);
		Erabiltzaileak.setLayout(null);

		panelInfoErabiltzaileak = new JPanel();
		panelInfoErabiltzaileak.setBounds(0, 0, 905, 43);

		Erabiltzaileak.add(panelInfoErabiltzaileak);
		panelInfoErabiltzaileak.setBackground(new Color(248, 148, 6));
		panelInfoErabiltzaileak.setLayout(null);

		lblInfoErabiltzaileak = new JLabel("Erabiltzaile pantaila");
		lblInfoErabiltzaileak.setHorizontalTextPosition(SwingConstants.CENTER);
		lblInfoErabiltzaileak.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoErabiltzaileak.setForeground(Color.WHITE);
		lblInfoErabiltzaileak.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblInfoErabiltzaileak.setBounds(306, 0, 295, 43);
		panelInfoErabiltzaileak.add(lblInfoErabiltzaileak);

		txtIzenaErabiltzaile = new JTextField();
		txtIzenaErabiltzaile.setBounds(29, 110, 116, 26);
		txtIzenaErabiltzaile.setFont(new Font("Tahoma", Font.BOLD, 15));
		Erabiltzaileak.add(txtIzenaErabiltzaile);
		txtIzenaErabiltzaile.setColumns(10);

		lblIzenaErabilztaile = new JLabel("Izena");
		lblIzenaErabilztaile.setBounds(10, 54, 146, 51);
		lblIzenaErabilztaile.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblIzenaErabilztaile.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzenaErabilztaile.setForeground(Color.WHITE);
		Erabiltzaileak.add(lblIzenaErabilztaile);

		lblAbizenaErabiltzaile = new JLabel("Abizena");
		lblAbizenaErabiltzaile.setBounds(219, 54, 121, 51);
		lblAbizenaErabiltzaile.setForeground(Color.WHITE);
		lblAbizenaErabiltzaile.setFont(new Font("Tahoma", Font.BOLD, 18));
		Erabiltzaileak.add(lblAbizenaErabiltzaile);

		txtAbizenaErabiltzaile = new JTextField();
		txtAbizenaErabiltzaile.setBounds(199, 110, 121, 26);
		txtAbizenaErabiltzaile.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtAbizenaErabiltzaile.setColumns(10);
		Erabiltzaileak.add(txtAbizenaErabiltzaile);

		lblErabiltzaileaErabiltzaileak = new JLabel("Erabiltzailea");
		lblErabiltzaileaErabiltzaileak.setHorizontalAlignment(SwingConstants.CENTER);
		lblErabiltzaileaErabiltzaileak.setForeground(Color.WHITE);
		lblErabiltzaileaErabiltzaileak.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblErabiltzaileaErabiltzaileak.setBounds(376, 54, 146, 51);
		Erabiltzaileak.add(lblErabiltzaileaErabiltzaileak);

		txterabiltzaileaErabiltzaile = new JTextField();
		txterabiltzaileaErabiltzaile.setFont(new Font("Tahoma", Font.BOLD, 15));
		txterabiltzaileaErabiltzaile.setColumns(10);
		txterabiltzaileaErabiltzaile.setBounds(386, 110, 136, 26);
		Erabiltzaileak.add(txterabiltzaileaErabiltzaile);

		lblPasahitzaErabiltzaile = new JLabel("Pasahitza");
		lblPasahitzaErabiltzaile.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasahitzaErabiltzaile.setForeground(Color.WHITE);
		lblPasahitzaErabiltzaile.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPasahitzaErabiltzaile.setBounds(555, 54, 146, 51);
		Erabiltzaileak.add(lblPasahitzaErabiltzaile);

		txtPasahitzaErabiltzaile = new JTextField();
		txtPasahitzaErabiltzaile.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtPasahitzaErabiltzaile.setColumns(10);
		txtPasahitzaErabiltzaile.setBounds(565, 110, 136, 26);
		Erabiltzaileak.add(txtPasahitzaErabiltzaile);

		lblBaimenaErabiltzaile = new JLabel("Baimena");
		lblBaimenaErabiltzaile.setHorizontalAlignment(SwingConstants.CENTER);
		lblBaimenaErabiltzaile.setForeground(Color.WHITE);
		lblBaimenaErabiltzaile.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBaimenaErabiltzaile.setBounds(722, 54, 146, 51);
		Erabiltzaileak.add(lblBaimenaErabiltzaile);

		comboBoxBaimenak = new JComboBox<String>();
		comboBoxBaimenak.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBoxBaimenak
				.setModel(new DefaultComboBoxModel<String>(new String[] { "Administratzailea", "Erabiltzailea" }));
		comboBoxBaimenak.setBounds(732, 110, 155, 26);
		Erabiltzaileak.add(comboBoxBaimenak);

		JScrollPane scrollPaneErabiltzaileak = new JScrollPane();
		scrollPaneErabiltzaileak.setBounds(22, 173, 846, 321);
		Erabiltzaileak.add(scrollPaneErabiltzaileak);

		listErabiltzaileak = new JList<Erabiltzaileak>();
		listErabiltzaileak.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txterabiltzaileaErabiltzaile
						.setText(dlme.getElementAt(listErabiltzaileak.getSelectedIndex()).getErabiltzailea());
				txtPasahitzaErabiltzaile
						.setText(dlme.getElementAt(listErabiltzaileak.getSelectedIndex()).getPasahitza());
				txtIzenaErabiltzaile.setText(dlme.getElementAt(listErabiltzaileak.getSelectedIndex()).getIzena());
				txtAbizenaErabiltzaile.setText(dlme.getElementAt(listErabiltzaileak.getSelectedIndex()).getAbizena());
				comboBoxBaimenak
						.setSelectedItem(dlme.getElementAt(listErabiltzaileak.getSelectedIndex()).getBaimenak());
			}
		});
		dlme = new DefaultListModel<Erabiltzaileak>();
		listErabiltzaileak.setModel(dlme);
		listErabiltzaileak.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneErabiltzaileak.setViewportView(listErabiltzaileak);
		ErabiltzaileDatabaseKargatu();
		
		
	
	}
}