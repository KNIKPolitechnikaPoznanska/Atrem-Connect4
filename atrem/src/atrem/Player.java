package atrem;

public class Player {
	private String imie;
	private static int idStat = 1;
	private int id;

	public Player(String imie) {
		this.imie = imie;
		this.id = idStat;
		this.idStat++;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void go(int slot, Board board) {
		Engine engine = new Engine();
		int emptySlot = engine.findFreeSpot(slot, board);
		board.setGameBoard(emptySlot, slot, HoleState.PLAYER2); // gracz
	}
}
