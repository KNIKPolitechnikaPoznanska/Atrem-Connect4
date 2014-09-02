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
	private ResultState result;// zmiana nazwy na stan
	private GameState gamestate;

	public void setResult(ResultState result) {
		this.result = result;
	}

	public Logic getLogic() { // czy powienien sie tworzyc w getterze nowy
								// obiekt logic? PAWE£ w Call Hierarchy widac ze
								// logica tworzy sie tylko przy stworzeniu
								// kompa, do tego logica w konstrukotrze pobiera
								// slot i rows z boarda w GC. Teraz logica jest
								// tworzona(?) przed boardem
								// PAWEL
		logic = new Logic(this);
		return logic;
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
		return result;
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

	public synchronized int move(int slot) {
		PlayerController player = currentPlayer();
		this.slot = slot;
		emptySpot = board.findFreeSpot(slot);
		if (emptySpot == -1) {
			return emptySpot;
		}
		board.setHoleState(emptySpot, slot, player.getPlayerId()); // zmienic id
																	// na
																	// plyerTurn
		board.setLastSlot(slot);
		board.setLastSpot(emptySpot);
		gamestate = GameState.moveDone;
		notifyAll();
		return emptySpot;

	}

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
			player.goView(emptySpot, slot);

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
}
