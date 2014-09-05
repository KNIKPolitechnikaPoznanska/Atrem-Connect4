package atrem.Connect4.swing;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.PlayerId;
import atrem.Connect4.Game.ResultState;
import atrem.Connect4.Game.player.PlayerAttributes;
import atrem.Connect4.Game.player.PlayerController;

public class SwingPresenter implements PlayerController {
	private int LastRow, LastSlot, emptySpot, slots, rows, decision;
	private GameController gameController;
	private PlayerAttributes playerAttributes;
	private GameBoard gameBoard;
	private GameFrame frame;
	private boolean blockButton;
	private PlayerId playerId;
	private SideBoard sideBoard;
	protected JLabel token;
	private Color tokenColor;
	private DialogInformationBoxes informationBoxes;

	/**
	 * Presenter MVP do GameFrame
	 * 
	 * @param playerName
	 * @param playerId
	 * @param gameController
	 * @param block
	 */
	public SwingPresenter(GameController gameController, String playerName,
			PlayerId playerId, Color tokenColor, boolean block) {
		playerAttributes = new PlayerAttributes(playerName, playerId);
		this.gameController = gameController;
		this.blockButton = block;
		this.playerId = playerId;
		this.tokenColor = tokenColor;
		setupFrame();
		slots = gameController.getBoard().getSlots();
		rows = gameController.getBoard().getRows();
	}

	/**
	 * Wywo�ywane przez GC.GameLoop
	 */
	@Override
	public void yourTurn() {
		gameBoard.disableButtons(true);
		System.out.println("hehe");
		LastSlot = gameController.getLastMove().getLastSlot();
		LastRow = gameController.getLastMove().getLastRow();
		if (LastRow != -1 && LastSlot != -1) {
			refreshView(LastRow, LastSlot);
		}
		System.out.println(LastRow + " " + LastSlot);

	}

	public void getSlotFromView(int slot) {

		emptySpot = gameController.move(slot);
		if (emptySpot == -1) {
			informationBoxes.fullSlotMessage();
		} else {
			gameBoard.disableButtons(false);
			refreshView(emptySpot, slot);
		}

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
					gameController.endInitPlayer();
					gameBoard.disableButtons(blockButton);
					setNamesAndToken();
					// changeDispTurn(playerTurn);
					// frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Od�wie�a plansz� na GUI
	 */
	public void refreshView(int row, int slot) { // row i slot s� 0, why?, a
													// slot do czego? Lukas
		changeDispTurn(gameController.getPlayerTurn());
		gameBoard.setFreeRow(row, slot, gameController.getBoard()
				.playerIdtoHoleState(gameController.getPlayerTurn()));
	}

	@Override
	public void endOfGame(ResultState resultGame) {
		if (resultGame == ResultState.Player1Win)
			decision = informationBoxes.winMessage(gameController.getPlayer1()
					.getName());
		decision = informationBoxes.winMessage(gameController.getPlayer2()
				.getName());
		if (resultGame == ResultState.Draw)
			informationBoxes.drawMessage();

		makeDecision(decision);
	}

	public void makeDecision(int decision) {
		if (decision == 0)
			frame.dispose();

		if (decision == 2)
			frame.dispose();

		if (playerId == playerId.Player2)
			gameController.startNewGame();

	}

	/**
	 * Funkcja zmienia Label gracza w ka�zdej turzel
	 * 
	 * @param playerId
	 *            kolej gracza 1/2
	 */

	@Deprecated
	public void changeDispTurn(PlayerId playerId) {
	}

	public PlayerAttributes getPlayerAttributes() {
		return playerAttributes;
	}

	/**
	 * Ustawia Imiona graczy na Labelach
	 */
	public void setNamesAndToken() {
		sideBoard.setPl1Name(gameController.getPlayer1().getName());
		sideBoard.setPl2Name(gameController.getPlayer2().getName());
		if (playerId == PlayerId.Player1)
			sideBoard.setTokenPl1();
		else
			sideBoard.setTokenPl2();
	}

	public int getSlots() {
		return slots;
	}

	public int getRows() {
		return rows;
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
