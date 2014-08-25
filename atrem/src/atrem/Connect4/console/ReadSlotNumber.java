package atrem.Connect4.console;

import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.board.HoleState;

public class ReadSlotNumber implements Runnable {
	GameController game;
	private KeyHandler keyHandler;

	@Override
	public void run() {
		int slots = keyHandler.getSlot();
		game.wykonalemRuch(HoleState.PLAYER1, slots);
	}

}
