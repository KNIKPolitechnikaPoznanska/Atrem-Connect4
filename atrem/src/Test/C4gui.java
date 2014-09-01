package Test;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class C4gui extends JFrame {

	/**
	 * Launch the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					C4gui frame = new C4gui();
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
	public C4gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 331);

		Container mainContainer = getContentPane();
		getContentPane().setLayout(null);
		Panel panel = new Panel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 0, 330, 282);
		mainContainer.add(panel);
		Boczny boczny = new Boczny();
		boczny.setBounds(340, 0, 186, 262);

		getContentPane().add(boczny);

	}
}
