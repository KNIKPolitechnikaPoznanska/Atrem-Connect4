package atrem;

public enum HoleState {
	PLAYER1(1), PLAYER2(2), EMPTY(0);

	private int numberRepresentation;

	private HoleState(int numberRepresentation) {
		this.numberRepresentation = numberRepresentation;
	}

	public int getNumber() {
		return numberRepresentation;
	}
}
