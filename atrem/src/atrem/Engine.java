package atrem;

public class Engine {

	public int findFreeSpot(int slot, Board board) {
		for (int i = 0; i < 6; i++)// rows zmienna
		{
			HoleState holeState = board.getHoleState(i, slot);
			if (holeState != HoleState.EMPTY) {
				return i - 1; // dla pelnego rowka zwraca -1
			}
		}
		return -1;
	}
}
