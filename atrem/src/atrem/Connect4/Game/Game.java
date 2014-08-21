package atrem.Connect4.Game;
/*
 * klasa przechowujaca dane gry
 */
public class Game {
	private Board board;
	private PlayerType player1;
	private PlayerType player2;
	private int playerTurn = 1;

	public Board getBoard() {
		return board;
	}

	public PlayerType getPlayer1() {
		return player1;
	}

	public PlayerType getPlayer2() {
		return player2;
	}

	public int getPlayerTurn() {
		return playerTurn;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public void setPlayer1(PlayerType player1) {
		this.player1 = player1;
	}

	public void setPlayer2(PlayerType player2) {
		this.player2 = player2;
	}

	public void setPlayerTurn(int playerTurn) {
		this.playerTurn = playerTurn;
	}
}
