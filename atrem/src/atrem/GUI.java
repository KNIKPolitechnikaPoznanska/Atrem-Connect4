package atrem;

public class GUI {
	public void drawBoard(Board BoardTmp) {
		HoleState HoleTmp;
		for (int i = 0; i < BoardTmp.Slots; i++) {
			for (int j = 0; j < BoardTmp.Rows; j++) {
				HoleTmp = BoardTmp.getHoleState(i, j);
				System.out.print("| " + HoleTmp.getNumber() + "| ");
			}
			System.out.println("");
		}
	}
}
