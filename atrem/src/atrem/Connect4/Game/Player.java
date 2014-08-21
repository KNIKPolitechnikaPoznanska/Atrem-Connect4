package atrem.Connect4.Game;
/*
 * Klasa obs³uguj¹ca dane graczy
 */
public class Player implements PlayerType {
	private String name;
	HoleState playerId;

	public Player(String name, HoleState playerId) {
		this.name = name;
		this.playerId = playerId;
	}

	/* (non-Javadoc)
	 * @see atrem.Connect4.Game.PlayerType#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see atrem.Connect4.Game.PlayerType#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see atrem.Connect4.Game.PlayerType#getPlayerId()
	 */
	@Override
	public HoleState getPlayerId() {
		return playerId;
	}

}
