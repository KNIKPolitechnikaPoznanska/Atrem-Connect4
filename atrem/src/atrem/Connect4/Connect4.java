package atrem.Connect4;

import atrem.Connect4.Game.GameFactory;
import atrem.Connect4.swing.GameConfig;

/*
 * Klasa main uruchamiaj�ca gr� Connect4
 */
public class Connect4 {
	private static GameFactory gameFactory;
	// private static GameController gameController;
	private static GameConfig config; // zmieni� nazwe SwingConfig na
										// GameConfig

	public static void main(String[] args) {
		gameFactory = new GameFactory();
		config = new GameConfig(gameFactory);
		config.setDBox();
	}
}
