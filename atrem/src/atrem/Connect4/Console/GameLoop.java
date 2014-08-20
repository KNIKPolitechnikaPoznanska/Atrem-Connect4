package atrem.Connect4.Console;

import atrem.Connect4.Game.Board;
import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.Player;

public class GameLoop {
	private GUI gui = new GUI();
	private Game game;
	private CKeyHandler keyHandler = new CKeyHandler();

	public GameLoop(Game game) {
		this.game = game;
	}

	public void startLoop() {
		while (true) {
			gui.displayGame(game);
			if (game.getPlayerTurn() == 1) {
				this.go(game.getBoard(), game.getPlayer1());
				game.setPlayerTurn(2);
			} else // (game.getPlayerTurn() == 2) {
			{
				this.go(game.getBoard(), game.getPlayer2());
				game.setPlayerTurn(1);
			}

		}
	}

	public void go(Board board, Player player) {// do gui lub do gameloop
		int emptySlot;
		int slot;
		do {
			slot = keyHandler.getSlot(board); // = metoda CKeyHandler.getSlot
			emptySlot = board.findFreeSpot(slot);
		} while (emptySlot == -1);
		board.setHoleState(emptySlot, slot, player.getPlayerId()); // gracz
	}

	private void turnPlayer() {

	}
}
