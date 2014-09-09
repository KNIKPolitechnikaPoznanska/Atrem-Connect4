package atrem.connect4.game;

import java.awt.Color;

import atrem.connect4.game.board.Board;
import atrem.connect4.game.board.HoleState;
import atrem.connect4.game.player.PlayerAttributes;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.swing.SwingPresenter;

public class GameController implements Runnable {
	private Logic logic;
	private Board board;
	private int doneMoves;
	private LastMove lastMove;
	private PlayerController currentPlayer, player1, player2;

	public PlayerController getCurrentPlayer() {
		return currentPlayer;
	}

	private int emptySpot, slot;
	private PlayerId playerTurn = PlayerId.PLAYER1;
	private ResultState resultState = ResultState.NO_WIN;
	private GameState gameState = GameState.PRE_INIT;
	private Color pl1Color, pl2Color;
	private PlayerAttributes player1Attributes, player2Attributes;

	/**
	 * Sprawdza którego z graczy jest kolej
	 * 
	 * @return player1 lub player2
	 */
	private PlayerController currentPlayer() {
		switch (playerTurn) {
		case PLAYER1:
			return player1;
		case PLAYER2:
			return player2;
		default:
			return null; // player1
		}
	}

	/**
	 * @param slot
	 * @return puste miejsce w Board
	 */
	public synchronized int move(int slot) {
		this.currentPlayer = currentPlayer();
		this.slot = slot;
		emptySpot = board.findFreeSpot(slot);
		if (emptySpot == -1) {
			return emptySpot;
		}
		board.setHoleState(emptySpot, slot, currentPlayer.getPlayerId());
		board.setLastSlot(slot);
		board.setLastSpot(emptySpot);
		lastMove.saveLastMove(slot, emptySpot, playerTurn);

		gameState = GameState.MOVE_DONE;
		if (emptySpot != -1) {
			notifyAll();
		}
		return emptySpot;
	}

	/**
	 * Glowna petla gry
	 */

	public void startNewGame() {
		int row = board.getRows();
		int slot = board.getSlots();
		lastMove = new LastMove();
		board = new Board(row, slot);
		resultState = ResultState.NO_WIN;
		gameState = GameState.PRE_INIT;
		startGameLoop();
		player1Attributes = new PlayerAttributes(player1.getName(),
				PlayerId.PLAYER1, player1.getPlayerPoints(), pl1Color);
		player2Attributes = new PlayerAttributes(player2.getName(),
				PlayerId.PLAYER2, player2.getPlayerPoints(), pl2Color);
		if (player1 instanceof SwingPresenter) {
			player1 = new SwingPresenter(this, player1Attributes, pl2Color,
					player1.getPlayerPoints());
		}
		if (player2 instanceof SwingPresenter) {
			player2 = new SwingPresenter(this, player2Attributes, pl1Color,
					player2.getPlayerPoints());
		}

	}

	private synchronized void gameLoop() {// ma odczytywaæ GameState
		boolean endGame;
		logic = new Logic(this);
		lastMove = new LastMove();
		System.out.println("przed init");
		waitForInit();
		while (resultState == ResultState.NO_WIN) {
			currentPlayer = currentPlayer();
			try {
				this.wait(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			currentPlayer.yourTurn();
			System.out.println("po ");
			gameState = GameState.WAITING_FOR_MOVE;
			waitForMove();
			doneMoves++;
			endGame = logic.getResultOfMove(lastMove.getLastRow(),
					lastMove.getLastSlot(), doneMoves);

			if (endGame) {
				gameState = GameState.PRE_INIT;
				changePlayer();
				currentPlayer = currentPlayer();
				currentPlayer.yourTurn();
				player1.endOfGame(resultState);
				player2.endOfGame(resultState);
				return;
			}
			changePlayer();

		}
	}

	private synchronized void waitForMove() {
		while (gameState != GameState.MOVE_DONE) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private synchronized void waitForInit() {
		while (gameState != GameState.END_INIT_ALL) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void wakeUpGCr() {
		switch (gameState) {
		case PRE_INIT:
			gameState = GameState.END_INIT_1;
			break;
		case END_INIT_1:
			gameState = GameState.END_INIT_ALL;
			this.notifyAll();
			break;
		default:
			break;
		}
	}

	public void analyseDecision() {
		if (player1.getPlayerAttributes().getPlayerDecision() == PlayerDecision.NEW_GAME
				&& player2.getPlayerAttributes().getPlayerDecision() == PlayerDecision.NEW_GAME)
			startNewGame();
		else if (player1.getPlayerAttributes().getPlayerDecision() == PlayerDecision.MENU
				|| player2.getPlayerAttributes().getPlayerDecision() == PlayerDecision.MENU)
			backToMenu();

	}

	@Override
	public void run() {
		gameLoop();
	}

	public void startGameLoop() {
		new Thread(this, "W¹tek kontrolera gry").start();
	}

	/**
	 * Zmiana tury gracza.
	 */
	private void changePlayer() {
		if (playerTurn == PlayerId.PLAYER1) {
			setPlayerTurn(PlayerId.PLAYER2);
		} else {
			setPlayerTurn(PlayerId.PLAYER1);
		}
	}

	public void backToMenu() {
		GameFactory gameFactory = new GameFactory();
		GameConfig config = new GameConfig(gameFactory);
		config.setDBox();
	}

	public void wakeUp() {
		notifyAll();
	}

	public HoleState getHoleState(int rows, int slots) {
		return this.board.getHoleState(rows, slots);
	}

	public void setResult(ResultState result) {
		this.resultState = result;
	}

	public PlayerId getPlayerTurn() {
		return playerTurn;
	}

	public void setPlayerTurn(PlayerId playerTurn) {
		this.playerTurn = playerTurn;
	}

	public void setPl1Color(Color pl1Color) {
		this.pl1Color = pl1Color;
	}

	public void setPl2Color(Color pl2Color) {
		this.pl2Color = pl2Color;
	}

	public int getEmptySpot() {
		return emptySpot;
	}

	public ResultState getResult() {
		return resultState;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Color getPl1Color() {
		return pl1Color;
	}

	public Color getPl2Color() {
		return pl2Color;
	}

	public PlayerController getPlayer1() {
		return player1;
	}

	public void setPlayer1(PlayerController player1) {
		this.player1 = player1;
	}

	public PlayerController getPlayer2() {
		return player2;
	}

	public void setPlayer2(PlayerController player2) {
		this.player2 = player2;
	}

	public GameState getGamestate() {
		return gameState;
	}

	public LastMove getLastMove() {
		return lastMove;
	}

	public void setGamestate(GameState gamestate) {
		this.gameState = gamestate;
	}

	public Logic getLogic() {
		return logic;
	}
}
