package atrem.Connect4.Game.player;

import atrem.Connect4.Game.PlayerId;

/*
 * Klasa obs³uguj¹ca dane graczy
 */

public class PlayerAttributes {
	private String name;
	private PlayerId playerId; // duplikat

	public PlayerAttributes() {
	};

	public PlayerAttributes(String name, PlayerId playerId) {
		this.name = name;
		this.playerId = playerId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public PlayerId getPlayerId() {
		return playerId;
	}

	public void setPlayerId(PlayerId playerId) {
		this.playerId = playerId;
	}
}
