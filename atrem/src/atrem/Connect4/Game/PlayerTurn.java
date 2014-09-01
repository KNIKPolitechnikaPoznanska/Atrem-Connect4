package atrem.Connect4.Game;

public enum PlayerTurn {
	Player1(1), Player2(2), Null(0);
	private int numberRepresentation;

	private PlayerTurn(int i) {
		numberRepresentation = i;
	}

	public int getNumber() {
		return numberRepresentation;
	}
}
