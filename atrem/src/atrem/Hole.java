package atrem;

public class Hole {

	private HoleState holeState;

	public Hole() {
		holeState = HoleState.EMPTY;
	}

	public void setStanDziury(HoleState stanDziury) {
		this.holeState = stanDziury;
	}

	public HoleState getStanDziury() {
		return holeState;
	}
}
