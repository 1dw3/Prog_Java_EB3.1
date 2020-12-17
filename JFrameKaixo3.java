package ebaluaketa3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JFrameKaixo3 extends JFrame {
	
	private static final long	serialVersionUID	= -4523199984889660117L;
		
	private JPanel contentPane; 
	
	public static void main(String[] args) { 
		EventQueue.invokeLater(new Runnable() { 
		public void run() { 
		try { 
			JFrameKaixo3 frame = new JFrameKaixo3(); 
			frame.setVisible(true); 
		} catch (Exception e) { 
			e.printStackTrace(); 
		}
		}
	});
}
		// JFrame egin
	public JFrameKaixo3() {
		setTitle("JFrameKaixo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 300, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}

	
		