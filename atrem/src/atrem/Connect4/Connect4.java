package atrem.Connect4;

import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.GameFactory;
import atrem.Connect4.console.Menu;

/*
 * Klasa main uruchamiaj¹ca grê Connect4
 */
public class Connect4 {

	private static GameFactory gamefactory;
	private static Menu menu;
	private static GameController gameController;

	public static void main(String[] args) {
		System.out.println("test2");
		gamefactory = new GameFactory();
		menu = new Menu();
		menu.loadSettings();
		gamefactory.setMenu(menu);
		gamefactory.createGame("console");
		// game = gamefactory.getGame();
		gamefactory.loadGameController();
		gameController = gamefactory.getGameController();
		
		gameController.gameLoop();

	}
}
