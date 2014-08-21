package atrem.Connect4.Game;

/*
 * Klasa obsługująca dane graczy
 */

public class Player {
	protected String name;
	protected HoleState playerId;
	protected Board board;

	public Player() {
	};

	public Player(Board board, String name, HoleState playerId) {
		this.name = name;
		this.playerId = playerId;
		this.board = board;
	}

	public void setName(String name) {
		this.name = name;
	}
}
