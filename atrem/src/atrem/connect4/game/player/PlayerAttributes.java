package atrem.connect4.game.player;

import java.awt.Color;

import atrem.connect4.game.PlayerId;

/*
 * Klasa obs³uguj¹ca dane graczy
 */

public class PlayerAttributes {
	private String playerName;
	private PlayerId playerId;
	private int playerPoints;
	private Color playerColor;

	public PlayerAttributes(String playerName, PlayerId playerId, int playerPoints,
			Color playerColor) {
		this.playerName = playerName;
		this.playerId = playerId;
		this.playerPoints = playerPoints;
		this.playerColor = playerColor;
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
