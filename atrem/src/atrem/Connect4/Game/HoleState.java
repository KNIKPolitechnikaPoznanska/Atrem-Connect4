package atrem.Connect4.Game;
/*
 * enum do klasy Hole
 * zawieraj�ce warto�� pola planszy
 */
public enum HoleState {
	PLAYER1(1), PLAYER2(2), EMPTY(0);

	private int numberRepresentation;

	private HoleState(int i) {
		this.numberRepresentation = i;
	}

	public int getNumber() {
		return numberRepresentation;
	}
}
