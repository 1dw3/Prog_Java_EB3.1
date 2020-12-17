package evaluacion3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class holaVentanaAceptar extends JFrame {


	private static final long serialVersionUID = -1971749973978182889L;

	private JPanel contentPane;
	
	// main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					holaVentanaAceptar frame = new holaVentanaAceptar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// JFrame
	public holaVentanaAceptar() {
		setTitle("Evento Clic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTexto = new JLabel("No se ha pulsado Aceptar");
		lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTexto.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblTexto.setBounds(60, 29, 296, 14);
		contentPane.add(lblTexto);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// cambio el texto de lblAceptar
				lblTexto.setText("Ha pulsado Aceptar.");
			}
		});
		btnAceptar.setBounds(159, 66, 89, 23);
		contentPane.add(btnAceptar);
	}
}
