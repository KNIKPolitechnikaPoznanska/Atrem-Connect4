package atrem.Connect4.Game;

import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.player.PlayerController;

public class GameController {
	// public void wykonalemRuch(HoleState playerId, int slot);\
	private Game game;

	private Logic logic;
	private Board board;
	private int doneMoves;
	private PlayerController player1, player2;
	private int emptySpot;
	private int playerTurn = 1;

	public void loadGameController(Game game) {
		this.game = game;
		this.logic = game.getLogic();
		this.board = game.getBoard();
		this.player1 = game.getPlayer1();
		this.player2 = game.getPlayer2();
	}

	public int getPlayerTurn() {
		return playerTurn;
	}

	public void setPlayerTurn(int playerTurn) {
		this.playerTurn = playerTurn;
	}

	public int getEmptySpot() {
		return emptySpot;
	}

	public Game getGame() {
		return game;
	}

	public ResultState getResult() {
		return game.getResult();
	}

	public synchronized void go(PlayerController player, int slot) {
		emptySpot = board.findFreeSpot(slot);
		if (emptySpot == -1) {
			return;
		}
		board.setHoleState(emptySpot, slot, player.getPlayerId()); // gracz
		board.setLastSlot(slot);
		board.setLastSpot(emptySpot);

	}

	public void move() {
		int currentSlot;

		if (getPlayerTurn() == 1) {
			currentSlot = player1.loadSlotNumber();
			this.go(player1, currentSlot);
			setPlayerTurn(2);
		}
		if (getPlayerTurn() == 2) {
			currentSlot = player2.loadSlotNumber();
			this.go(player2, currentSlot);
			setPlayerTurn(1);
			doneMoves++;
			logic.checkResult(currentSlot);
		}
	}

	// public void madeMouve

	// public synchronized void done() {
	// notifyAll();ryt
	// }

	// public synchronized void go(PlayerController player) { // wywalic z
	// konsoli
	// // uniwersalne
	// thread = Executors.newSingleThreadExecutor();
	// final PlayerController player2 = player;
	//
	// int slot;
	// do {
	//
	// // slot = player.getCurrentSlot(); // CKeyHandler.getSlot
	//
	// thread.execute(new Runnable() { // bla
	// @Override
	// public void run() {
	// player2.getSlotNumber();
	// done();
	//
	// }
	// });
	// try {
	//
	// wait();
	// } catch (InterruptedException e) {
	//
	// e.printStackTrace();
	// }
	// slot = choosedSlot;
	// emptySpot = board.findFreeSpot(slot);
	// if (emptySpot == -1) {
	//
	// System.out.println("Slot jest pelen, podaj inny: ");
	//
	// }
	// } while (emptySpot == -1);
	// board.setHoleState(emptySpot, slot, player.getPlayerId()); // gracz
	// board.setLastSlot(slot);
	// board.setLastSpot(emptySpot);
	// thread.shutdown();
	// }

}
