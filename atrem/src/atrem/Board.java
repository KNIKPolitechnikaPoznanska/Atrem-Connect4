package atrem;

public class Board {
	private int Slots;
	private int Rows;
	private Hole[][] gameBoard;

	public Board() {

		for (int i = 0; i < Slots; i++)
			for (int j = 0; j < Rows; j++)
				gameBoard[j][i] = new Hole();

	}

	public Board(int Rows, int Slots) {
		this.Slots = Slots;
		this.Rows = Rows;
		gameBoard = new Hole[Rows][Slots];
		for (int i = 0; i < this.Slots; i++)
			for (int j = 0; j < this.Rows; j++)
				gameBoard[j][i] = new Hole();

	}

	public HoleState getHoleState(int Rows, int Slots) {
		return gameBoard[Rows][Slots].getHoleState();
	}

	public void setGameBoard(int Rows, int Slots, HoleState holeState) {
		gameBoard[Rows][Slots].setHoleState(holeState);
	}

	public int getSlots() {
		return Slots;
	}

	public int getRows() {
		return Rows;
	}

}
