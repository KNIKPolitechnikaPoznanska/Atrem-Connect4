package atrem.connect4.game;

import java.io.Serializable;

import atrem.connect4.game.player.PlayerId;

public class Move implements Serializable {// TODO zmienic na Move
	private int lastSlot, lastRow;// TODO zmienic na point
	private PlayerId playerId;

	public Move() {
		lastRow = -1;
		lastSlot = -1;
	}

	public int getLastSlot() {
		return lastSlot;
	}

	public void setLastSlot(int lastSlot) {
		this.lastSlot = lastSlot;
	}

	public int getLastRow() {
		return lastRow;
	}

	public void setLastRow(int lastRow) {
		this.lastRow = lastRow;
	}

	public PlayerId getPlayerId() {
		return playerId;
	}

	public void setPlayerId(PlayerId playerId) {
		this.playerId = playerId;
	}

	public synchronized void saveLastMove(int slot, int row, PlayerId playerId) {
		lastSlot = slot;
		lastRow = row;
		this.playerId = playerId;
	}
}
