package atrem.Connect4.swing;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -1454524828392484548L;
	SwingPresenter swingPresenter;
	private Panel panel;
	Boczny boczny;

	/**
	 * Create the frame.
	 */
	public GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 331);

		Container mainContainer = getContentPane();
		getContentPane().setLayout(null);
		panel = new Panel(swingPresenter);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 0, 330, 282);
		mainContainer.add(panel);
		boczny = new Boczny();
		boczny.setBounds(340, 0, 186, 262);

		getContentPane().add(boczny);

	}

	public Panel getPanel() {
		return panel;
	}

	public Boczny getBoczny() {
		return boczny;
	}

	public void setBoczny(Boczny boczny) {
		this.boczny = boczny;
	}
}
