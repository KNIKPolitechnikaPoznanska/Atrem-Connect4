package atrem.Connect4.Game.board;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import atrem.Connect4.Game.player.PlayerController;
import atrem.Connect4.console.Task;

/*
 * Tworzenie planszy 
 * poprzez wype³nienie obiektami klasy Hole
 */
public class Board {
	private int slots;
	private int rows;
	private Hole[][] gameBoard;
	private int totalSpots;
	private int lastSlot;
	private int lastRow;
	private ExecutorService thread = Executors.newSingleThreadExecutor();

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

	public void cleanSpot(int row, int slot)

	{
		setHoleState(row, slot, HoleState.EMPTY);
	}

	public int getTotalSpots() {
		return totalSpots;
	}

	public HoleState getHoleState(int Rows, int Slots) {
		return gameBoard[Rows][Slots].getHoleState();
	}

	public void setHoleState(int Rows, int Slots, HoleState holeState) {
		gameBoard[Rows][Slots].setHoleState(holeState);
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

	public int findFreeSpot(int slot) {
		int i = 0;
		for (i = 0; i < getRows(); i++) {
			HoleState holeState = getHoleState(i, slot);
			if (i == 0 && holeState != HoleState.EMPTY) // gdy jest pelen
				return -1;
			if (holeState != HoleState.EMPTY) {
				{
					System.out.println("findfs");
					return i - 1;

				}
			}
		}
		return i - 1;
	}

	public synchronized void go(PlayerController player) { // wywalic z konsoli
		// uniwersalne

		int emptySlot;
		int slot = 4;
		do {
<<<<<<< HEAD
			// slot = player.getCurrentSlot(); // CKeyHandler.getSlot

			thread.execute(new Task(player, this));
			try {
				System.out.println("przed wait");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			slot = player.getCurrentSlot();
=======
			slot = player.getSlotNumber(); // CKeyHandler.getSlot
			System.out.println(slot + " z go");
>>>>>>> branch 'master' of https://github.com/KNIKPolitechnikaPoznanska/AtremProject.git
			emptySlot = findFreeSpot(slot);
			if (emptySlot == -1) {

				System.out.println("Slot jest pelen, podaj inny: ");

			}
		} while (emptySlot == -1);
		setHoleState(emptySlot, slot, player.getPlayerId()); // gracz
		setLastSlot(slot);
		setLastSpot(emptySlot);
	}

	public synchronized void done() {
		notifyAll();
	}
}
