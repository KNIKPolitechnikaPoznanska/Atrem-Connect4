package atrem.Connect4;

import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.GameFactory;
import atrem.Connect4.console.Menu;

/*
 * Klasa main uruchamiaj�ca gr� Connect4
 */
public class Connect4 {

	private static GameFactory gamefactory;
	private static Menu menu;
	private static Game game;
	private static GameController gameController;

	public static void main(String[] args) {
		gamefactory = new GameFactory();
		menu = new Menu();
		menu.loadSettings();
		gamefactory.setMenu(menu);
		gamefactory.createGame();
		game = gamefactory.getGame();
<<<<<<< HEAD
		gameController = new GameController();
		gameController.setGameController(game);
		gameController.Loop();
=======

		gameloop = new GameLoop(game);
		// gameloop.startLoop();
>>>>>>> branch 'master' of https://github.com/KNIKPolitechnikaPoznanska/AtremProject.git

	}
}
