package ebaluaketa3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DBIkasleakNabigazioa extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBIkasleakNabigazioa frame = new DBIkasleakNabigazioa();
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
	public DBIkasleakNabigazioa() {
		setTitle("Ikasleak");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton_2 = new JButton("Sartu");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Ezabatu");
		panel.add(btnNewButton_3);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("NAN                        ");
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Izena                            ");
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Abizenak         ");
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Taldea            ");
		panel_1.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("<<");
		contentPane.add(btnNewButton, BorderLayout.WEST);
		
		JButton btnNewButton_1 = new JButton(">>");
		contentPane.add(btnNewButton_1, BorderLayout.EAST);
	}

}
