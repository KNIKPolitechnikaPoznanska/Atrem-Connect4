package atrem.Connect4.Game;

/*
 * Klasa obs�uguj�ca dane graczy
 */
public class Player implements PlayerController {
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
