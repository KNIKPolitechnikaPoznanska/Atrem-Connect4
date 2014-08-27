package atrem.Connect4.Game;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.player.PlayerController;
import atrem.Connect4.console.GUIConsole;

public class GameController {
	// public void wykonalemRuch(HoleState playerId, int slot);\
	private Game game;
	private Logic logic;
	private Board board;
	private int doneMoves;
	private GUIConsole gui;
	private PlayerController player1, player2;
	private ExecutorService thread;

	private int choosedSlot;
	private int PlayerTurn = 1;

	public void loadGameController(Game game) {
		this.game = game;
		this.logic = game.getLogic();
		this.board = game.getBoard();
		this.player1 = game.getPlayer1();
		this.player2 = game.getPlayer2();
		gui = new GUIConsole();

	}

	public void Loop() { // wywalic z konsoli
		doneMoves = 0;
		while (!logic.checkResult(doneMoves)) {
			gui.displayGame(game, this);
			if (getPlayerTurn() == 1) {

				this.go(player1);
				setPlayerTurn(2);
			} else if (getPlayerTurn() == 2) {
				this.go(player2);
				setPlayerTurn(1);
			}
			doneMoves++;
		}
		gui.displayResults(game);
	}

	public int getChoosedSlot() {
		return choosedSlot;
	}

	public void setChoosedSlot(int choosedSlot) {
		this.choosedSlot = choosedSlot;
	}

	public int getPlayerTurn() {
		return PlayerTurn;
	}

	public void setPlayerTurn(int playerTurn) {
		PlayerTurn = playerTurn;
	}

	public synchronized void go(PlayerController player) { // wywalic z konsoli
		// uniwersalne
		thread = Executors.newSingleThreadExecutor();
		final PlayerController player2 = player;
		int emptySlot;
		int slot;
		do {

			// slot = player.getCurrentSlot(); // CKeyHandler.getSlot

			thread.execute(new Runnable() { // bla
				@Override
				public void run() {
					player2.getSlotNumber();
					done();

				}
			});
			try {

				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			slot = choosedSlot;
			emptySlot = board.findFreeSpot(slot);
			if (emptySlot == -1) {

				System.out.println("Slot jest pelen, podaj inny: ");

			}
		} while (emptySlot == -1);
		board.setHoleState(emptySlot, slot, player.getPlayerId()); // gracz
		board.setLastSlot(slot);
		board.setLastSpot(emptySlot);
		thread.shutdown();
	}

	public synchronized void done() {
		notifyAll();
	}
}
