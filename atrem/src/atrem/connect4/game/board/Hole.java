package atrem.connect4.game.board;

import java.io.Serializable;

/*
 * Wykonywane przez Board
 * do stworzenia planszy z elementami Hole
 */
public class Hole implements Serializable {
	private HoleState holeState;

	public Hole() {
		holeState = HoleState.EMPTY;
	}

	public void setHoleState(HoleState holeState) {
		this.holeState = holeState;
	}

	public HoleState getHoleState() {
		return holeState;
	}
}
