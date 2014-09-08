package atrem.connect4;

import atrem.connect4.game.GameConfig;
import atrem.connect4.game.GameController;
import atrem.connect4.game.GameFactory;

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
