package atrem.connect4;

import atrem.connect4.factory.GameFactory;
import atrem.connect4.game.GameConfig;
import atrem.connect4.game.GameController;

/*
 * Uruchomienie gry Connect4 w konsoli
 */
public class Connect4Swing {
	private GameController gameController;

	public void init(GameConfig config, GameFactory gameFactory) {
		config.setupGameFactory();
		gameFactory.createGameController();
		gameController = gameFactory.getGameController();
		gameController.startGameLoop();
	}
}
