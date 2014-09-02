package atrem.Connect4.swing;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.PlayerId;
import atrem.Connect4.Game.player.PlayerAttributes;
import atrem.Connect4.Game.player.PlayerController;

public class SwingPresenter implements PlayerController {

	private int LastRow;//
	private int LastSlot; // do GC
	private int emptySpot;//
	private GameController gameController;
	private JLabel pl1Label, pl2Label; // do View
	private PlayerAttributes playerAttributes;
	private GameBoard gameBoard;

	public SwingPresenter(String im, PlayerId playerId) {
		playerAttributes = new PlayerAttributes(im, playerId);
	}

	@Override
	public void yourTurn() {

		LastSlot = gameController.getLastMove().getLastSlot();
		LastRow = gameController.getLastMove().getLastRow();
		goView(LastRow, LastSlot);

	}

	public void getSlotFromView(int slot) {

		emptySpot = gameController.move(slot);// zabezpieczenie przed
												// przepelnionym zrobic !
		goView(emptySpot, slot);

	}

	public void setPresenter(GameController gameController) {

		this.gameController = gameController;
		setSettings();
	}

	public void setSettings() {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					GameFrame frame = new GameFrame(SwingPresenter.this);
					frame.setTitle(playerAttributes.getName());
					frame.setVisible(true);
					gameBoard = frame.getGameBoard();
					// po³¹czyæ
					// playerturn
					// do
					// playercontroller
					// changeDispTurn(playerTurn); // number
					// niepotrzebne
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void goView(int Row, int Slot) {
		// changeDispTurn(gameController.getPlayerTurn); // bez
		// numeru
		gameBoard.setFreeRow(Row, Slot, gameController.getBoard()
				.playerIdtoHoleState(gameController.getPlayerTurn())); // nie
																		// pytajcie
	}

	// public void setPanels() {
	// panel = gameFrame.getPanel();
	// statsPanel = gameFrame.getStatsPanel();
	// pl1Label = statsPanel.getPl1Label();
	// pl2Label = statsPanel.getPl2Label();
	// setNames();
	// }

	public void changeDispTurn(int plTurnNumb) {
		if (plTurnNumb == 1) {
			pl1Label.setVisible(false);
			pl2Label.setVisible(true);
		} else if (plTurnNumb == 2) {
			pl2Label.setVisible(false);
			pl1Label.setVisible(true);
		}
	}

	public void setNames() {
		pl1Label.setText(gameController.getPlayer1().getName());
		pl2Label.setText(gameController.getPlayer2().getName());
	}

	@Override
	public String getName() {
		return playerAttributes.getName();
	}

	@Override
	public void setName(String name) {
		playerAttributes.setName(name);

	}

	@Override
	public PlayerId getPlayerId() {
		return playerAttributes.getPlayerId();
	}

	@Override
	public void setGamecontroller(GameController gamecontroller) {
		this.gameController = gamecontroller;

	}

}
