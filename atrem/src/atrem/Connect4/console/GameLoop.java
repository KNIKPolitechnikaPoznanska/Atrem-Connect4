package atrem.Connect4.console;

import java.util.Random;

import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.Logic;
import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.player.PlayerController;

/*
 * G³ówna pêtla gry
 * wykorzystywana tylko w konsoli
 * obs³uguj¹ca kolejki graczy
 */
public class GameLoop {
	private int doneMoves;
	private Game game;
	private GUIConsole gui = new GUIConsole();
	private Logic logic;
	private Random rnd = new Random();

	public GameLoop(Game game) {
		this.game = game;
		logic = new Logic(game);
		game.setPlayerTurn(genFirstTurn());
	}

	/**
	 * 
	 * @return gracz, ktory rozpoczyna gre
	 */
	private int genFirstTurn() {
		if (rnd.nextGaussian() < 0.0D) {
			return 1;
		} else {
			return 2;
		}
	}

	public void go(Board board, PlayerController player) {
		int emptySlot;
		int slot;
		do {
			slot = player.getSlotNumber(); // CKeyHandler.getSlot
			emptySlot = board.findFreeSpot(slot);
			if (emptySlot == -1) {
				gui.writeFullSlots();
			}
		} while (emptySlot == -1);
		board.setHoleState(emptySlot, slot, player.getPlayerId()); // gracz
	}

	public void startLoop() {
		doneMoves = 0;
		while (!logic.checkResult(doneMoves)) {
			gui.displayGame(game);
			if (game.getPlayerTurn() == 1) {
				this.go(game.getBoard(), game.getPlayer1());
				game.setPlayerTurn(2);
			} else if (game.getPlayerTurn() == 2) {
				this.go(game.getBoard(), game.getPlayer2());
				game.setPlayerTurn(1);
			}
			doneMoves++;
		}
		gui.displayResults(game);
	}

}