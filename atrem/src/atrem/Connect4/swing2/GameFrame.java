package atrem.Connect4.swing2;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.player.PlayerController;

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

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 300, 100, 0 };
		gbl_contentPane.rowHeights = new int[] { 234, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
		leftPanel = new LeftPanel(game);

		GridBagConstraints gbc_leftPanel = new GridBagConstraints();
		gbc_leftPanel.fill = GridBagConstraints.BOTH;
		gbc_leftPanel.insets = new Insets(0, 0, 0, 5);
		gbc_leftPanel.gridx = 0;
		gbc_leftPanel.gridy = 0;
		contentPane.add(leftPanel, gbc_leftPanel);
		rightPanel = new RightPanel(game);
		GridBagConstraints gbc_rightPanel = new GridBagConstraints();
		gbc_rightPanel.anchor = GridBagConstraints.EAST;
		gbc_rightPanel.fill = GridBagConstraints.VERTICAL;
		gbc_rightPanel.gridx = 1;
		gbc_rightPanel.gridy = 0;
		contentPane.add(rightPanel, gbc_rightPanel);
	}

	public void setPlayerTurnLabel(PlayerController player) {

	}

	public void changeIcon() {

		BoardPanel bp = leftPanel.getBoardPanel();
		SlotPanel sp = bp.getSlotPanel(1);
		ResourceLoader res = sp.getIconResource();
		JLabel jl = new JLabel();
		sp.setHoleIcon(jl, 1, res.get(1));

	}

	public LeftPanel getLeftPanel() {
		return leftPanel;
	}

	public void setLeftPanel(LeftPanel leftPanel) {
		this.leftPanel = leftPanel;
	}
}
