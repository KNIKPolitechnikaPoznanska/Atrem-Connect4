package atrem.Connect4.Console;

import atrem.Connect4.Game.Board;
import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.Logic;
import atrem.Connect4.Game.PlayerController;

/*
 * G³ówna pêtla gry
 * wykorzystywana tylko w konsoli
 * obs³uguj¹ca kolejki graczy
 */
public class GameLoop {
	private GUI gui = new GUI();
	private Game game;
	private CKeyHandler keyHandler = new CKeyHandler();
	private Logic logic;
	private int doneMoves;

	public GameLoop(Game game) {
		this.game = game;
		logic = new Logic(game);
	}

	public void startLoop() {
		doneMoves = 0;
		while (!logic.checkIfWin() && !logic.checkIfDraw(doneMoves)) {
			gui.displayGame(game);
			if (game.getPlayerTurn() == 1) {
				this.go(game.getBoard(), game.getPlayer1());
				game.setPlayerTurn(2);
			} else // (game.getPlayerTurn() == 2) {
			{
				this.go(game.getBoard(), game.getPlayer2());
				game.setPlayerTurn(1);
			}
			doneMoves++;

		}
		gui.displayResults(game);
	}

	public void go(Board board, PlayerController player) {// do gui lub do
															// gameloop
		int emptySlot;
		int slot;
		do {
			slot = player.getSlots(board.getSlots()); // = metoda
														// CKeyHandler.getSlot
			emptySlot = board.findFreeSpot(slot);
			if (emptySlot == -1) {
				gui.writeFullSlots();
			}
		} while (emptySlot == -1);
		board.setHoleState(emptySlot, slot, player.getPlayerId()); // gracz
	}

}