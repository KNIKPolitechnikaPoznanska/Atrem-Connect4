package atrem;

public class Connect4 {

	private static Board board;
	private static Hole[][] hole;
	private static int slots;
	private static int rows;

	public static void main(String[] args) {
		slots = board.getSlots();
		rows = board.getRows();
		board = new Board(slots, rows);

	}
}
