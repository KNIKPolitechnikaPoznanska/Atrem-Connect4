package atrem.Connect4.Game;

/*
 * Klasa obs³uguj¹ca dane graczy
 */
public class Player implements PlayerController {
	private String name;
	HoleState playerId;

	public Player(String name, HoleState playerId) {
		this.name = name;
		this.playerId = playerId;
	}

	/*
	 * Pobierz imie gracza
	 */
	@Override
	public String getName() {
		return name;
	}

	/*
	 * Ustaw imie gracza
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * Pobierz playerId
	 */
	@Override
	public HoleState getPlayerId() {
		return null;
	}

	@Override
	public int getSlots() {
		return 0;
	}

}
