package atrem.Connect4.console;

import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.player.PlayerController;

public class Task implements Runnable {

	private PlayerController player;

	private Board board;

	// private PlayerConsole player1;

	public Task(PlayerController player, Board board) {
		this.player = player;
		this.board = board;
		// this.player1 = (PlayerConsole) player;
	}

	@Override
	public void run() {
		player.getSlotNumber();
		board.done();
	}
}
