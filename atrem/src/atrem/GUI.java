package atrem;

public class GUI {

	public void drawBoard(Board BoardTmp) {
		HoleState HoleTmp;
		for (int j = 0; j < BoardTmp.getRows(); j++) {
			for (int i = 0; i < BoardTmp.getSlots(); i++) {

				HoleTmp = BoardTmp.getHoleState(j, i);
				System.out.print("| " + HoleTmp.getNumber() + " |");
			}
			System.out.println("");
		}
		this.drawNumber(BoardTmp.getSlots());
	}

	private void drawNumber(int slots) {
		System.out.println("Numery slotów:");
		for (int i = 0; i < slots; i++) {
			System.out.println("| " + i + " |");
		}
		System.out.println("\n\n");
		System.out.println("************************************");
	}
}
