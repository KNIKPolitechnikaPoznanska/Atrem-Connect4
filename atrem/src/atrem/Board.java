package atrem;

public class Board {
	public static int Slots = 4;
	public static int Rows = 4;
	public static Hole[][] gameBoard = new Hole[Slots][Rows];

	public Board() {

		for (int i = 0; i < Slots; i++)
			for (int j = 0; j < Rows; j++)
				gameBoard[i][j] = new Hole();

	}

	public HoleState getHoleState(int A, int B) {
		return gameBoard[A][B].getHoleState();
	}

	public void setPlanszaGry(Hole[][] planszaGry) {
		Board.gameBoard = planszaGry;
	}
}
