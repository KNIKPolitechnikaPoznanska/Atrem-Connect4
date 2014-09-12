package atrem.connect4.game.player;

import java.awt.Color;
import java.io.Serializable;

/*
 * Klasa obs³uguj¹ca dane graczy
 */

public class PlayerAttributes implements Serializable {
	private String playerName = "unnamed";
	private PlayerId playerId = PlayerId.PLAYER1;
	private int playerPoints = 0;
	private Color playerColor = null;

	public PlayerAttributes(String playerName, PlayerId playerId,
			int playerPoints, Color playerColor) {
		this.playerName = playerName;
		this.playerId = playerId;
		this.playerPoints = playerPoints;
		this.playerColor = playerColor;
	}

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

	public Color getPlayerColor() {
		return playerColor;
	}

	public void setPlayerColor(Color playerColor) {
		this.playerColor = playerColor;
	}

	public void setName(String playerName) {
		this.playerName = playerName;
	}

	public String getName() {
		return playerName;
	}

	public PlayerId getPlayerId() {
		return playerId;
	}

	public void setPlayerId(PlayerId playerId) {
		this.playerId = playerId;
	}
}
