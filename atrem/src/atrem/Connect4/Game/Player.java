package atrem.Connect4.Game;

/*
 * Klasa obs�uguj�ca dane graczy
 */
public class Player {
	protected String name;
	protected HoleState playerId;

	protected int maxSlots;

	public Player() {
	};

	public Player(int maxSlots, String name, HoleState playerId) {
		this.name = name;
		this.playerId = playerId;
		this.maxSlots = maxSlots;
	}

	public void setName(String name) {
		this.name = name;

	}

}
