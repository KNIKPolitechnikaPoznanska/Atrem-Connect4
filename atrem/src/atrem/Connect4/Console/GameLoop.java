package atrem.Connect4.Console;

import java.util.Scanner;

import atrem.Connect4.Game.Board;
import atrem.Connect4.Game.Logic;
import atrem.Connect4.Game.Player;

public class GameLoop {
	Board board;
	private GUI gui = new GUI();
	Scanner in = new Scanner(System.in);
	private Logic logic;
	private Player player1, player2;

	GameLoop(Board board, Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.board = board;

	}

	public void go(Board board, Player player) {// do gui lub do gameloop
		int slot = 2; // = metoda CKeyHandler.getSlot
		int emptySlot = board.findFreeSpot(slot);
		board.setHoleState(emptySlot, slot, player.getPlayerId()); // gracz

	}

}
