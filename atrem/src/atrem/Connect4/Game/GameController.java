package atrem.Connect4.Game;

import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.board.HoleState;
import atrem.Connect4.Game.player.PlayerController;

public class GameController {
	private Logic logic;
	private Board board;
	private int doneMoves;
	private PlayerController player1, player2;
	private int emptySpot, slot;
	private PlayerTurn playerTurn;

	private ResultState result;// zmiana nazwy na stan

	public void setResult(ResultState result) {
		this.result = result;
	}

	public Logic getLogic() {
		logic = new Logic(this);
		return logic;
	}

	public PlayerTurn getPlayerTurn() {
		return playerTurn;
	}

	public void setPlayerTurn(PlayerTurn playerTurn) {
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
		board.setHoleState(emptySpot, slot, player.getPlayerId()); // gracz
		board.setLastSlot(slot);
		board.setLastSpot(emptySpot);
		notifyAll();
		return emptySpot;

	}

	public synchronized void gameLoop() {//
		PlayerController player = currentPlayer();
		boolean result = false;
		while (!result) {
			player.yourTurn();
			waitThread();
			doneMoves++;
			result = logic.checkResult(doneMoves);
			changePlayer();
			player.goView(emptySpot, slot);

		}
	}

	private void waitThread() {
		while (true) {
			try {
				wait();// zabezpiecz sie!-while
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// // int currentSlot;
	// switch (playerTurn) { //ten switch zly
	// case Player1:
	// player1.teraztwojruch(); wait();
	// setPlayerTurn(PlayerTurn.Player1);
	// break;
	// case Player2:
	// currentSlot = player2.loadSlotNumber();
	// setPlayerTurn(PlayerTurn.Player2);
	// break;
	// default:
	// doneMoves++;
	// logic.checkResult(doneMoves);
	// }

	private void changePlayer() {
		if (playerTurn == PlayerTurn.Player1) {
			setPlayerTurn(PlayerTurn.Player2);
		} else {
			setPlayerTurn(PlayerTurn.Player1);
		}

	}

	public HoleState getHoleState(int rows, int slots) {
		return this.board.getHoleState(rows, slots);
	}
}
