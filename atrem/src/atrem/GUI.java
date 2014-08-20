package atrem;

public class GUI {

	public void drawBoard(Board BoardTmp) {
		HoleState HoleTmp;
		for (int i = 0; i < BoardTmp.getSlots(); i++) {
			for (int j = 0; j < BoardTmp.getRows(); j++) {
				HoleTmp = BoardTmp.getHoleState(i, j);
				System.out.print("| " + HoleTmp.getNumber() + " |");
			}
			System.out.println("");
		}
		this.drawNumber(BoardTmp.getSlots());
	}

	private void drawNumber(int slots) {
		System.out.println("Numery slotów:");
		for (int i = 0; i < slots; i++) {
			System.out.print("| " + i + " |");

		}
	}

}
