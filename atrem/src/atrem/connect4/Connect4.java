package atrem.connect4;

import atrem.connect4.console.Menu;
import atrem.connect4.game.GameConfig;
import atrem.connect4.game.GameFactory;
import atrem.connect4.swing.MenuFrame;

/*
 * Klasa main uruchamiaj¹ca grê Connect4hhh
 */
public class Connect4 {
	private static GameFactory gameFactory;
	private static GameConfig config;
	private static Menu menu;
	private MenuFrame menuFrame;

	public Connect4() {
		// if (args.length > 0) {
		// gameFactory = new GameFactory();
		// menu = new Menu(gameFactory);
		// menu.runGame();
		// } else {
		System.out.println("jjj");
		gameFactory = new GameFactory();
		config = new GameConfig(gameFactory);
		config.setDBox();
		// }
	}
}
