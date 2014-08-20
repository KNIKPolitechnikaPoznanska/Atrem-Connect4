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
		this.drawSlots(BoardTmp.getSlots());
	}

	private void drawSlots(int slots) {
		System.out.println("Numery slotów:");
		for (int i = 0; i < slots; i++) {
			System.out.print("| " + i + " |");
		}
		System.out.println("\n");
		System.out.println("************************************");
	}
}
