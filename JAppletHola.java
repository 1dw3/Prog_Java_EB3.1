package evaluacion3;

import javax.swing.JApplet;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class JAppletHola extends JApplet {

	private static final long	serialVersionUID	= -4870891492211225585L;

	public JAppletHola() {
		
		JLabel lblJappletHola = new JLabel("JApplet Hola");
		getContentPane().add(lblJappletHola, BorderLayout.CENTER);

	}

}
