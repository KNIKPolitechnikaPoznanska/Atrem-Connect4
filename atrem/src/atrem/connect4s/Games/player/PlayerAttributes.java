package atrem.connect4s.Games.player;

import atrem.connect4s.Games.PlayerId;

/*
 * Klasa obs³uguj¹ca dane graczy
 */

public class PlayerAttributes {
	private String name;
	private PlayerId playerId; // duplikat
	private int playerPoints;

	public int getPlayerPoints() {
		return playerPoints;
	}

	public void addPoints() {
		playerPoints++;
	}

	public void setPlayerPoints(int playerPoints) {
		this.playerPoints = playerPoints;
	}

	public PlayerAttributes() {
	};

	public PlayerAttributes(String name, PlayerId playerId, int playerPoints) {
		this.name = name;
		this.playerId = playerId;
		this.playerPoints = playerPoints;
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
