package test.RMITest;

import atrem.connect4.factory.GameFactory;
import atrem.connect4.game.GameController;

/*
 * Uruchomienie gry Connect4 w konsoli
 */
public class Connect4Console {
	private GameFactory gameFactory;
	private GameController gameController;

	public Connect4Console(GameFactory gameFactory) {
		this.gameFactory = gameFactory;
	}

	public void init() {
		gameFactory.createGameController();
		gameController = gameFactory.getGameController();
		gameController.startGameLoop();
	}
}
