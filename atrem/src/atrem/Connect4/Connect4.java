package atrem.Connect4;

import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.GameFactory;
import atrem.Connect4.swing.SwingConfig;

/*
 * Klasa main uruchamiaj�ca gr� Connect4
 */
public class Connect4 {
	private static GameFactory gameFactory;
	private static GameController gameController;
	private static SwingConfig config; // zmieni� nazwe SwingConfig na
										// GameConfig

	public static void main(String[] args) {
		gameFactory = new GameFactory();
		config = new SwingConfig(gameFactory);
		config.setDBox();
	}
}
