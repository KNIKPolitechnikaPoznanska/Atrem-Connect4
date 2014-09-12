package atrem.connect4.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.SwingUtilities;

import atrem.connect4.game.GameController;
import atrem.connect4.game.GameState;
import atrem.connect4.game.ResultState;
import atrem.connect4.game.player.PlayerAttributes;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.game.player.PlayerDecision;
import atrem.connect4.game.player.PlayerId;

public class SwingPresenter implements PlayerController {
	private int LastRow, LastSlot, emptySpot, slots, rows, decision;
	private GameController gameController;
	private PlayerAttributes playerAttributes;
	private GameBoard gameBoard;
	private GameFrame frame;
	private boolean blockButton;
	private PlayerId playerId = PlayerId.PLAYER1;
	private SideBoard sideBoard;
	private Color playerColor = null, opponentColor = null;
	private Stats stats;
	private Dimension screenSize;
	private DialogInformationBoxes informationBoxes;
	private int frameHeight, frameWidth, screenHeight, screenWidth;

	/**
	 * Presenter MVP do GameFrame
	 * 
	 * @param gameController
	 * @param isLocal
	 * @param playerName
	 * @param playerId
	 * @param pl1TokenColor
	 * @param oppTokenColor
	 * @param block
	 */
	public SwingPresenter(GameController gameController,
			PlayerAttributes playerAttributes, Color opponentColor,
			int playerPoints, boolean isLocal) {
		this.gameController = gameController;
		this.playerAttributes = playerAttributes;
		this.playerId = playerAttributes.getPlayerId();
		this.playerColor = playerAttributes.getPlayerColor();
		this.opponentColor = opponentColor;
		this.slots = gameController.getBoard().getSlots();
		this.rows = gameController.getBoard().getRows();

		gameController.connectPlayer();
		if (!isLocal) {
			System.out.println("Czekam na przeciwnika."
					+ gameController.getGameState());
			waitForOpponentToConnect();
			System.out.println("SP tworzy?");
			endInit();
		}
		setupFrame();

	}

	private synchronized void endInit() {
		try {
			wait(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		gameController.endPlayerInit();
	}
	/**
	 * Wywo³ywane przez GC.GameLoop
	 */
	@Override
	public void yourTurn() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				gameBoard.enableButtons(true);
				sideBoard.tokenEnable();
				LastSlot = gameController.getLastMove().getLastSlot();
				LastRow = gameController.getLastMove().getLastRow();

				if (LastRow != -1 && LastSlot != -1) {
					refreshView(LastRow, LastSlot);
				}
				System.out.println(LastRow + " " + LastSlot);
			}
		});
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
			sideBoard.tokenDisable();
		}
	}

	/**
	 * Tworzy w¹tek Swing
	 */
	private void setupFrame() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				System.out.println("Creating frame");
				try {
					screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					frame = new GameFrame(SwingPresenter.this);
					frame.setTitle(playerAttributes.getName());
					setupBounds();
					gameBoard = frame.getGameBoard();
					informationBoxes = new DialogInformationBoxes();
					sideBoard = frame.getSideBoard();
					sideBoard.setBackground(Color.orange);
					sideBoard.setPreferredSize(new Dimension(215, 200));

					stats = frame.getStats();
					stats.setPointsPlayer(gameController.getPlayer1Attributes()
							.getPlayerPoints(), PlayerId.PLAYER1);
					stats.setPointsPlayer(gameController.getPlayer2Attributes()
							.getPlayerPoints(), PlayerId.PLAYER2);
					stats.setName(gameController.getPlayer1Attributes()
							.getName(), PlayerId.PLAYER1);
					stats.setName(gameController.getPlayer2Attributes()
							.getName(), PlayerId.PLAYER2);
					stats.setPreferredSize(new Dimension(215, 200));

					gameBoard.enableButtons(blockButton);
					setNamesAndToken();

					frame.pack();
					frame.setResizable(true);
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

	private synchronized void waitForOpponentToConnect() {
		if (playerId == PlayerId.PLAYER1)
			while (gameController.getGameState() != GameState.PL2_CONNECTED) {
				try {
					System.out.println("StartWait: "
							+ gameController.getGameState());
					wait(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	}

	@Override
	public synchronized void opponentConnected() {
		System.out.println("Opp Connected? " + gameController.getGameState());
		if (gameController.getGameState() == GameState.PL2_CONNECTED
				|| gameController.getGameState() == GameState.PL1_INITED)
			this.notifyAll();
	}

	/**
	 * Odœwie¿a planszê na GUI
	 */
	private void refreshView(final int row, final int slot) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				gameBoard.setFreeRow(row, slot, gameController.getLastMove()
						.getPlayerId());
			}
		});
	}

	/**
	 * Koniec gry. Wyœwietla rezultat gry.
	 */
	@Override
	public void endOfGame(ResultState resultGame) {
		if (resultGame != ResultState.DRAW) {
			markWinningFour(gameController.getWinningCoordinates());
			// gameController.getLogic().getWinningCoordinates().clear();
		}
		switch (resultGame) {
			case DRAW :
				informationBoxes.drawMessage();
				break;
			case PLAYER_1_WIN :
				decision = informationBoxes.winMessage(gameController
						.getPlayer1Attributes().getName());
				if (playerId == PlayerId.PLAYER1)
					playerAttributes.addPoints();
				break;
			case PLAYER_2_WIN :
				decision = informationBoxes.winMessage(gameController
						.getPlayer2Attributes().getName());
				if (playerId == PlayerId.PLAYER2)
					playerAttributes.addPoints();
				break;
			default :
				break;
		}
		makeDecision(decision);
	}

	public void makeDecision(int decision) {
		gameController.connectPlayer();
		if (decision == 1) {
			playerAttributes.setPlayerDecision(PlayerDecision.MENU);
			frame.dispose();
		}
		if (decision == 0) { // tak gram dalej
			playerAttributes.setPlayerDecision(PlayerDecision.NEW_GAME);
			frame.dispose();
		}
		if (decision == 2) {// zamknij
			playerAttributes.setPlayerDecision(PlayerDecision.END_GAME);
			frame.dispose();
			return;
		}
		if (gameController.getGameState() == GameState.PL2_INITED)
			gameController.analyseDecision();
	}

	private void markWinningFour(List<Point> winningCoordinates) {

		for (int i = 0; i < winningCoordinates.size(); i++) {
			gameBoard.setColor((int) winningCoordinates.get(i).getX(),
					(int) winningCoordinates.get(i).getY(), Color.PINK);
		}
	}

	/**
	 * Ustawia Imiona graczy na Labelach
	 */
	public void setNamesAndToken() {
		if (playerId == PlayerId.PLAYER1) {
			sideBoard.setTokenPl1();
			sideBoard.setPl1Name(gameController.getPlayer1Attributes()
					.getName());
			sideBoard.setPl2Name(gameController.getPlayer2Attributes()
					.getName());
		} else {
			sideBoard.setTokenPl2();
			sideBoard.setPl1Name(gameController.getPlayer2Attributes()
					.getName());
			sideBoard.setPl2Name(gameController.getPlayer1Attributes()
					.getName());
		}
	}

	// public void SemaphoreToken() {
	// if (gameController.getCurrentPlayer().getPlayerId() == PlayerId.PLAYER1)
	// {
	// System.out.println("playe1");
	// sideBoard.semaphorTurnPl1();
	// } else {
	// System.out.println("playe2");
	// sideBoard.semaphorTurnPl2();
	// }
	// }

	public Color getOpponentColor() {
		return opponentColor;
	}

	@Override
	public PlayerAttributes getPlayerAttributes() {
		return playerAttributes;
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

	@Override
	public Color getColor() {
		return playerColor;
	}

	@Override
	public Color getOppColor() {
		return opponentColor;
	}

	@Override
	public void setPlayerId(PlayerId playerId) {
		this.playerId = playerId;
	}
}
