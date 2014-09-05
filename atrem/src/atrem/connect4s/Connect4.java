package atrem.connect4s;

import atrem.connect4s.Games.GameFactory;
import atrem.connect4s.console.Menu;
import atrem.connect4s.swing.GameConfig;

/*
 * Klasa main uruchamiaj¹ca grê Connect4hhh
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
