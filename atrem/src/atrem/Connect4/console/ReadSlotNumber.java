package atrem.Connect4.console;

import atrem.Connect4.Game.GameController;

public class ReadSlotNumber implements Runnable {
	GameController game;
	private KeyHandler keyHandler;

	@Override
	public void run() {
		int slots = keyHandler.getSlot();
		// game.wykonalemRuch(HoleState.PLAYER1, slots);
	}

}
