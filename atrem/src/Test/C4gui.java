package Test;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class C4gui extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		setBounds(100, 100, 549, 300);

		Container mainContainer = getContentPane();
		Test.Panel panel = new Panel();
		mainContainer.add(panel);

	}

}

class Panel extends JPanel {

	int rows = 6;
	int slots = 7;
	JLabel[][] Plansza = new JLabel[rows][slots];
	JButton[] button = new JButton[slots];
	// private ResourceLoader iconResource;
	// ActionListener newMouve = new placeToken();

	ResourceLoader iconResource = new ResourceLoader();

	public Panel() {

		// ImageIcon pole = createImageIcon("/src/Test/pole.png"); osobna klasa
		setLayout(new GridLayout(rows + 1, slots));
		// for (int i = 0; i < slots; i++) {
		// int a = i;
		// a++;
		// JButton button = new JButton("" + a);
		// button.addActionListener(newMouve);
		// add(button);
		// }

		for (int i = 0; i < slots; i++) {
			button[i] = new JButton("" + (i + 1));
			add(button[i]);
			button[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent TokenPlaced) {
					Object s = TokenPlaced.getSource();
					for (int i = 0; i < slots; i++) {
						if (s == button[i])
							System.out.println(i+1);
					}
				}
			});
		}

		for (int j = 0; j < slots; j++) {
			for (int i = 0; i < rows; i++) {
				Plansza[i][j] = new JLabel();
				add(Plansza[i][j]); // tu moze byc blad typu rows na slots !
				Plansza[i][j].setIcon(iconResource.get(0));
				// Plansza[i][j].setText("chuj");
			}
		}

		// int changeIconInSlot(int slots, int rows, int iconNumber)
		// {
		//
		// }
	}

	void placeTokenInSlot(int slot) {
		// Plansza[1][1].setIcon(iconResource.get(1));
		Plansza[i][j].setText("chuj");
	}
}
