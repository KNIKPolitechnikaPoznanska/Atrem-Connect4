package atrem.Connect4.swing2;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.RightPanel;

public class GameFrame extends JFrame {

	/**
	 * serial
	 */
	private static final long serialVersionUID = -7486516557957711677L;

	private Game game;
	private JPanel contentPane;
	private LeftPanel leftPanel;
	private RightPanel rightPanel;

	/**
	 * Create the frame.
	 */
	public GameFrame(Game game) {
		this.game = game;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		leftPanel = new LeftPanel(game);
		rightPanel = new RightPanel(game);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		contentPane.add(leftPanel);
		contentPane.add(rightPanel);
	}

}
