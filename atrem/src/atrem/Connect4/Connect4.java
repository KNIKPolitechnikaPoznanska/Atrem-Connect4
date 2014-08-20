package atrem.Connect4;

import atrem.Connect4.Console.GameLoop;
import atrem.Connect4.Console.Menu;
import atrem.Connect4.Game.Board;
import atrem.Connect4.Game.Player;

public class Connect4 {

	private static Player player1, player2;
	private static GameLoop gameloop;
	private static Board board;
	private static Menu menu;

	public static void main(String[] args) {
		menu = new Menu(board, player1, player2);
		board = menu.getBoard();
		player1 = menu.getPlayer1();
		player2 = menu.getPlayer2();
		gameloop = new GameLoop(board, player1, player2);// zamienic na met
															// start

	}
}
