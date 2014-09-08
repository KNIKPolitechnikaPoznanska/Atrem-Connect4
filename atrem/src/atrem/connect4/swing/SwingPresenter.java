package atrem.connect4.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.SwingUtilities;

import atrem.connect4.game.GameController;
import atrem.connect4.game.PlayerDecision;
import atrem.connect4.game.PlayerId;
import atrem.connect4.game.ResultState;
import atrem.connect4.game.player.PlayerAttributes;
import atrem.connect4.game.player.PlayerController;

public class SwingPresenter implements PlayerController {
	private int LastRow, LastSlot, emptySpot, slots, rows, decision;
	private GameController gameController;
	private PlayerAttributes playerAttributes;
	private GameBoard gameBoard;
	private GameFrame frame;
	private boolean blockButton;
	private PlayerId playerId;
	private SideBoard sideBoard;
	private Color playerColor, opponentColor;
	private Stats stats;
	private Dimension screenSize;
	private DialogInformationBoxes informationBoxes;
	private int frameHeight, frameWidth, screenHeight, screenWidth;

	/**
	 * Presenter MVP do GameFrame
	 * 
	 * @param gameController
	 * @param playerName
	 * @param playerId
	 * @param playerColor
	 * @param oppTokenColor
	 * @param block
	 */
	public SwingPresenter(GameController gameController,
			PlayerAttributes playerAttributes, Color opponentColor,
			int playerPoints) {
		this.gameController = gameController;
		this.playerAttributes = playerAttributes;
		this.playerId = playerAttributes.getPlayerId();
		this.playerColor = playerAttributes.getPlayerColor();
		this.opponentColor = opponentColor;
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
		LastSlot = gameController.getLastMove().getLastSlot();
		LastRow = gameController.getLastMove().getLastRow();

		if (LastRow != -1 && LastSlot != -1) {
			refreshView(LastRow, LastSlot);
		}
		System.out.println(LastRow + " " + LastSlot);
	}

	/**
	 * Ustawia ostatnio klikni�ty slot.
	 * 
	 * @param slot
	 */
	public void getSlotFromView(int slot) {
		emptySpot = gameController.move(slot);
		if (emptySpot == -1) {
			informationBoxes.fullSlotMessage();
		} else {
			gameBoard.disableButtons(false);
			refreshView(emptySpot, slot);
		}
	}

	/**
	 * Tworzy w�tek Swing
	 */
	private void setupFrame() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					frame = new GameFrame(SwingPresenter.this);
					frame.setTitle(playerAttributes.getName());
					setupBounds();
					gameBoard = frame.getGameBoard();
					informationBoxes = new DialogInformationBoxes();
					sideBoard = frame.getSideBoard();
					stats = frame.getStats();
					stats.setPointsPlayer(gameController.getPlayer1()
							.getPlayerPoints(), PlayerId.PLAYER1);
					stats.setPointsPlayer(gameController.getPlayer2()
							.getPlayerPoints(), PlayerId.PLAYER2);
					stats.setName(gameController.getPlayer1().getName(),
							PlayerId.PLAYER1);
					stats.setName(gameController.getPlayer2().getName(),
							PlayerId.PLAYER2);

					gameController.endInitPlayer();
					gameBoard.disableButtons(blockButton);
					setNamesAndToken();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			private void setupBounds() {
				screenHeight = (int) screenSize.getHeight();
				screenWidth = (int) screenSize.getWidth();
				frameWidth = screenWidth / 2 - screenWidth / 30;
				frameHeight = frameWidth * 3 / 4;
				if (playerId == PlayerId.PLAYER1)
					frame.setBounds(screenWidth / 30, screenHeight / 2
							- frameHeight / 2, frameWidth, frameHeight);
				if (playerId == PlayerId.PLAYER2)
					frame.setBounds(
							screenWidth - screenWidth / 30 - frameWidth,
							screenHeight / 2 - frameHeight / 2, frameWidth,
							frameHeight);
			}
		});
	}

	/**
	 * Od�wie�a plansz� na GUI
	 */
	public void refreshView(int row, int slot) {
		gameBoard.setFreeRow(row, slot, gameController.getBoard()
				.playerIdtoHoleState(gameController.getPlayerTurn()));
	}

	@Override
	public void endOfGame(ResultState resultGame) {
		if (resultGame == ResultState.Player1Win) {
			decision = informationBoxes.winMessage(gameController.getPlayer1()
					.getName());
			if (playerId == PlayerId.PLAYER1)
				playerAttributes.addPoints();
		}
		if (resultGame == ResultState.Player2Win) {
			decision = informationBoxes.winMessage(gameController.getPlayer2()
					.getName());
			if (playerId == PlayerId.PLAYER2)
				playerAttributes.addPoints();
		}
		if (resultGame == ResultState.Draw)
			informationBoxes.drawMessage();

		makeDecision(decision);
	}

	public void makeDecision(int decision) {
		if (decision == 1) {
			frame.dispose();
			if (playerId == PlayerId.PLAYER2) {
				playerAttributes.setPlayerDecision(PlayerDecision.NEW_GAME);
				gameController.initializeNewGame(playerId,
						playerAttributes.getPlayerDecision());
			}
		}
		if (decision == 0) // tak gram dalej
		{
			frame.dispose();
			if (playerId == PlayerId.PLAYER2)
				gameController.startNewGame();
		}
		if (decision == 2) // zamknij
			frame.dispose();
	}

	public PlayerAttributes getPlayerAttributes() {
		return playerAttributes;
	}

	/**
	 * Ustawia Imiona graczy na Labelach
	 */
	public void setNamesAndToken() {
		if (playerId == PlayerId.PLAYER1) {
			sideBoard.setTokenPl1();
			sideBoard.setPl1Name(gameController.getPlayer1().getName());
			sideBoard.setPl2Name(gameController.getPlayer2().getName());
		} else {
			sideBoard.setTokenPl2();
			sideBoard.setPl1Name(gameController.getPlayer2().getName());
			sideBoard.setPl2Name(gameController.getPlayer1().getName());
		}
	}

	public Color getOpponentColor() {
		return opponentColor;
	}

	public int getSlots() {
		return slots;
	}

	public Color getPlayerColor() {
		return playerColor;
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

	@Override
	public int getPlayerPoints() {
		return playerAttributes.getPlayerPoints();
	}
}
