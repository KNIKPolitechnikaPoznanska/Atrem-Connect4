package atrem.connect4.game;

public enum ResultState {
	NO_WIN(0), PLAYER_1_WIN(1), PLAYER_2_WIN(2), DRAW(3);

	private int numberRepresentation;

	private ResultState(int i) {
		this.numberRepresentation = i;
	}

	public int getNumber() {
		return numberRepresentation;
	}
}
