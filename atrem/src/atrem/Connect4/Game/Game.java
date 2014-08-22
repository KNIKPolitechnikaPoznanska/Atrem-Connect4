package atrem.Connect4.Game;

import atrem.Connect4.Game.player.PlayerController;

/*
 * klasa przechowujaca dane gry
 */
public class Game {
	private Board board;
	private PlayerController player1;
	private PlayerController player2;
	private int playerTurn = 1;

	public Board getBoard() {
		return board;
	}

	public PlayerController getPlayer1() {
		return player1;
	}

	public PlayerController getPlayer2() {
		return player2;
	}

	public int getPlayerTurn() {
		return playerTurn;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public void setPlayer1(PlayerController player1) {
		this.player1 = player1;
	}

	public void setPlayer2(PlayerController player2) {
		this.player2 = player2;
	}

	public void setPlayerTurn(int playerTurn) {
		this.playerTurn = playerTurn;
	}

	public HoleState getHoleState(int rows, int slots) {
		return this.board.getHoleState(rows, slots);
	}

	public int getBoardSlots() {
		return this.board.getSlots();
	}

	public int getBoardRows() {
		return this.board.getRows();
	}

	public String getNamePlayer1() {
		return this.player1.getName();
	}

	public String getNamePlayer2() {
		return this.player2.getName();
	}
}
