package atrem.Connect4;

import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.GameFactory;
import atrem.Connect4.swing.SwingConfig;

/*
 * Klasa main uruchamiaj¹ca grê Connect4
 */
public class Connect4 {
	private static GameFactory gameFactory;
	private static GameController gameController;
	private static SwingConfig config; // zmieniæ nazwe SwingConfig na
										// GameConfig
	private static boolean saved = false;

	public static void main(String[] args) {
		gameFactory = new GameFactory();
		config = new SwingConfig(gameFactory);
		config.setDBox();
		gameFactory.createPlayerGame();
		while (!saved) {
			try {
				Thread.currentThread().wait();
			} catch (InterruptedException e) {
			}
		}
		gameFactory.loadGameController();
		gameController = gameFactory.getGameController();
		gameController.gameLoop();

	}

	public static boolean isSaved() {
		return saved;
	}

	public static void setSaved(boolean isSaved) {
		Connect4.saved = isSaved;
	}
}
