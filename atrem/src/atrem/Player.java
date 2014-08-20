package atrem;

import java.util.Scanner;

public class Player {
	private String name;
	private int idStat = 1;
	private int id;
	HoleState playerId;
	Scanner in = new Scanner(System.in);

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

	public void go(Board board) {
		Engine engine = new Engine();
		int emptySlot;
		int slot;
		do {
			slot = in.nextInt();
			emptySlot = engine.findFreeSpot(slot, board);
		} while (emptySlot == -1);

		board.setGameBoard(emptySlot, slot, playerId); // gracz

	}
}
