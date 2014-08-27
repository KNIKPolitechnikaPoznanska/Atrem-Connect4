package atrem.Connect4.swing2;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import atrem.Connect4.Game.Game;

public class LeftPanel extends JPanel {
	/**
	 * serial
	 */
	private static final long serialVersionUID = 5802752411957281604L;
	private BoardPanel boardPanel;

	private ButtonListPanel buttonList;

	private int slots;
	/**
	 * Create the panel.
	 */
	public LeftPanel(Game game) {
		slots = game.getBoardSlots();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 450, 0 };
		gridBagLayout.rowHeights = new int[] { 100, 150, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		buttonList = new ButtonListPanel(game);
		GridBagConstraints gbc_buttonList = new GridBagConstraints();
		gbc_buttonList.fill = GridBagConstraints.BOTH;
		gbc_buttonList.insets = new Insets(0, 0, 5, 0);
		gbc_buttonList.gridx = 0;
		gbc_buttonList.gridy = 0;
		add(buttonList, gbc_buttonList);
		buttonList.setLayout(new GridLayout(2, 6));

		boardPanel = new BoardPanel(game);
		GridBagConstraints gbc_boardPane = new GridBagConstraints();
		gbc_boardPane.fill = GridBagConstraints.BOTH;
		gbc_boardPane.gridx = 0;
		gbc_boardPane.gridy = 1;
		add(boardPanel, gbc_boardPane);
		boardPanel.setLayout(new GridLayout(3, 2));
	}

	public BoardPanel getBoardPanel() {
		return boardPanel;
	}

	public ButtonListPanel getButtonList() {
		return buttonList;
	}

	public void setBoardPanel(BoardPanel boardPanel) {
		this.boardPanel = boardPanel;
	}

	public void setButtonList(ButtonListPanel buttonList) {
		this.buttonList = buttonList;
	}

}
