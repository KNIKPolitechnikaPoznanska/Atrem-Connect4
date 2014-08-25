package atrem.Connect4.Game.player;

import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.board.HoleState;

/*
 * Klasa obs³uguj¹ca dane graczy
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
