package atrem;

public class Board {
	private int Slots = 7;
	private int Rows = 6;
	private Hole[][] gameBoard = new Hole[Slots][Rows];

	public Board() {

		for (int i = 0; i < Slots; i++)
			for (int j = 0; j < Rows; j++)
				gameBoard[i][j] = new Hole();

	}

	public Board(int Slots, int Rows) {
		this.Slots = Slots;
		this.Rows = Rows;
		for (int i = 0; i < Slots; i++)
			for (int j = 0; j < Rows; j++)
				gameBoard[i][j] = new Hole();

	}

	public HoleState getHoleState(int A, int B) {
		return gameBoard[A][B].getHoleState();
	}

	public void setPlanszaGry(int A, int B, HoleState holeState) {
		gameBoard[A][B].setHoleState(holeState);
	}
}
