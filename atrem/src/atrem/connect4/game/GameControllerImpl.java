package atrem.connect4.game;

import java.awt.Color;
import java.awt.Point;
import java.util.List;

import atrem.connect4.factory.GameConfig;
import atrem.connect4.game.board.Board;
import atrem.connect4.game.board.HoleState;
import atrem.connect4.game.player.PlayerAttributes;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.game.player.PlayerDecision;
import atrem.connect4.game.player.PlayerId;
import atrem.connect4.swing.SwingPresenter;

public class GameControllerImpl implements Runnable, GameController {
	private Logic logic;
	private Board board;
	private int doneMoves;
	private Move lastMove;
	private PlayerController currentPlayer, player1, player2;
	private int emptySpot;
	private PlayerId playerTurn = PlayerId.PLAYER1;
	private ResultState resultState = ResultState.NO_WIN;
	private GameState gameState = GameState.PRE_INIT;
	private PlayerAttributes player1Attributes, player2Attributes;
	private boolean endGame = false;

	/**
	 * Sprawdza którego z graczy jest kolej
	 * 
	 * @return player1 lub player2
	 */
	private PlayerController currentPlayer() {
		switch (playerTurn) {
			case PLAYER1 :
				return player1;
			case PLAYER2 :
				return player2;
			default :
				return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see atrem.connect4.game.GameController#move(int)
	 */
	@Override
	public synchronized int move(int slot) {
		this.currentPlayer = currentPlayer();
		emptySpot = board.findFreeSpot(slot);
		if (emptySpot == -1) {
			return emptySpot;
		}
		board.setHoleState(emptySpot, slot, currentPlayer.getPlayerId());
		board.setLastSlot(slot);
		board.setLastSpot(emptySpot);
		lastMove.saveLastMove(slot, emptySpot, playerTurn);
		if (emptySpot != -1) {
			gameState = GameState.MOVE_DONE;
			notifyAll();
		}
		return emptySpot;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see atrem.connect4.game.GameController#startGameLoop()
	 */
	@Override
	public synchronized void startGameLoop() {
		new Thread(this, "W¹tek kontrolera gry").start();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see atrem.connect4.game.GameController#run()
	 */
	@Override
	public void run() {
		gameLoop();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see atrem.connect4.game.GameController#startNewGame()
	 */
	private synchronized void gameLoop() {// ma odczytywaæ GameState
		logic = new Logic(this);
		lastMove = new Move();
		System.out.println("Starting game.");

		waitForPlayersToConnect();

		waitForPlayersToInit();

		while (resultState == ResultState.NO_WIN) {
			currentPlayer = currentPlayer();
			try {
				Thread.sleep(100); // Dla AI
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			currentPlayer.yourTurn();
			gameState = GameState.WAITING_FOR_MOVE;
			waitForMove();
			doneMoves++;
			endGame = logic.getResultOfMove(lastMove.getLastRow(),
					lastMove.getLastSlot(), doneMoves);
			if (gameIsEnded()) {
				return;
			}
			changePlayer();
		}
	}

	private boolean gameIsEnded() {
		if (endGame) {
			gameState = GameState.PRE_INIT;
			changePlayer();
			currentPlayer = currentPlayer();
			currentPlayer.yourTurn();
			player1.endOfGame(resultState);
			player2.endOfGame(resultState);
			return true;
		}
		return false;
	}
	private synchronized void waitForMove() {
		System.out.println("Czekam na ruch gracza "
				+ currentPlayer.getPlayerId());
		while (gameState != GameState.MOVE_DONE) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private synchronized void waitForPlayersToConnect() {
		while (gameState != GameState.PL2_CONNECTED) {
			try {
				System.out.println("WaitinForPlayers to connect. " + gameState);
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private synchronized void waitForPlayersToInit() {
		while (gameState != GameState.PL2_INITED) {
			try {
				System.out.println("WaitinForPlayers to init. " + gameState);
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public synchronized void connectPlayer() {
		switch (gameState) {
			case PRE_INIT :
				gameState = GameState.PL1_CONNECTED;
				System.out.println(gameState);
				break;
			case PL1_CONNECTED :
				gameState = GameState.PL2_CONNECTED;
				System.out.println(gameState);
				this.notifyAll();
				break;
			default :
				break;
		}
	}

	@Override
	public synchronized void endPlayerInit() {
		switch (gameState) {
			case PL2_CONNECTED :
				gameState = GameState.PL1_INITED;
				System.out.println("Player 1 ready.");
				break;
			case PL1_INITED :
				gameState = GameState.PL2_INITED;
				System.out.println("Player 2 ready.");
				this.notifyAll();
				break;
			default :
				break;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see atrem.connect4.game.GameController#analyseDecision()
	 */
	@Override
	public void analyseDecision() {
		if (player1.getPlayerAttributes().getPlayerDecision() == PlayerDecision.NEW_GAME
				&& player2.getPlayerAttributes().getPlayerDecision() == PlayerDecision.NEW_GAME)
			startNewGame();
		else if (player1.getPlayerAttributes().getPlayerDecision() == PlayerDecision.MENU
				|| player2.getPlayerAttributes().getPlayerDecision() == PlayerDecision.MENU)
			backToMenu();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see atrem.connect4.game.GameController#startNewGame()
	 */
	@Override
	public void startNewGame() {
		int row = board.getRows();
		int slot = board.getSlots();
		PlayerAttributes player1Attributes = player1.getPlayerAttributes();
		PlayerAttributes player2Attributes = player2.getPlayerAttributes();
		Color player1Color = player1Attributes.getPlayerColor();
		Color player2Color = player2Attributes.getPlayerColor();
		lastMove = new Move();
		board = new Board(row, slot);
		resultState = ResultState.NO_WIN;
		gameState = GameState.PRE_INIT;
		startGameLoop();
		if (player1 instanceof SwingPresenter) {
			player1 = new SwingPresenter(this, player1Attributes, player2Color,
					player1.getPlayerPoints(), true);
		} else
			connectPlayer();
		if (player2 instanceof SwingPresenter) {
			player2 = new SwingPresenter(this, player2Attributes, player1Color,
					player2.getPlayerPoints(), true);
		} else
			connectPlayer();

		doneMoves = 0;

	}

	/**
	 * Zmiana tury gracza.
	 */
	private void changePlayer() {
		if (playerTurn == PlayerId.PLAYER1) {
			setPlayerTurn(PlayerId.PLAYER2);
		} else if (playerTurn == PlayerId.PLAYER2) {
			setPlayerTurn(PlayerId.PLAYER1);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see atrem.connect4.game.GameController#backToMenu()
	 */
	@Override
	public void backToMenu() {
		GameConfig config = new GameConfig();
		config.showOfflineDBox();
		config.showOnlineDBox();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see atrem.connect4.game.GameController#wakeUp()
	 */
	@Override
	public void wakeUp() {
		notifyAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see atrem.connect4.game.GameController#getHoleState(int, int)
	 */
	@Override
	public HoleState getHoleState(int rows, int slots) {
		return this.board.getHoleState(rows, slots);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * atrem.connect4.game.GameController#setResult(atrem.connect4.game.ResultState
	 * )
	 */
	@Override
	public void setResult(ResultState result) {
		this.resultState = result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see atrem.connect4.game.GameController#getPlayerTurn()
	 */
	@Override
	public PlayerId getPlayerTurn() {
		return playerTurn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * atrem.connect4.game.GameController#setPlayerTurn(atrem.connect4.game.
	 * player.PlayerId)
	 */
	@Override
	public void setPlayerTurn(PlayerId playerTurn) {
		this.playerTurn = playerTurn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see atrem.connect4.game.GameController#getEmptySpot()
	 */
	@Override
	public int getEmptySpot() {
		return emptySpot;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see atrem.connect4.game.GameController#getResult()
	 */
	@Override
	public ResultState getResult() {
		return resultState;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see atrem.connect4.game.GameController#getBoard()
	 */
	@Override
	public Board getBoard() {
		return board;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * atrem.connect4.game.GameController#setBoard(atrem.connect4.game.board
	 * .Board)
	 */
	@Override
	public void setBoard(Board board) {
		this.board = board;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see atrem.connect4.game.GameController#getPlayer1()
	 */
	@Override
	public PlayerController getPlayer1() {
		return player1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * atrem.connect4.game.GameController#setPlayer1(atrem.connect4.game.player
	 * .PlayerController)
	 */
	@Override
	public void setPlayer1(PlayerController player1) {
		this.player1 = player1;
		player1Attributes = player1.getPlayerAttributes();
	}

	@Override
	public PlayerAttributes getPlayer1Attributes() {
		return player1Attributes;
	}

	@Override
	public void setPlayer1Attributes(PlayerAttributes player1Attributes) {
		this.player1Attributes = player1Attributes;
	}

	@Override
	public PlayerAttributes getPlayer2Attributes() {
		return player2Attributes;
	}

	@Override
	public void setPlayer2Attributes(PlayerAttributes player2Attributes) {
		this.player2Attributes = player2Attributes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see atrem.connect4.game.GameController#getPlayer2()
	 */
	@Override
	public PlayerController getPlayer2() {
		return player2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * atrem.connect4.game.GameController#setPlayer2(atrem.connect4.game.player
	 * .PlayerController)
	 */
	@Override
	public void setPlayer2(PlayerController player2) {
		this.player2 = player2;
		player2Attributes = player2.getPlayerAttributes();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see atrem.connect4.game.GameController#getGamestate()
	 */
	@Override
	public GameState getGameState() {
		return gameState;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see atrem.connect4.game.GameController#getCurrentPlayer()
	 */
	@Override
	public PlayerController getCurrentPlayer() {
		return currentPlayer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see atrem.connect4.game.GameController#getLastMove()
	 */
	@Override
	public Move getLastMove() {
		return lastMove;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * atrem.connect4.game.GameController#setGamestate(atrem.connect4.game.GameState
	 * )
	 */
	@Override
	public void setGamestate(GameState gamestate) {
		this.gameState = gamestate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see atrem.connect4.game.GameController#getLogic()
	 */
	@Override
	public Logic getLogic() {
		return logic;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see atrem.connect4.game.GameController#getWinningCoordinates()
	 */
	@Override
	public List<Point> getWinningCoordinates() {
		return logic.getWinningCoordinates();
	}
}
