package atrem.Connect4;

import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.GameFactory;

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
