package atrem.connect4.console;

import atrem.connect4.game.GameController;

public class ReadSlotNumber implements Runnable {
	GameController game;
	private KeyHandler keyHandler;

	@Override
	public void run() {
		int slots = keyHandler.getSlot();
		// game.wykonalemRuch(HoleState.PLAYER1, slots);
	}

}
