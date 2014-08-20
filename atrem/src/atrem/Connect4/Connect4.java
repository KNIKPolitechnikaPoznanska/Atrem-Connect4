package atrem.Connect4;

import atrem.Connect4.Console.GameLoop;
import atrem.Connect4.Console.Menu;
import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.GameFactory;

public class Connect4 {

	private static GameFactory gamefactory = new GameFactory();
	private static Menu menu;
	private static Game game;
	private static GameLoop gameloop;

	public static void main(String[] args) {
		menu = new Menu();
		menu.loadSettings();

		gamefactory.setGameFactory(game, menu.getRows(), menu.getSlots(),
				menu.getPlayer1name(), menu.getPlayer2name());
		gameloop = new GameLoop(game);
		gameloop.startLoop();

	}
}
