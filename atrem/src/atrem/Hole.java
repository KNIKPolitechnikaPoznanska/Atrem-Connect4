package atrem;

public class Hole {

	private HoleState stanDziury;

	public Hole() {
		stanDziury = HoleState.EMPTY;
	}

	public void setStanDziury(HoleState stanDziury) {
		this.stanDziury = stanDziury;
	}

	public HoleState getStanDziury() {
		return stanDziury;
	}
}
