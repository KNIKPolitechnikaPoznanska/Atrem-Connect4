package atrem.Connect4.Game;

/*
 * Klasa obs³uguj¹ca dane graczy
 */
public class Player implements PlayerController {
	protected String name;
	HoleState playerId;

	public Player() {
	};

	public Player(String name, HoleState playerId) {
		this.name = name;
		this.playerId = playerId;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public HoleState getPlayerId() {
		return null;
	}

	@Override
	public int getSlots() {
		return 0;
	}

}
