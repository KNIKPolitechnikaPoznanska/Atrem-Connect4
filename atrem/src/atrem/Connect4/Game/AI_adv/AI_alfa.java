package atrem.Connect4.Game.AI_adv;

import atrem.Connect4.Game.Board;
import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.Logic;
import atrem.Connect4.Game.player.PlayerController;

public class AI_alfa {

	private AI_alfa[][] gameBoard;
	private int slots;
	private int rows;
	private Logic logic;
	private Game game;
	private Board board;
	private PlayerController player1;

	public AI_alfa(Game game) {

		slots = game.getBoard().getSlots();
		rows = game.getBoard().getRows();
		this.game = game;
		this.board = game.getBoard();
		this.evaluateNextMouve();

	}

	public int evaluateNextMouve() {

		for (int slot = 0; slot < slots; slot++) {
			board.findFreeSpot(slot);

		}
		return 0;
	}

	private Board nextMouve(Board nextBoard) {
		this.go(nextBoard,)
		return nextBoard;
	}

	private void go(Board board, PlayerController player, int slot) {// do gui
																		// lub
																		// do
		// gameloop
		int emptySlot;
		// int slot;
		do {
			// slot = player.getSlots(board.getSlots()); // = metoda
			// CKeyHandler.getSlot
			emptySlot = board.findFreeSpot(slot);
			if (emptySlot == -1) {
				return;
			}
		} while (emptySlot == -1);
		board.setHoleState(emptySlot, slot, player.getPlayerId()); // gracz
	}

}