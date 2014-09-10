package atrem.connect4.game.board;

import java.io.Serializable;

import atrem.connect4.game.player.PlayerId;

/*
 * Tworzenie planszy 
 * poprzez wype³nienie obiektami klasy Hole
 */
public class Board implements Serializable {
	private int slots, rows, lastSlot, lastRow;
	private Hole[][] gameBoard;
	private int totalSpots;

	public Board() {
		for (int i = 0; i < slots; i++)
			for (int j = 0; j < rows; j++)
				gameBoard[j][i] = new Hole();
	}

	public Board(int rows, int slots) {
		this.slots = slots;
		this.rows = rows;
		gameBoard = new Hole[rows][slots];
		for (int i = 0; i < this.slots; i++)
			for (int j = 0; j < this.rows; j++)
				gameBoard[j][i] = new Hole();
		totalSpots = slots * rows;
	}

	/**
	 * Ustawia 'dziurê' na EMPTY
	 * 
	 * @param row
	 * @param slot
	 */
	public void cleanSpot(int row, int slot) {
		setHoleState(row, slot, HoleState.EMPTY);
	}

	/**
	 * Ustawia stan 'dziury'
	 * 
	 * @param row
	 * @param slot
	 * @param playerId
	 */
	public void setHoleState(int row, int slot, PlayerId playerId) {
		HoleState holeState = playerIdtoHoleState(playerId);
		gameBoard[row][slot].setHoleState(holeState);
	}

	public HoleState playerIdtoHoleState(PlayerId playerId) {
		if (playerId == PlayerId.PLAYER1) {
			return HoleState.PLAYER1;
		} else {
			return HoleState.PLAYER2;
		}
	}

	public void setHoleState(int Rows, int Slots, HoleState holeState) {
		gameBoard[Rows][Slots].setHoleState(holeState);
	}

	public int getTotalSpots() {
		return totalSpots;
	}

	public HoleState getHoleState(int Rows, int Slots) {
		return gameBoard[Rows][Slots].getHoleState();
	}

	public int findFreeSpot(int slot) {
		int i = 0;
		for (i = 0; i < getRows(); i++) {
			HoleState holeState = getHoleState(i, slot);
			if (i == 0 && holeState != HoleState.EMPTY) // gdy jest pelen
				return -1;
			if (holeState != HoleState.EMPTY) {
				{
					return i - 1;
				}
			}
		}
		return i - 1;
	}

	public int getSlots() {
		return slots;
	}

	public int getRows() {
		return rows;
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

	public void setLastSpot(int lastRow) {
		this.lastRow = lastRow;
	}
}
