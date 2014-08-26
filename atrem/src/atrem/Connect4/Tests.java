package atrem.Connect4;

import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.GameFactory;
import atrem.Connect4.console.GameLoop;
import atrem.Connect4.console.Menu;

public class Tests {

	private static GameFactory gamefactory;
	private static Menu menu;
	private static Game game;
	private static GameLoop gameloop;

	public static void main(String[] args) {
		gamefactory = new GameFactory();
		menu = new Menu();
		menu.loadSettings();
		gamefactory.setMenu(menu);
		gamefactory.createGame();
		game = gamefactory.getGame();

		gameloop = new GameLoop(game);
		// gameloop.startLoop();

	}
}
