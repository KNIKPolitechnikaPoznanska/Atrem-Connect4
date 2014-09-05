package atrem.connect4s.console;

import atrem.connect4s.Games.GameController;

public class ReadSlotNumber implements Runnable {
	GameController game;
	private KeyHandler keyHandler;

	@Override
	public void run() {
		int slots = keyHandler.getSlot();
		// game.wykonalemRuch(HoleState.PLAYER1, slots);
	}

}
