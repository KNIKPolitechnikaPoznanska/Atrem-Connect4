package atrem;

public class Player {
	private String name;
	private int idStat = 1;
	private int id;
	HoleState playerId;

	public Player(String name, HoleState playerId) {
		this.name = name;
		this.id = idStat;
		this.idStat++;
		this.playerId = playerId;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

		board.setGameBoard(emptySlot, slot, playerId); // gracz

	}
}
