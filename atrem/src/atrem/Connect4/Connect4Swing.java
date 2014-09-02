package atrem.Connect4;

import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.GameFactory;
import atrem.Connect4.swing.SwingConfig;

/*
 * Uruchomienie gry Connect4 w konsoli
 */
public class Connect4Swing {
	private static GameFactory gameFactory;
	private static SwingConfig config;
	private static GameController gameController;

	public static void main(String[] args) {
		gameFactory = new GameFactory();
		config = new SwingConfig(gameFactory);
		config.setDBox();
	}

	public void init() {

	}

	public static void runGame() {
		config.setupGameFactory();
		gameFactory.createGame("swing");
		gameFactory.loadGameController();
		gameController = gameFactory.getGameController();
		gameController.gameLoop();
	}
}
