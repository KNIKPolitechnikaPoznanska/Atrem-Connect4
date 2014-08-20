package atrem.Connect4.Console;

import atrem.Connect4.Game.Board;
import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.Player;

public class GameLoop {
	private GUI gui = new GUI();
	private Game game;

	public GameLoop(Game game) {
		this.game = game;
	}

	public void startLoop() {
		while (true) {

			return;
		}
	}

	public void go(Board board, Player player) {// do gui lub do gameloop
		int slot = 2; // = metoda CKeyHandler.getSlot
		int emptySlot = board.findFreeSpot(slot);
		board.setHoleState(emptySlot, slot, player.getPlayerId()); // gracz
	}

}
