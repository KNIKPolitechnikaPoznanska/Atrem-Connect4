package atrem.Connect4.Game;

/*
 * Klasa obsługująca dane graczy
 */
public class Player {
	protected String name;
	protected HoleState playerId;

	public Player() {
	};

	public Player(String name, HoleState playerId) {
		this.name = name;
		this.playerId = playerId;
	}

}
