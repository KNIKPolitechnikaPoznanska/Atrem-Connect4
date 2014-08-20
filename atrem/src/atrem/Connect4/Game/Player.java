package atrem.Connect4.Game;

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

	public void go(Board board) {// do gui lub do gameloop
		Engine engine = new Engine();
		int emptySlot;
		int slot;
		do {
			slot = in.nextInt();
			emptySlot = engine.findFreeSpot(slot, board);
		} while (emptySlot == -1);

		board.setHoleState(emptySlot, slot, playerId); // gracz

	}
}
