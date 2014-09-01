package atrem.Connect4.Game.player;

import atrem.Connect4.Game.board.HoleState;

/*
 * Klasa obs³uguj¹ca dane graczy
 */

public class PlayerAttributes {
	private String name;
	private HoleState playerId; // duplikat

	public PlayerAttributes() {
	};

	public PlayerAttributes(String name, HoleState playerId) {
		this.name = name;
		this.playerId = playerId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public HoleState getPlayerId() {
		return playerId;
	}

	public void setPlayerId(HoleState playerId) {
		this.playerId = playerId;
	}
}
