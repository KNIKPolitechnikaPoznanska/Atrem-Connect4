package atrem.Connect4;

import atrem.Connect4.Console.GameLoop;
import atrem.Connect4.Console.Menu;
import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.GameFactory;

/*
 * Klasa main uruchamiaj¹ca grê Connect4
 */
public class Connect4 {

	private static GameFactory gamefactory;
	private static Menu menu;
	private static Game game;
	private static GameLoop gameloop;

	public static void main(String[] args) {
		gamefactory = new GameFactory();
		menu = new Menu();
		game = new Game();
		menu.loadSettings();

		gamefactory.setGameFactory(game, menu.getRows(), menu.getSlots(),
				menu.getPlayer1name(), menu.getPlayer2name(),
				menu.getOpponent());
		gameloop = new GameLoop(game);
		gameloop.startLoop();

	}
}
