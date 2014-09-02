package atrem.Connect4;

import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.GameFactory;
import atrem.Connect4.swing.SwingConfig;

/*
 * Klasa main uruchamiaj¹ca grê Connect4
 */
public class Connect4Swing implements Runnable {
	private static GameFactory gameFactory;
	private static SwingConfig config;
	private static GameController gameController;

	public static void main(String[] args) {
		gameFactory = new GameFactory();
		InitializeConfig();
	}

	private static void runGame() {
		gameFactory.setSwingconfig(config);
		gameFactory.createGame("swing");
		gameFactory.loadGameController();
		gameController = gameFactory.getGameController();
		// try {
		// GameFrame frame = new GameFrame();
		// frame.setVisible(true);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// // gameController.gameLoop();
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
