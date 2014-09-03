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
	private boolean blockButton;
	private PlayerId playerId;
	private SideBoard sideBoard;
	protected JLabel token;
	private DialogInformationBoxes informationBoxes;

	/**
	 * Presenter MVP do GameFrame
	 * 
	 * @param playerName
	 * @param playerId
	 * @param gameController
	 */
	public SwingPresenter(String playerName, PlayerId playerId,
			GameController gameController, boolean block) {
		playerAttributes = new PlayerAttributes(playerName, playerId);
		this.gameController = gameController;
		this.blockButton = block;
		this.playerId = playerId;
		setupFrame();
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

	}

	public void getSlotFromView(int slot) {
		emptySpot = gameController.move(slot);
		if (emptySpot == -1){
			informationBoxes.fullSlotMessage();
			
		gameBoard.disableButtons(false);

		refreshView(emptySpot, slot);
	}

	private void setupFrame() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					frame = new GameFrame(SwingPresenter.this);
					frame.setTitle(playerAttributes.getName());
					gameBoard = frame.getGameBoard();
					informationBoxes = new DialogInformationBoxes();
					sideBoard = frame.getSideBoard();
					token = frame.getSideToken();
					setNamesAndToken();
					gameController.endInitPlayer();
					gameBoard.disableButtons(blockButton);
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

	@Deprecated
	public void changeDispTurn(PlayerId playerId) {
	}

	/**
	 * Ustawia Imiona graczy na Labelach
	 */
	public void setNamesAndToken() {
		// pl1Label.setText(gameController.getPlayer1().getName());
		// pl2Label.setText(gameController.getPlayer2().getName());
		// if (playerId == PlayerId.Player1)
		// token.setIcon((sideBoard.iconResource.get(HoleState.PLAYER1)));
		// else
		// token.setIcon((sideBoard.iconResource.get(HoleState.PLAYER2)));
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
