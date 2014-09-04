package atrem.Connect4;

import atrem.Connect4.Game.GameFactory;
import atrem.Connect4.console.Menu;
import atrem.Connect4.swing.GameConfig;

/*
 * Klasa main uruchamiaj¹ca grê Connect4
 */
public class Connect4 {
	private static GameFactory gameFactory;
	private static GameConfig config;
	private static Menu menu;

	public static void main(String[] args) {
		if (args.length > 0) {
			gameFactory = new GameFactory();
			menu = new Menu(gameFactory);
			menu.runGame();
		} else {
			gameFactory = new GameFactory();
			config = new GameConfig(gameFactory);
			config.setDBox();
		}
	}
}
