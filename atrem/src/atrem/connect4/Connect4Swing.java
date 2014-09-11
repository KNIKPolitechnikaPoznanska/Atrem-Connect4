package atrem.connect4;

import atrem.connect4.factory.GameConfig;
import atrem.connect4.game.GameController;

/*
 * Uruchomienie gry Connect4 w konsoli
 */
public class Connect4Swing {
	private GameController gameController;

	public void init(GameConfig config,
			atrem.connect4.factory.GameFactory gameFactory) {
		config.setupGameFactory();
		gameFactory.createGameController();
		gameController = gameFactory.getGameController();
		gameController.startGameLoop();
	}
}
