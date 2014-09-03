package atrem.Connect4.swing;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.PlayerId;
import atrem.Connect4.Game.player.PlayerAttributes;
import atrem.Connect4.Game.player.PlayerController;

public class SwingPresenter implements PlayerController {
	private int LastRow, LastSlot, emptySpot; // do GC
	private GameController gameController;
	private JLabel pl1Label, pl2Label; // changeDispTurn()
	private PlayerAttributes playerAttributes;
	private GameBoard gameBoard;
	private GameFrame frame;
	private boolean firstTurn = true;

	/**
	 * Presenter MVP do GameFrame
	 * 
	 * @param playerName
	 * @param playerId
	 * @param gameController
	 */
	public SwingPresenter(String playerName, PlayerId playerId,
			GameController gameController) {
		playerAttributes = new PlayerAttributes(playerName, playerId);
		this.gameController = gameController;
		setSettings();
	}

	/**
	 * Wywo³ywane przez GC.GameLoop
	 */
	@Override
	public void yourTurn() {
		// a w pierwszym ruchu nie ma last ...
		// dlatego da³em na sprawdzenie if Lukas
		gameBoard.disableButtons(true);
		System.out.println("hehe");
		LastSlot = gameController.getLastMove().getLastSlot();
		LastRow = gameController.getLastMove().getLastRow();
		if (LastRow != -1 && LastSlot != -1) { // spr czy to nie jest pierwszy
												// ruch

			refreshView(LastRow, LastSlot);
		}
		System.out.println(LastRow + " " + LastSlot);

		System.out.println("trolololo");
	}

	public void getSlotFromView(int slot) {
		emptySpot = gameController.move(slot); // zrobic zabezpieczenie przed
		gameBoard.disableButtons(false);
		// przepelnionym !
		refreshView(emptySpot, slot);
	}

	private void setSettings() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					frame = new GameFrame(SwingPresenter.this);
					frame.setTitle(playerAttributes.getName());
					gameBoard = frame.getGameBoard();
					gameController.endInitPlayer();
					// changeDispTurn(playerTurn);
					// frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Odœwie¿a planszê na GUI
	 */
	@Override
	public void refreshView(int row, int slot) { // row i slot s¹ 0, why?, a
													// slot do czego? Lukas
		changeDispTurn(gameController.getPlayerTurn());
		gameBoard.setFreeRow(row, slot, gameController.getBoard()
				.playerIdtoHoleState(gameController.getPlayerTurn()));
	}

	// public void setPanels() {
	// panel = gameFrame.getPanel();
	// statsPanel = gameFrame.getStatsPanel();
	// pl1Label = statsPanel.getPl1Label();
	// pl2Label = statsPanel.getPl2Label();
	// setNames();
	// }

	/**
	 * Funkcja zmienia Label gracza w ka¿zdej turze
	 * 
	 * @param playerId
	 *            kolej gracza 1/2
	 */
	public void changeDispTurn(PlayerId playerId) {
		// Naprawiæ Label'e Lukas
		// if (playerId == PlayerId.Player1) {
		// pl1Label.setVisible(false);
		// pl2Label.setVisible(true);
		// } else if (playerId == PlayerId.Player2) {
		// pl2Label.setVisible(false);
		// pl1Label.setVisible(true);
		// }
	}

	/**
	 * Ustawia Imiona graczy na Labelach
	 */
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
