package Test;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class connect4 extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					connect4 frame = new connect4();
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
	public connect4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 300);

		Container g = getContentPane();
		Test.Panel panel = new Panel();
		g.add(panel);

	}

}

class ResourceLocation {
	public ResourceLocation() {
		ResourceLocation resource = new ResourceLocation();

	}
}

class Panel extends JPanel {

	int rows = 6;
	int slots = 7;

	public Panel() {
		// ImageIcon pole = createImageIcon("/src/Test/pole.png"); osobna klasa
		setLayout(new GridLayout(rows + 1, slots));
		for (int i = 0; i < slots; i++) {
			int a = i;
			a++;
			add(new JButton("" + a));
		}
		for (int i = 0; i < slots * rows; i++) {
			add(new JLabel("" + i));
			// TUTAJ MA BYC LABEL.setVerticalTextPosition(JLabel.BOTTOM)
		}
	}
}
