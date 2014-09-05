package atrem.Connect4;

import atrem.Connect4.Game.GameFactory;
import atrem.Connect4.console.Menu;

/*
 * Uruchomienie gry Connect4 w konsoli
 */
public class Connect4Console {
	private GameFactory gameFactory;
	private Menu menu;

	public void init(Menu menu, GameFactory gameFactory) {
		this.gameFactory = gameFactory;
		gameFactory.createGameController();
	}
}
