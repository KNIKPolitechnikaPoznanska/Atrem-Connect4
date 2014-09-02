package atrem.Connect4.Game;

import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.board.HoleState;
import atrem.Connect4.Game.player.PlayerController;

public class GameController {
	private Logic logic;

	private Board board;
	private int doneMoves;
	private LastMove lastMove;
	private PlayerController player1, player2;
	private int emptySpot, slot;
	private PlayerId playerTurn;
	private ResultState gameState;// zmiana nazwy na stan
	private GameState gamestate;

	public void createLogic() {
		logic = new Logic(this);
	}

	private PlayerController currentPlayer() {
		switch (playerTurn) {
		case Player1:
			return player1;
		case Player2:
			return player2;
		default:
			return player1;
		}
	}

	/**
	 * @param slot
	 * @return puste miejsce w Board
	 */
	public synchronized int move(int slot) {
		PlayerController player = currentPlayer();
		this.slot = slot;
		emptySpot = board.findFreeSpot(slot);
		if (emptySpot == -1) {
			return emptySpot;
		}
		board.setHoleState(emptySpot, slot, player.getPlayerId());
		board.setLastSlot(slot);
		board.setLastSpot(emptySpot);
		lastMove.saveLastMove(slot, emptySpot);
		gamestate = GameState.moveDone;
		notifyAll();
		return emptySpot;

	}

	/**
	 * glowna petla gry
	 */
	public synchronized void gameLoop() {// ma odczytywaæ GameState
		PlayerController player = currentPlayer();
		boolean result = false;
		while (!result) {
			player.yourTurn();
			gamestate = GameState.waitingForMove;
			waitForMove();
			doneMoves++;
			result = logic.checkResult(doneMoves);
			changePlayer();
			// player.goView(emptySpot, slot);

		}
	}

	private void waitForMove() {
		while (gamestate != GameState.moveDone) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void changePlayer() {
		if (playerTurn == PlayerId.Player1) {
			setPlayerTurn(PlayerId.Player2);
		} else {
			setPlayerTurn(PlayerId.Player1);
		}

	}

	public HoleState getHoleState(int rows, int slots) {
		return this.board.getHoleState(rows, slots);
	}

	public void setResult(ResultState result) {
		this.gameState = result;
	}

	public PlayerId getPlayerTurn() {
		return playerTurn;
	}

	public void setPlayerTurn(PlayerId playerTurn) {
		this.playerTurn = playerTurn;
	}

	public int getEmptySpot() {
		return emptySpot;
	}

	public ResultState getResult() {
		return gameState;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
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
		return gamestate;
	}

	public LastMove getLastMove() {
		return lastMove;
	}

	public void setGamestate(GameState gamestate) {
		this.gamestate = gamestate;
	}

	public Logic getLogic() {
		return logic;
	}
}
