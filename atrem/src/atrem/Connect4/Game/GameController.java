package atrem.Connect4.Game;

import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.board.HoleState;
import atrem.Connect4.Game.player.PlayerController;

public class GameController {
	// public void wykonalemRuch(HoleState playerId, int slot);
	private Logic logic;
	private Board board;
	private int doneMoves;
	private PlayerController player1, player2;
	private int emptySpot;
	private PlayerTurn playerTurn;

	private ResultState result;

	public void setResult(ResultState result) {
		this.result = result;
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

	public void go(PlayerController player, int slot) {
		emptySpot = board.findFreeSpot(slot);
		if (emptySpot == -1) {
			return;
		}
		board.setHoleState(emptySpot, slot, player.getPlayerId()); // gracz
		board.setLastSlot(slot);
		board.setLastSpot(emptySpot);

	}

	public int move(int currentSlot) {//

		// int currentSlot;
		switch (playerTurn) {
		case Player1:
			currentSlot = player1.loadSlotNumber();
			this.go(player1, currentSlot);
			setPlayerTurn(PlayerTurn.Player2);
		case Player2:
			currentSlot = player2.loadSlotNumber();
			this.go(player2, currentSlot);
			setPlayerTurn(PlayerTurn.Player2);
		default:
			doneMoves++;
			logic.checkResult(currentSlot);
			return emptySpot;
		}
	}

	public HoleState getHoleState(int rows, int slots) {
		return this.board.getHoleState(rows, slots);
	}
}
