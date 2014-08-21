package atrem.Connect4.Game;
/*
 * klasa przechowujaca dane gry
 */
public class Game {
	private Board board;
	private Player player1;
	private Player player2;
	private int playerTurn = 1;

	public Board getBoard() {
		return board;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public int getPlayerTurn() {
		return playerTurn;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public void setPlayerTurn(int playerTurn) {
		this.playerTurn = playerTurn;
	}
}
