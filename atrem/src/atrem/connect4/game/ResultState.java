package atrem.connect4.game;

public enum ResultState {
	NoWin(0), Player1Win(1), Player2Win(2), Draw(3);

	private int numberRepresentation;

	private ResultState(int i) {
		this.numberRepresentation = i;
	}

	public int getNumber() {
		return numberRepresentation;
	}
}
