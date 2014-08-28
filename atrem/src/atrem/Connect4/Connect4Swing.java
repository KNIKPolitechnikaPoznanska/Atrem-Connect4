package atrem.Connect4;

import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.GameFactory;
import atrem.Connect4.swing.SwingConfig;
import atrem.Connect4.swing.SwingPresenter;

/*
 * Klasa main uruchamiaj¹ca grê Connect4
 */
public class Connect4Swing {
	private static GameFactory gamefactory;
	private static SwingConfig config;
	private static Game game;
	private static GameController gameController;
	private static SwingPresenter swingPresenter;

	public static void main(String[] args) {
		gamefactory = new GameFactory();
		config = new SwingConfig();
		config.loadSettings();
		gamefactory.setSwingconfig(config);
		gamefactory.createGame("swing");
		game = gamefactory.getGame();

		gameController = new GameController();
		gameController.loadGameController(game);
		swingPresenter = new SwingPresenter();
		swingPresenter.setPresenter(game, gameController);

	}
}
