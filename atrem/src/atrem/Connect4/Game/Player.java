package atrem.Connect4.Game;
/*
 * Klasa obs³uguj¹ca dane graczy
 */
public class Player {
	private String name;
	HoleState playerId;

	public Player(String name, HoleState playerId) {
		this.name = name;
		this.playerId = playerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HoleState getPlayerId() {
		return playerId;
	}

}
