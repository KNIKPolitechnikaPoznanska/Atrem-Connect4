package atrem.Connect4;

import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.GameFactory;
import atrem.Connect4.swing.SwingConfig;
import atrem.Connect4.swing.SwingPresenter;

/*
 * Klasa main uruchamiaj¹ca grê Connect4
 */
public class Connect4Swing implements Runnable {
	private static GameFactory gameFactory;
	private static SwingConfig config;
	private static GameController gameController;
	private static SwingPresenter swingPresenter1, swingPresenter2;

	public static void main(String[] args) {
<<<<<<< HEAD
		gamefactory = new GameFactory();
		config = new SwingConfig();
		// InitializeConfig();
		gamefactory.setSwingconfig(config);
		gamefactory.createGame("swing");
		game = gamefactory.getGame();
		gameController = new GameController();
		gameController.loadGameController(game);
		swingPresenter = new SwingPresenter();
		swingPresenter.setPresenter(game, gameController);
=======
		gameFactory = new GameFactory();
		InitializeConfig();
>>>>>>> branch 'master' of https://github.com/KNIKPolitechnikaPoznanska/AtremProject.git
	}

	private static synchronized void runGame() {
		gameFactory.setSwingconfig(config);
		gameFactory.createGame("swing");
		gameFactory.loadGameController();
		gameController = gameFactory.getGameController();
		// gameController.gameLoop();
	}

	private static void InitializeConfig() {

		config = new SwingConfig();

		config.setDBox();
	}

	@Override
	public void run() {
		runGame();
	}
}
