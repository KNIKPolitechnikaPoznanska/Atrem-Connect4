package atrem.connect4;

import atrem.connect4.console.Menu;
import atrem.connect4.game.GameConfig;
import atrem.connect4.game.GameFactory;

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
