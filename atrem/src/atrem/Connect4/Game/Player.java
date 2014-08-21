package atrem.Connect4.Game;

/*
 * Klasa obs³uguj¹ca dane graczy
 */
public class Player {
	protected String name;
	protected HoleState playerId;

	protected int slots;

	public Player() {
	};

	public Player(int slots, String name, HoleState playerId) {
		this.name = name;
		this.playerId = playerId;
		this.slots = slots;
	}

}
