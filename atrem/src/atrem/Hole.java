package atrem;

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
