package atrem.Connect4;

import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.GameFactory;
import atrem.Connect4.swing.GameConfig;

/*
 * Uruchomienie gry Connect4 w konsoli
 */
public class Connect4Swing {
	private static GameController gameController;

	public void init(GameConfig config, GameFactory gameFactory) {
		config.setupGameFactory();
		// gameFactory.createGame("swing");
		gameFactory.createGameController();
		gameController = gameFactory.getGameController();
		gameController.startGameLoop();
	}
}
