package atrem.connect4s;

import atrem.connect4s.Games.GameController;
import atrem.connect4s.Games.GameFactory;
import atrem.connect4s.swing.GameConfig;

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
