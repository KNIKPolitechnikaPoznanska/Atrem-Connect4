package atrem;

public class Board {
	private int Slots;
	private int Rows;
	private Hole[][] gameBoard;

	public Board() {

		for (int i = 0; i < Slots; i++)
			for (int j = 0; j < Rows; j++)
				gameBoard[i][j] = new Hole();

	}

	public Board(int Slots, int Rows) {
		this.Slots = Slots;
		this.Rows = Rows;
		gameBoard = new Hole[Slots][Rows];
		for (int i = 0; i < this.Slots; i++)
			for (int j = 0; j < this.Rows; j++)
				gameBoard[i][j] = new Hole();

	}

	public HoleState getHoleState(int A, int B) {
		return gameBoard[A][B].getHoleState();
	}

	public void setGameBoard(int A, int B, HoleState holeState) {
		gameBoard[A][B].setHoleState(holeState);
	}

	public int getSlots() {
		return Slots;
	}

	public int getRows() {
		return Rows;
	}

}
