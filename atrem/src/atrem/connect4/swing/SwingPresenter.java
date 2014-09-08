package atrem.connect4.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.SwingUtilities;

import atrem.connect4.game.GameController;
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
	 * @param pl1TokenColor
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
	 * Wywo³ywane przez GC.GameLoop
	 */
	@Override
	public void yourTurn() {
		SemaphoreToken();
		gameBoard.enableButtons(true);
		LastSlot = gameController.getLastMove().getLastSlot();
		LastRow = gameController.getLastMove().getLastRow();

		if (LastRow != -1 && LastSlot != -1) {
			refreshView(LastRow, LastSlot);
		}
		System.out.println(LastRow + " " + LastSlot);
	}

	/**
	 * Ustawia ostatnio klikniêty slot.
	 * 
	 * @param slot
	 */
	public void getSlotFromView(int slot) {
		emptySpot = gameController.move(slot);
		if (emptySpot == -1) {
			informationBoxes.fullSlotMessage();
		} else {
			refreshView(emptySpot, slot);
			gameBoard.enableButtons(false);

		}
	}

	/**
	 * Tworzy w¹tek Swing
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
					sideBoard.setBackground(Color.orange);
					stats = frame.getStats();
					stats.setPointsPlayer(gameController.getPlayer1()
							.getPlayerPoints(), PlayerId.PLAYER1);
					stats.setPointsPlayer(gameController.getPlayer2()
							.getPlayerPoints(), PlayerId.PLAYER2);
					stats.setName(gameController.getPlayer1().getName(),
							PlayerId.PLAYER1);
					stats.setName(gameController.getPlayer2().getName(),
							PlayerId.PLAYER2);

					gameController.wakeUpGCr();
					gameBoard.enableButtons(blockButton);
					setNamesAndToken();
					sideBoard.setPreferredSize(new Dimension(215, 200));
					stats.setPreferredSize(new Dimension(215, 200));
					frame.pack();
					frame.setResizable(false);
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
							- frameHeight / 2, 0, 0);
				if (playerId == PlayerId.PLAYER2)
					frame.setBounds(
							screenWidth - screenWidth / 30 - frameWidth,
							screenHeight / 2 - frameHeight / 2, frameWidth,
							frameHeight);
			}
		});
	}

	/**
	 * Odœwie¿a planszê na GUI
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
				gameController.initializeNewGame();
			}
		}
		if (decision == 0) // tak gram dalej
		{
			frame.dispose();
			gameController.initializeNewGame();

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

		sideBoard.setTokenPl2();
		if (playerId == PlayerId.PLAYER1) {
			sideBoard.setTokenPl1();
			sideBoard.setPl1Name(gameController.getPlayer1().getName());
			sideBoard.setPl2Name(gameController.getPlayer2().getName());
		} else {
			sideBoard.setTokenPl2();
			sideBoard.setPl1Name(gameController.getPlayer1().getName());
			sideBoard.setPl2Name(gameController.getPlayer2().getName());
			// 2 - 1 ;
		}

	}

	/**
	 * potencjalna kopia kodu z metody setNamesAndToken
	 */
	public void SemaphoreToken() {
		if (gameController.getCurrentPlayer().getPlayerId() == PlayerId.PLAYER1) {
			System.out.println("playe1");
			sideBoard.semaphorTurnPl1();

		} else {
			System.out.println("playe2");
			sideBoard.semaphorTurnPl2();
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
