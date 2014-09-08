package atrem.connect4.game.player;

import atrem.connect4.game.PlayerDecision;
import atrem.connect4.game.PlayerId;

/*
 * Klasa obs³uguj¹ca dane graczy
 */

public class PlayerAttributes {
	private String name;
	private PlayerId playerId; // duplikat
	private int playerPoints;
	private PlayerDecision playerDecision;

	public PlayerDecision getPlayerDecision() {
		return playerDecision;
	}

	public void setPlayerDecision(PlayerDecision playerDecision) {
		this.playerDecision = playerDecision;
	}

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
