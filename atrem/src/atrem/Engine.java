package atrem;

public class Engine {

	public int findFreeSpot(int slot, Board board) {
		int i = 0;

		for (i = 0; i < board.getRows(); i++)// rows zmienna
		{
			HoleState holeState = board.getHoleState(slot, i);
			if (i == 0 && holeState != HoleState.EMPTY)
				return -1;
			if (holeState != HoleState.EMPTY) {
				return i - 1; // dla pelnego rowka zwraca -1
			}
		}
		return i - 1;
	}
}
