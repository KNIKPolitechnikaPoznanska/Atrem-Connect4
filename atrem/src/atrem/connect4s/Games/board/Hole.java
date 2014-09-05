package atrem.connect4s.Games.board;
/*
 * Wykonywane przez Board
 * do stworzenia planszy z elementami Hole
 */
public class Hole {
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
