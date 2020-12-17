package ebaluaketa3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class BotoiakMenuak extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BotoiakMenuak frame = new BotoiakMenuak();
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
	public BotoiakMenuak() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 298, 276);
		setTitle("Kalkulagailua eragile bat");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Ez dago mezurik");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("-");
		btnNewButton.setBounds(0, 1, 136, 48);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("1/x");
		btnNewButton_1.setBounds(136, 1, 136, 48);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Erro karratua");
		btnNewButton_2.setBounds(0, 49, 136, 48);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("x2");
		btnNewButton_3.setBounds(136, 49, 136, 48);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("CE");
		btnNewButton_4.setBounds(0, 97, 136, 48);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("x3");
		btnNewButton_5.setBounds(136, 97, 136, 48);
		panel_1.add(btnNewButton_5);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
	}

}
