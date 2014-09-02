package atrem.Connect4;

import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.GameFactory;
import atrem.Connect4.console.Menu;

/*
 * Uruchomienie gry Connect4 w konsoli
 */
public class Connect4Console {
	private static GameFactory gameFactory;
	private static Menu menu;
	private static GameController gameController;

	public static void main(String[] args) {
		gameFactory = new GameFactory();
		menu = new Menu();
		menu.loadSettings();
		gameFactory.setMenu(menu);
		gameFactory.createGame("console");
		gameFactory.loadGameController();
		gameController = gameFactory.getGameController();
		gameController.gameLoop();
	}

	public static void init() {
		gameFactory = new GameFactory();
		menu = new Menu();
		menu.loadSettings();
		gameFactory.setMenu(menu);
		gameFactory.createGame("console");
		gameFactory.loadGameController();
		gameController = gameFactory.getGameController();
		gameController.gameLoop();
	}
}
